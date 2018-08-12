<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--enctype="multipart/form-data" 代表着让浏览器重新格式化表单--%>
    <form action="fileup" method="post" enctype="multipart/form-data">
        <input type="text" name="username"><br>
        <input type="file" name="file"><br>
        <input type="submit">
    </form>

</body>
</html>
