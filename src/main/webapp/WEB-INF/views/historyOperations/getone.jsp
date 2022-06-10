<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Single history operation</title>
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
        <tr>
            <td><c:out value="${historyOperation.id}"/></td>
            <td><c:out value="${historyOperation.operationType}"/></td>
            <td><c:out value="${historyOperation.category.category}"/></td>
            <td><c:out value="${historyOperation.subcategory.subcategory}"/></td>
            <td><c:out value="${historyOperation.operationDate}"/></td>
            <td><c:out value="${historyOperation.cashValue}"/></td>
            <td><c:out value="${historyOperation.account.id}"/></td>
        </tr>

    </tbody>
</table>
</body>
</html>

