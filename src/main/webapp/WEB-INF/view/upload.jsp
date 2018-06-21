<%--
  Created by IntelliJ IDEA.
  User: AcY
  Date: 2018/6/2
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="file"/>
    <input id="name" type="text" name="name"/>
    <input id="imgs" type="text" name="imgs"/>
    <br><br><br>
    <button id="upload" type="button" onclick="uploadImg()" >测试上传图片到阿里云</button>
</form>
<script>
    /*
     ajax文件上传教程：
     https://blog.csdn.net/inuyasha1121/article/details/51915742
     */
    function uploadImg() {
        debugger
        $.ajax({
            type: "post",
            url: '/edoc/upload',
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data)
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }
</script>
</body>
</html>
