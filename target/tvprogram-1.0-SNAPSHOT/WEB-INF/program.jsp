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
    <div class="program">
        <div>
            <h1>Программы: </h1>
        </div>
        <!-- Load channel program -->
        <table class="center">
            <c:forEach var="pr" varStatus="status" items="${programs}">

            <thead>
            <tr>
                <th style="width: 50px; text-align: center">Id</th>
                <th style="width: 200px; text-align: center">Name</th>
                <th style="width: 600px; text-align: center">Duration</th>
                <th style="width: 100px; text-align: center">Datetime</th>
               <!-- <th style="width: 100px; text-align: center" colspan=2>Action</th>-->
            </tr>
            </thead>
            </c:forEach>

        </table>
            <tbody>
            <c:forEach items="${programs}" var="pr">
            <tr>
                <td style="text-align: center"><c:out value="${pr.id}"/></td>
                <td style="text-align: center"><c:out value="${pr.name}"/></td>
                <td style="text-align: center"><c:out value="${pr.duration}"/></td>
                <td style="text-align: center"><c:out value="${pr.datetime}"/></td>
                <!--<td><a href="ArticleServlet?id=<c:out value="${article.id}"/>"><c:out
                        value="${article.title}"/></a></td>
                <td><c:out value="${article.content}"/></td>-->

               <!-- <td style="text-align: center"><a
                        href="CommandsServlet?action=edit&id=<c:out value="${article.id}"/>">Update</a></td>
                <td style="text-align: center"><a
                        href="CommandsServlet?action=delete&id=<c:out value="${article.id}"/>">Delete</a></td>-->
            </tr>
                <div class="row">
                    <table>
                        <tbody>
                        <tr>
                            <div class="f_div">
                                <td style="text-align: right;width: 600px">
                                    <span style="color: #428bca"> ${programs.getName()}&nbsp;</span>
                                </td>
                                <td style="text-align: right;width: 200px">
                                    <span>&nbsp;&nbsp;${comm.time}</span>
                                </td>
                            </div>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </c:forEach>

    </div>
</body>
</html>
