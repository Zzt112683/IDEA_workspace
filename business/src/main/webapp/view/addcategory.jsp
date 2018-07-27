<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="category" method="post">
		<input type="hidden" name="operation" value="1" />
		<table align="center">
		<h1>添加商品类别</h1>
			<tr>
				<td>商品父类id名称</td>
				<td><input type="text" name="pt_id"/></td>
			</tr>
			<tr>
				<td>类别名称</td>
				<td><input type="text" name="cname"/></td>
			</tr>
			<tr>
				<td>商品状态</td>
				<td><input type="text" name="status"/></td>
			</tr>
			<tr>
				<td>排序</td>
				<td><input type="text" name="st_od"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="确认添加"/></td>
			</tr>
		</table>
	</form>
</body>
</html>