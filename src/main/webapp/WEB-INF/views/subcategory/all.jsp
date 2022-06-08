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
    <th>category</th>



    </thead>
    <tbody>
    <c:forEach items="${subcategory}" var="subcategory">
        <tr>
            <td><c:out value="${subcategory.id}"/></td>
            <td><c:out value="${subcategory.subcategory}"/></td>


        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

