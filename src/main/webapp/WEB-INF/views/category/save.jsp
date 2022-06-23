<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form:form method="post" autocomplete="off" modelAttribute="category">
    <div>
        <label for="category">Add category</label>
        <form:input path="category" id="category" type="text"/>
        <form:errors path="category"/>
    </div>

    <div>
        <input type="submit">
    </div>
    <form:errors path="*"/>
</form:form>
</body>
</html>