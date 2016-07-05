<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="../../favicon.ico">

    <title>登录系统</title>

    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">


    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }


    </style>
</head>

<body>

<div class="container">
    <c:choose>
        <c:when test="${param.error==1001}">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <strong>警告!</strong> 验证码错误
            </div>


        </c:when>


    </c:choose>

    <c:choose>
        <c:when test="${param.error==1002}">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <strong>警告!</strong> 用户名或密码错误
            </div>


        </c:when>


    </c:choose>

    <form class="form-signin" action="/login" method="post" id="submit">
        <h2 class="form-signin-heading">登录系统</h2>
        <label for="inputEmail" class="sr-only">账号</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="请输入用户名" required autofocus name="name">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required name="password">
        <div>
            <label>验证码</label>
            <input type="text" name="captcha">
            <a href="javascript:;" id="changepic"><img src="/captcha.png" id="captcha"></a>

        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="buttonBen">登录</button>
    </form>

</div>

<script src="/static/js/jquery-3.0.0.min.js"></script>
<script src="/static/js/crypto/core-min.js"></script>
<script src="/static/js/crypto/md5-min.js"></script>
<script>
    $(function () {

        $("#changepic").click(function () {

            $("#captcha").attr("src", "/captcha.png?t=" + new Date().getTime());

        });

        $("#buttonBen").click(function () {

            var pwd = $("#inputPassword").val();
            pwd = CryptoJS.MD5(pwd);
            $("#inputPassword").val(pwd);
            $("#submit").submit();

        })


    })


</script>

</body>
</html>
