<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/uploader/webuploader.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>文件上传</h1>
    </div>
    <div id="picker">选择文件</div>

    <h3>文件列队</h3>
    <ul id="filelist"></ul>


    <button id="btn" class="btn btn-success">开始上传</button>
</div>


<script src="static/js/cryptojs/jquery-3.0.0.min.js"></script>
<script src="static/js/uploader/webuploader.min.js"></script>
<script type="myTemplate" id="myTemp">
    <div class="progress">
        <div class="progress-bar progress-bar-success" role="progressbar" style="width: 0%">
        </div>
    </div>

</script>
<script>
    $(function () {
        var uploader = WebUploader.create({
            swf: "/static/js/webuploader/Uploader.swf",
            server: "/upload",
            pick: '#picker',
            fileVal:"file"
        });

        uploader.on("fileQueued", function (file) {
            var xml = "<li id='" + file.id + "'>" + file.name + "</li> ";
            $("#filelist").append(xml);
        });

        uploader.on("uploadProgress", function (file, percentage) {
            percentage = parseInt(percentage * 100);
            var $li = $("#" + file.id);
            if ($li.find(".progress").length) {
                $li.find("progress.progress-bar").css("width", percentage + "%");
            } else {
                var template = $("#myTemp").html();
                $li.append(template);
            }
        });
        uploader.on("uploadSuccess", function (file) {
            $("#" + file.id).css("color", "#ccc");
        });
        //当文件上传失败
        uploader.on("uploadError", function (file) {
            $("#" + file.id).css("color", "darkred");
        });
        //无论文件上传成功或失败
        uploader.on("uploadComplete", function (file) {
        });

        $("#btn").click(function () {
            uploader.upload();
        })

    });


</script>


</body>
</html>
