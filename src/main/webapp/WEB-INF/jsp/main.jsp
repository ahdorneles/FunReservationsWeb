<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 03/04/2017
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="addAction" value="/user/add"/>
<c:url var="resetAction" value="user/reset"/>
<c:url var="logout" value="logout"/>


<html>
<head>
<body>
<img src="https://media.giphy.com/media/14aa5GbbHT3bHO/giphy.gif"/>

<h3 class="toast">${greeting}</h3>

<h3 class="text-info">List of your Reservations:</h3>
<c:if test="${not empty users}">
    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th></th>
            <th>Delete</th>
        </tr>
        <c:forEach var="reservation" items="${users}">
            <tr>
                <td>${reservation.facilityID}</td>
                <td>${reservation.date}</td>
                <td>

                </td>
                <td>
                    <a href="deletereservation/${reservation.id}" methods="get" class="btn btn-success">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <c:forEach var="facility" items="${facilities}">
        <tr>
            <td>${facility.name}</td>
            <td>
                Date: <form:input path="date"/>
            </td>
            <td>
                <a href="makereservation/${date}/${facility}" methods="get" class="btn btn-success">Delete</a>
            </td>
        </tr>
    </c:forEach>
</c:if>

    </body>
    </html>