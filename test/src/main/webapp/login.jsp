<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<%@include file="../common/common.jsp"%>
<script type="text/javascript"	src="${basePath}/jquery/jquery-1.4.4.min.js"></script>
<body>
	<div>
		<p>账号：<input type="text" id="loginName" value="aa"/></p>
		<p>密码：<input type="password" id="password" value="123"/></p>
		<p><input type="button" value="登录" onclick="userLogin();" /></p>
	</div>
</body>
<script type="text/javascript">
	function userLogin(){
		var loginName = $("#loginName").val();
		if (loginName == ''){
			alert("请输入账号");
			return false;
		}
		var password = $("#password").val();
		if (password == '') {
			alert("请输入密码");
			return false;
		}
		$.ajax({
			type: 'POST',
			url: "${basePath}/login/login", 
			data: {loginName:loginName,password:password},
			dataType:'json',
			success: function(data){
				data = eval("("+data+")");
				if (data.status == 1) {
					alert("登录成功");
					window.open("${basePath}/user/toUserList");
				} else if (data.status == 2) {
					alert("用户名或密码有误");
				} else if (data.status == 0) {
					alert("网络异常");
				} else {
					alert("网络异常aa");
				}
			}
		});
	}
</script>
</html>

