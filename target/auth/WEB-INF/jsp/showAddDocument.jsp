<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>上传文档</title>
</head>
<body>
<h3><b><strong>上传文档</strong></b></h3>
<form action="/addDocument" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="2">
    <table>
        <tr>
            <td><label>文档标题:</label>
            <input type="text" name="title"/>
            </td>
        </tr>
        <tr>
            <td><label>文档描述:</label><br/>
            <textarea name="remark " id="remark" cols="88" rows="10"></textarea>
            </td>
        </tr>
        <tr>
            <td><label>文档:</label><br/>
            <input type="file" name="file"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="上传"/>
                <input type="reset" value="取消"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>