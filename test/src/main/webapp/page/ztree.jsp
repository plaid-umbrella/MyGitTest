<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<%@include file="../common/common.jsp"%>
	<HEAD>
		<TITLE> ZTREE DEMO </TITLE>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" href="${basePath}/plugin/zTree_v3-master/css/demo.css" type="text/css">
		<link rel="stylesheet" href="${basePath}/plugin/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="${basePath}/plugin/zTree_v3-master/css/metroStyle/metroStyle.css" type="text/css">

		<script type="text/javascript" src="${basePath}/jquery/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="${basePath}/plugin/zTree_v3-master/js/jquery.ztree.all.min.js"></script>
		<SCRIPT LANGUAGE="JavaScript">
			var zTreeObj;
			var setting = {
				async: {
					enable: true,
					type:"post",
					url: "${basePath}/purview/findPurviewList",
					autoParam: ["id=parentId"],
					dataFilter: ajaxDataFilter
				},	
				edit:{
					enable: true,
				//	showRemoveBtn: setRemoveBtn,
					showRenameBtn: false
					
				},
				callback: {
					onClick: zTreeOnClick,
					onExpand: zTreeOnExpand,
					beforeExpand: beforeExpand,
					beforeRemove: zTreeBeforeRemove
					//onAsyncSuccess : ztreeOnAsyncSuccess,
				},
				view: {
					addHoverDom: addHoverDom,
					removeHoverDom: removeHoverDom,
					selectedMulti: false
				}

			};
			
			var zNodes = [
								
				{name:"全部", id:0,open:false,isParent:true}
			];
			$(document).ready(function(){
				zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			});
			
			function ajaxDataFilter(treeId, parentNode, responseData) {
				var keysArr = [];
				var isParent = false;
				//alert(responseData);
				var data = eval("("+responseData+")");
				//alert(data.status);
			    if (responseData) {
			      for(var i =0; i < data.purviewList.length; i++) {
			    	 // alert(data.purviewList[i].name);
			    	  if (data.purviewList[i].parentId == 0) {
			    		  isParent = true;
			    	  } else {
			    		  isParent = false;
			    	  }
			    	  keysArr.push({
		                    id: data.purviewList[i].id,
		                    name: data.purviewList[i].name,
		                    parentId: data.purviewList[i].parentId,
		                    isParent:isParent
		                    //字符节点
		                    //tId:data.purviewList[i].id,
		                    //parentTId:data.purviewList[i].parentId
		              });
			      }
			    }
			    return keysArr;
			}; 
			
			function setRemoveBtn(treeId, treeNode) {
				
				return !treeNode.isParent;
			}
			function zTreeOnClick(event, treeId, treeNode){
				alert("treeId=" + treeId + '\ntreeNode.tId=' + treeNode.tId + '\ntreeNode.name=' + treeNode.name + '\nlevel=' + treeNode.level + '\ntreeNode.id=' + treeNode.id
						+ '\n parentId=' + treeNode.parentId + '\n name=' + treeNode.name + '\n id=' + treeNode.id
				
				);
				
				//treeNode.tId + ", " + treeNode.name
			}
			
			//Keep Single Path
			var curExpandNode = null;
			function beforeExpand(treeId, treeNode) {
				var pNode = curExpandNode ? curExpandNode.getParentNode():null;
				var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
					if (treeNode !== treeNodeP.children[i]) {
						zTree.expandNode(treeNodeP.children[i], false);
					}
				}
				while (pNode) {
					if (pNode === treeNode) {
						break;
					}
					pNode = pNode.getParentNode();
				}
				if (!pNode) {
					singlePath(treeNode);
				}

			}
			function singlePath(newNode) {
				if (newNode === curExpandNode) return;

				var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
						rootNodes, tmpRoot, tmpTId, i, j, n;

				if (!curExpandNode) {
					tmpRoot = newNode;
					while (tmpRoot) {
						tmpTId = tmpRoot.tId;
						tmpRoot = tmpRoot.getParentNode();
					}
					rootNodes = zTree.getNodes();
					for (i=0, j=rootNodes.length; i<j; i++) {
						n = rootNodes[i];
						if (n.tId != tmpTId) {
							zTree.expandNode(n, false);
						}
					}
				} else if (curExpandNode && curExpandNode.open) {
					if (newNode.parentTId === curExpandNode.parentTId) {
						zTree.expandNode(curExpandNode, false);
					} else {
						var newParents = [];
						while (newNode) {
							newNode = newNode.getParentNode();
							if (newNode === curExpandNode) {
								newParents = null;
								break;
							} else if (newNode) {
								newParents.push(newNode);
							}
						}
						if (newParents!=null) {
							var oldNode = curExpandNode;
							var oldParents = [];
							while (oldNode) {
								oldNode = oldNode.getParentNode();
								if (oldNode) {
									oldParents.push(oldNode);
								}
							}
							if (newParents.length>0) {
								zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
							} else {
								zTree.expandNode(oldParents[oldParents.length-1], false);
							}
						}
					}
				}
				curExpandNode = newNode;
			}

			function zTreeOnExpand(event, treeId, treeNode) {
				curExpandNode = treeNode;
			}
			
			var newCount = 1;
			function addHoverDom(treeId, treeNode) {
				var sObj = $("#" + treeNode.tId + "_span");
				if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
				var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
					+ "' title='add node' onfocus='this.blur();'></span>";
				sObj.after(addStr);
				var btn = $("#addBtn_"+treeNode.tId);
				if (btn) btn.bind("click", function(){
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
					return false;
				});
			};
			
			function removeHoverDom(treeId, treeNode) {
				$("#addBtn_"+treeNode.tId).unbind().remove();
			};
			function zTreeBeforeRemove(treeId, treeNode){
				alert("zTreeBeforeRemove");
				return true;
			}
			
		</SCRIPT>
	</HEAD>
	<BODY>
		<div>
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</BODY>
</HTML>