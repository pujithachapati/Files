<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.crud.model.Student" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Age</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.dob}" /></td>
                    <td><c:out value="${student.age}" /></td>
                    <td><a href="edit/${student.id}">Edit</a></td>
                    <td><a href="delete/${student.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/crud/form"><button>Add Student</button></a>
</body>
</html>