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
	<table>
		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品描述</th>
			<th>商品价格</th>
			<th>商品规格</th>
			<th>商品图片</th>
			<th>商品库存</th>
			<th>商品操作</th>
			
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
			<th>${product.id}</th>
			<th>${product.name}</th>
			<th>${product.detail}</th>
			<th>${product.price}</th>
			<th>${product.rule}</th>
			<th>${product.image}</th>
			<th>${product.stock}</th>
			<th>
            	<a href="product?operation=4&id=${product.id}">删除</a>
            	<a href="product?operation=5&id=${product.id}">修改</a>
            </th>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>