<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/23
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="container">
    <div class="page-header">

        <button id="Btn">da</button>
    </div>


</div>

<script src="static/js/cryptojs/jquery-3.0.0.min.js"></script>

<script>
    $(function () {
        $("#Btn").click(function () {
            $.ajax({

                url: "/ajax",
                type: "post",
                data: {"name": "Tom"},
                success: function (data) {
                    console.log("成功");
                },
                error: function () {
                    alert("失败")
                },
                complete: function () {
                    console.log("complete function");
                },
                beforeSend: function () {
                    console.log("before");
                }


            });

        });
    })

</script>
</body>
<head>
    <title>Title</title>
    <link rel="stylesheet " href="static/css/bootstrap.min.css">
</head>
</html>
