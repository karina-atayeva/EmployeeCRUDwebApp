<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee CRUD Web Application</title>
</head>
<body>
<h1>Employee Information</h1>

<form action="/EmployeeServlet" method="POST">
    <table>
        <tr>
            <td>Employee ID</td>
            <td><input type="text" name="employeeId" value="${employee.employeeId}"/></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value="${employee.lastName}"/></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input type="text" name="position" value="${employee.position}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add"/>
                <input type="submit" name="action" value="GetByID"/>
                <input type="submit" name="action" value="Edit"/>
                <input type="submit" name="action" value="Delete"/>
            </td>
        </tr>
    </table>
</form>
<br>
<table border="1">
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Position</th>
    <c:forEach items="${allEmployees}" var="emp">
        <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.position}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>