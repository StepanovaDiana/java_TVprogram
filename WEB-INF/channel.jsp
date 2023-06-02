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
    <style>
        body{

            background-color:#5F9EA0;
            color: #FFFFFF;
            font-family: Calibri;
            font-style: normal;
            text-align: center;

        }

        li{
            line-height: 0.5;
            float: left;
        }
        ul{
            font-size: 1.5rem;
            list-style: square outside;
            display: table;
            margin: 0 auto;
        }

        a{
            color: #FFFFFF;
            text-decoration: none;/*убирает подчеркивание*/
        }
    </style>

</head>
<body>
<header>
    <ul>
        <li><a href="ChannelServlet?action=list"></a></li>
    </ul>
</header>
<h1 style="font-size: 50px">Каналы</h1>
<div style="margin-top: -25px">
    <c:forEach items="${channelList}" var="channel">
        <ul>
            <li>
                <p><c:out value="${channel.getName()}"></c:out> </p>
                <p><a href="/tvprogram_war_exploded/?action=program&id=<c:out value="${channel.getId()}"/> "> Program</a></p>

            </li>
        </ul>
    </c:forEach>

</div>

</body>
</html>
