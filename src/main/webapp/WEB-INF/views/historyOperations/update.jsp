<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<c:url var="edit_url" value="/historyOperations/update"/>
<form:form method="post" modelAttribute="historyOperations" action="${edit_url}">
    <form:hidden path="id"/>
    <form:input path="firstName"/>
    <form:errors path="firstName"/><br/>
    <form:input path="lastName"/>
    <form:errors path="lastName"/><br/>
    <form:input path="email"/>
    <form:errors path="email"/><br/>
    <form:input path="password"/>
    <form:errors path="password"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>