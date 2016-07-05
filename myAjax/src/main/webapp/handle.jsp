<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>演示</h3>
    </div>

    <div id="message"></div>
    <button id="btn">确认</button>


</div>

<script src="/static/js/cryptojs/jquery-3.0.0.min.js"></script>
<script src="/static/js/cryptojs/handlebars-v4.0.5.js"></script>
<script type="hand" id="msgTemp">

    <div class="panel panel-default">
            <div class="panel-heading">
                 {{name}}
              {{#if isVip}}
              <span class="text-danger">VIP</span>
              {{else}}
                 <span class="text-danger">⊙</span>
             {{/if}}
            </div>
               <div class="panel-body">
                  {{castion}}
                </div>
     </div>

</script>
<script>
    (function () {

        $("#btn").click(function () {
            var json = {"name": "张三", "castion": "晚上去玩",isVip:false};

            var $msg = $("#msgTemp").html();
            var temp = Handlebars.compile($msg);
            var html = temp(json);
            $("#message").prepend(html);

        })


    })()

</script>


</body>
</html>
