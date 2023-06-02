<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Диана
  Date: 18.05.2023
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Program</title>
</head>
<body>
        <div>
            <h1>Программы: </h1>
        </div>
        <table class="center">

            <thead>
            <tr>
                <th style="width: 50px; text-align: center">Id</th>
                <th style="width: 200px; text-align: center">Name</th>
                <th style="width: 600px; text-align: center">Duration</th>
                <th style="width: 100px; text-align: center">Datetime</th>
               <th style="width: 100px; text-align: center" colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${program}" var="pr">

            <tr>
                <td style="text-align: center"><c:out value="${pr.getId()}"/></td>
                <td style="text-align: center"><c:out value="${pr.getName()}"/></td>
                <td style="text-align: center"><c:out value="${pr.getDuration()}"/></td>
                <td style="text-align: center"><c:out value="${pr.getDatetime()}"/></td>
                <td style="text-align: center"><a
                        href="ProgramServlet?act=delete&id=<c:out value="${pr.getId()}"/>">Delete</a> </td>
            </tr>

            </c:forEach>
            </tbody>
        </table>




</body>
</html>
