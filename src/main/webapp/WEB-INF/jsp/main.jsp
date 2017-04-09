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

<form:form class="form" method="post" action="user/add" modelAttribute="user">

    <p> Name: <form:input  path="username"/></p>
    <p> Email: <form:input path="email"/></p>
    <p> Password: <form:password path="password"/></p>


    <p><c:if test="${empty user.username}"></p>
    <form:button class="btn btn-primary">Add</form:button>

    <p></c:if></p>
    <p> <c:if test="${not empty user.username}"></p>
    <form:button class="btn btn-primary">Update</form:button>
    <p> </c:if></p>

    <button class="btn btn-warning"><a href="user/reset">Reset</a></button>
    </head>

</form:form>

<h3 class="toast">${greeting}</h3>

<h3 class="text-info">List of Users:</h3>
<c:if test="${not empty users}">
    <table class="table table-striped table-bordered">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>
                    <a href="user/edit/${user.id}" class="btn btn-success">Edit</a>
                </td>
                <td>
                    <a href="user/delete/${user.id}" class="btn btn-success">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>

</c:if>
    </body>
    </html>