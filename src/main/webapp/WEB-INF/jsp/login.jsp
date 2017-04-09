<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 04/04/2017
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tml>
<head>
    <title>Login Form</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <p>Name:
        <form:input path="username"/>
        <form:errors path="username" cssClass="error"/>

    <p>Password:
    <form:errors path="password" cssClass="error"/>
    <form:password path="password"/></p>
    <input type="submit" value="Login"/>
</form:form>


<div style="color:red">${error}</div>
</body>
</tml>