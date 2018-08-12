<%@ page import="com.neuedu.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style2.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        function login() {
            var username = $("[name='username']").val();
            var password = $("[name='password']").val();
            $.ajax({
                "url":"login",
                "type":"post",
                "data":"username="+username+"&password="+password,
                "success":function (data) {
                    data = data.trim();
                    if (data == "true"){
                        location.href = "emplist";
                    }else {
                        alert("用户名或错误");
                    }
                }
            });
        }
    </script>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2018-06-25
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
                login
            </h1>
            <form action="login" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" />
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="button" class="button" value="Submit &raquo;" onclick="login();"/>
                </p>
            </form>
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

