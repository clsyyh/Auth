<%@page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>添加公告</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/addNotice.js"></script>
    <script type="text/javascript" src="../js/ckconfig.js"></script>
    <script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
</head>
<body>
<h3><b><strong>发布公告</strong></b></h3>
<form id="form" action="/addNotice" method="post">
    <input type="hidden" name="flag" value="2">
            <label>标题</label>
            <input type="text" name="title"/>

            <textarea name="content" id="notice" class="ckdeitor" cols="30" rows="10">

            </textarea>
            <!--
            <script type="text/javascript">
                CKEDITOR.replace('notice',{
                    uiColor:'#ffccdd'
                });
            </script>
            -->
    <br/>
    <input type="button" value="提交" id="button"/>
</form>
</body>
</html>