<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>
		$(function () {

        })
	</script>
<title>Insert title here</title>
</head>
<body>
	
	<h1 style="text-align: center;">欢迎登录</h1>
	<form action="login" method="post">
		<table align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
