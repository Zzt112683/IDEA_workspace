<%@page import="javax.servlet.annotation.WebServlet"%>
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
	<form action="product" method="post">
		<input type="hidden" name="operation" value="3" />
		<input type="hidden" name="id" value="${product.id}" />
		<table align="center">
		<h1>修改商品</h1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="${product.name}"/></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="pdetail" value="${product.detail}"/></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${product.price}"/></td>
			</tr>
			<tr>
				<td>商品规格</td>
				<td><input type="text" name="rule" value="${product.rule}"/></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><input type="text" name="pimage" value="${product.image}"/></td>
			</tr>
			<tr>
				<td>商品库存</td>
				<td><input type="text" name="stock" value="${product.stock}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认修改"/></td>
			</tr>
		</table>
	</form>
</body>
</html>