<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cart" method="post">
		<input type="hidden" name="operation" value="3" />
		<input type="hidden" name="id" value="${product.id}" />
		<table align="center">
		<h1>修改商品数量</h1>
			<tr>
				<td>修改商品数量</td>
				<td><input type="text" name="pnum" value="${cart.productnum}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认修改"/></td>
			</tr>
		</table>
	</form>
</body>
</html>