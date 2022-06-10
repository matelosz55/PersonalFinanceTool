<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>id</th>
    <th>account value</th>

    </thead>
    <tbody>
    <c:forEach items="${accounts}" var="accounts">
        <tr>
            <td><c:out value="${accounts.id}"/></td>
            <td><c:out value="${accounts.accountValue}"/></td>


        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

