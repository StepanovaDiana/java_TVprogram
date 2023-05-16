<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Диана
  Date: 05.05.2023
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TVprogram</title>

</head>
<body>
<h1>Каналы</h1>
<div>
    <c:forEach items="${channelList}" var="channel">
        <ul>
            <li>
                <p><a href="<%=request.getContextPath()%>/program"><c:out value="${channel.getName()}"></c:out> </a></p>
            </li>
        </ul>
    </c:forEach>

</div>

</body>
</html>
