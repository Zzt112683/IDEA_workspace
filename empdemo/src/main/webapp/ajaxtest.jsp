<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        function test() {
            $.ajax({"url":"ajaxtest",
                "type":"get",
                "data":"id=1&username=admin",
                "async":"false",
                "success":function (text) {
                    alert("请求成功")
                    alert(text);
                },
                "error":function () {
                    alert("请求失败")
                }
            });
        }
    </script>
</head>
<body>
    <button type="button" onclick="test();">测试</button>
</body>
</html>
