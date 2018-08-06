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
	<table align="center">
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
		<c:forEach items="${pageModel.data}" var="product">
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
            	<a href="cart?operation=6&id=${product.id}">添加到购物车</a>
            </th>
		</tr>
		</c:forEach>
	</table>
	<c:forEach var="current" begin="1" end="${pageModel.totalPage}" step="1">
		<%-- <a href="product?operation=6&pageNo=${current}&operation=6">${current}</a> --%>
		<c:choose>
			<c:when test="${pageModel.currentPage==current}">
				<a style = "color: red" href="product?operation=6&pageNo=${current}&pageSize=3">${current}</a>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${pageModel.currentPage!=current}">
				<a href="product?operation=6&pageNo=${current}&pageSize=3">${current}</a>
			</c:when>
		</c:choose>
	</c:forEach>
	
</body>
</html>