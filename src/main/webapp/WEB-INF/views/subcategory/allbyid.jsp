<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sorted</title>
</head>
<body>

<table border="1">
    <thead>
    <th>id</th>
    <th>operation type</th>
    <th>category</th>
    <th>subcategory</th>
    <th>operation date</th>
    <th>cash value</th>
    <th>account id</th>

    </thead>
    <tbody>
    <c:forEach items="${finalHistoryOperation}" var="finalHistoryOperation">
        <tr>
            <td><c:out value="${finalHistoryOperation.id}"/></td>
            <td><c:out value="${finalHistoryOperation.operationType}"/></td>
            <td><c:out value="${finalHistoryOperation.category.category}"/></td>
            <td><c:out value="${finalHistoryOperation.subcategory.subcategory}"/></td>
            <td><c:out value="${finalHistoryOperation.operationDate}"/></td>
            <td><c:out value="${finalHistoryOperation.cashValue}"/></td>
            <td><c:out value="${finalHistoryOperation.account.id}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

