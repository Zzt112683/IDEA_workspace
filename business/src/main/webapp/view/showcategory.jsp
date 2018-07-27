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
	<form action="category" method="post">
		
		<table align="center">
		<h1>商品类别</h1>
			<tr>
			<th>商品父类id名称</th>
			<th>类别名称</th>
			<th>商品状态</th>
			<th>排序</th>
			<th>创建时间</th>
			<th>更新时间</th>
		</tr>
		
		<c:forEach items="${categorys}" var="category">
			<tr>
			<th>${category.parent_id}</th>
			<th>${category.name}</th>
			<th>${category.status}</th>
			<th>${category.sort_order}</th>
			<th>${category.creat_time}</th>
			<th>${category.update_time}</th>
			
			<th>
            	<a href="category?operation=4&id=${category.id}">删除</a>
            	<a href="category?operation=5&id=${category.id}">修改</a>
            </th>
		</tr>
		</c:forEach>
		
		</table>
		
	</form>
</body>
</html>