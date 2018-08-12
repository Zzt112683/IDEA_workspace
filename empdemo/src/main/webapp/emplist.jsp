<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.entity.Emp" %>
<%@ page import="com.neuedu.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style2.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <%--<%
                        User user = (User) session.getAttribute("user");
                        if (user != null){

                            out.print(user.getUsername());
                        }else {
                    %>
                    <a href="login.jsp">请登录</a>
                    <%
                        }
                    %>--%>
                    <c:if test="${sessionScope.user != null}" var="boo">
                        欢迎，${user.username}<a href="exit">退出</a>
                    </c:if>
                    <c:if test="${!boo}">
                        <a href="login.jsp">请登录</a>
                    </c:if>
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Job
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <%--<%
                    List<Emp> empList = (List<Emp>)request.getAttribute("empList");
                %>
                <%
                    for (int i = 0; i < empList.size(); i++) {
                        if (i % 2 == 0){
                %>--%>
                <c:forEach items="${empList}" var="emp" varStatus="index">
                    <c:if test="${index.index % 2 == 0}" var="boo">
                        <tr class="row1">
                            <td>
                                ${emp.id}
                            </td>
                            <td>
                                ${emp.name}
                            </td>
                            <td>
                                ${emp.salary}
                            </td>
                            <td>
                                ${emp.job}
                            </td>
                            <td>
                                <a href="delete?id=${emp.id}">delete emp</a>&nbsp;<a href="updateEmpView?id=${emp.id}">update emp</a>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${!boo}">
                        <tr class="row2">
                            <td>
                                    ${emp.id}
                            </td>
                            <td>
                                    ${emp.name}
                            </td>
                            <td>
                                    ${emp.salary}
                            </td>
                            <td>
                                    ${emp.job}
                            </td>
                            <td>
                                <a href="delete?id=${emp.id}">delete emp</a>&nbsp;<a href="updateEmpView?id=${emp.id}">update emp</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
