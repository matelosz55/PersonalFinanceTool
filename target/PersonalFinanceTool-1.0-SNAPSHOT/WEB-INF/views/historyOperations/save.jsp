<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Add new operation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/styles.css">
</head>
<body>
<form:form method="post" modelAttribute="historyOperation">
    <div class="operationType">
        <select name ="operationType">
            <option value="add_funds">Add funds</option>
            <option value="buy_sth">Pay for sth</option>
        </select>
    </div>
    <div class="category">
        <label> Category
            <form:select itemValue="id" itemLabel="category"
                         path="category.id" items="${categories}"/>



        </label>
    </div>
    <div class="subcategory">
        <label> Subcategory
            <form:select itemValue="id" itemLabel="subcategory"
                         path="subcategory.id" items="${subcategories}"/>


        </label>
    </div>
    <div>
        <label for="operationDate">Operation Date</label>
        <form:input path="operationDate" id="operationDate" type="date"/>
        <form:errors path="operationDate"/>
    </div>
    <div>
        <label for="cashValue">Cash Value</label>
        <form:input path="cashValue" id="cashValue" type="number"/>
        <form:errors path="cashValue"/>
    </div>
    <div>
        <label> Account id
        <form:select itemValue="id" itemLabel="id"
        path="account.id" items="${accounts}"/>


        </label>

    </div>
    <div>
        <input type="submit">
    </div>
    <script src="${pageContext.request.contextPath}/resources/JS/operations.js"></script>
    <form:errors path="*"/>
</form:form>
</body>
</html>