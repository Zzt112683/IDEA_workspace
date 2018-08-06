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
			<th>购物车id</th>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品描述</th>
			<th>商品价格</th>
			<th>商品规格</th>
			<th>商品图片</th>
			<th>商品数量</th>
			
			
		</tr>
		<c:forEach items="${carts}" var="cart">
			<tr>
			<th>${cart.id}</th>
			<th>${cart.product.id}</th>
			<th>${cart.product.name}</th>
			<th>${cart.product.detail}</th>
			<th>${cart.product.price}</th>
			<th>${cart.product.image}</th>
			<th>${cart.product.image}</th>
			<th>${cart.productnum}</th>
			
			<th>
				<a href="cart?operation=5&id=${cart.product.id}">修改商品数量</a>
            	<a href="cart?operation=4&id=${cart.id}">删除</a>
            	 
            </th>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>