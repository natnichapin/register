<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 10/10/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test_css</title>
</head>
<style>
    .box{
        display: inline-block;
    background-color:papayawhip;
    width: 30px;
    height: 30px;
    border: 3px solid black;
    border-radius: 5px;
        text-align: right;
        padding: 2px;
        margin: 2px;
}

</style>
<body>

<div style="padding: 10px;display: block;width: 50%;margin: auto ;">
    <c:forEach begin="1" end="100" var="value">
        <div class="box">${value}</div>
    </c:forEach>
</div>

</body>
</html>
