<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>id</th>
    <th>first name</th>
    <th>last name</th>
    <th>email</th>
    <th>password</th>
    </thead>
    <tbody>

        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.password}"/></td>
        </tr>

    </tbody>
</table>
</body>
</html>

