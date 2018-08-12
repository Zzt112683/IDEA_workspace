<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>regist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style2.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        var boo = true;
        var time = 11;
        var inter;
        function change() {
            if (boo){
                //两种生成随机图片的方法
                // document.getElementById('num').src = 'image?'+(new Date()).getTime()
                document.getElementById('num').src = 'image?' + Math.random();
                document.getElementById("time").innerHTML = --time;
                inter = setInterval(function () {
                    document.getElementById("time").innerHTML = --time;
                    if (time == 0){
                        clearInterval(inter);
                        document.getElementById("time").innerHTML = "";
                        boo = true;
                        time = 11;
                    }
                },1000);
                boo = false;
            }
        }
        function checkUsername() {
            //获得输入的用户名
            var username = $("[name='username']").val();
            if (username.trim() == ""){
                $("#checkUsername").html("用户名不能为空").css("color","red");
            }else {
                $.ajax({
                    "url":"checkusername",
                    "type":"get",
                    "data":"username="+username,
                    "success":function (data) {
                        data = data.trim();
                        if (data == "true"){
                            $("#checkUsername").html("√").css("color","green");
                        }else {
                            $("#checkUsername").html("用户名已存在").css("color","red");
                        }
                    }
                });
            }
        }
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
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
                注册
            </h1>
            <form action="login.html" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username"  onblur="checkUsername();"/>
                            <span id="checkUsername"></span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            真实姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd" />
                        </td>
                    </tr><tr>
                    <td valign="middle" align="right">
                        确认密码:
                    </td>
                    <td valign="middle" align="left">
                        <input type="password" class="inputgri" name="pwd2" />
                    </td>
                </tr>
                    <tr>
                        <td valign="middle" align="right">
                            性别:
                        </td>
                        <td valign="middle" align="left">
                            男
                            <input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
                            女
                            <input type="radio" class="inputgri" name="sex" value="f"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                            <img id="num" src="image" />
                            <span id="time"></span>
                            <a href="javascript:;" onclick="change();">换一张</a>
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="number" />
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;" disabled="disabled"/>
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

