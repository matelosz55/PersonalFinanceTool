<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form:form method="post" autocomplete="off" modelAttribute="subcategory">
    <div>
        <label for="subcategory">Add subcategory</label>
        <form:input path="subcategory" id="subcategory" type="text"/>
        <form:errors path="subcategory"/>
    </div>

    <div>
        <input type="submit">
    </div>
    <form:errors path="*"/>
</form:form>
</body>
</html>