<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 10/17/2022
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User_registered</title>
</head>

<body>
<c:if test="${message != null}"> <!-- ใช้ test check เงื่อนไข-->
<h1 style="color:red">${message}</h1>
</c:if>
<!-- Method ชื่อ get history แต่เรียกแบบ ตัด get ออก-->
<c:forEach items="${courseRegistered.history}" var="entry" >
 <h3> Semester : ${entry.key}</h3><br>
    <c:forEach items="${entry.value}" var="subject">
     &nbsp; &nbsp; &nbsp; ${subject.subjectId},${subject.title},${subject.credit}<br>
    </c:forEach>
----------------------------------------<br>

</c:forEach>
</body>
</html>
