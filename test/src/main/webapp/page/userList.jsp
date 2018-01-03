<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="../common/common.jsp"%>
<script type="text/javascript"	src="${basePath}/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"	src="${basePath}/jquery/jquery.form.js"></script>
<body>
	<table>
		<tr>
			<th>用户姓名</th>
			<th>用户账号</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.loginName}</td>
			</tr>
		</c:forEach>
	</table>
	<form id="user_form">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>账号</td>
				<td><input type="text" name="loginName" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" onclick="saveUser();" value="保存"/></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function saveUser(){
		$.ajax({
			type: 'POST',
			url: "${basePath}/user/saveUser", 
			data: $("#user_form").serialize(),
			dataType:'json',
			success: function(data){
				data = eval("("+data+")");
				if (data.status == 1) {
					alert("保存成功");
				} else if (data.status == 0) {
					alert("保存失败");
				} else {
					alert("网络异常");
				}
			}
		});
	}
</script>
</html>