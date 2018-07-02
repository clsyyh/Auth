<%@page language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/question.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>
    <input type="button" value="提问">
    <form id="question" title="提问"action="/addQuestion" method="post">
        <input type="text" name="title"/>
        <textarea name="content" cols="50" rows="20"></textarea>
    </form>
    <div class="content">
    </div>
</body>
</html>