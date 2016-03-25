<%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 18.03.2016
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process</title>
</head>
<body>
<form action="/process" method="post">
    <textarea name="textarea"></textarea><br/>
    <select name="select">
        <option value="1">Characters</option>
        <option value="2">Words</option>
        <option value="3">Sentences</option>
        <option value="4">Paragraphs</option>
    </select>
    <input type="submit"/>
</form>
</body>
</html>
