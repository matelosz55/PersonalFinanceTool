<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Add new operation</title>
</head>
<body>
<form:form method="post" modelAttribute="historyOperation">
    <div>
        <select name ="operationType">
            <option value="add_funds">Add funds</option>
            <option value="buy_sth">Pay for sth</option>
        </select>
    </div>
    <div>
        <select name ="category">
            <option value="transport">transport</option>
            <option value="food">food</option>
            <option value="flat">flat expense</option>
            <option value="holiday">holiday expense</option>
            <option value="culture&entertainment">culture & entertainment</option>
        </select>
    </div>
    <div>
        <select name ="subcategory">
            <option value="petrol">petrol</option>
            <option value="vegetables">vegetables</option>
            <option value="furniture">furniture expense</option>
            <option value="gadget">gadget</option>
        </select>
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
    <select name="accountId">
        <c:forEach items="${user}" var="user">
            <option value="${user.id}">${user.id}</option>
        </c:forEach>
    </select>
    <div>
        <input type="submit">
    </div>
    <form:errors path="*"/>
</form:form>
</body>
</html>