<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/3
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${errors }
<form method="post" enctype="multipart/form-data" action="/user/douploadlist">
  <input type="file" name="file"/>
  <input type="file" name="file"/>
  <input type="submit" value="upload" />
</form>
</body>
</html>
