<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.onetomany.model.Teacher,com.onetomany.model.Student" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher List</title>
</head>
<body>
    <h2>Teacher List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Classname</th>
                <th>Teachername</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
         <a href="/ONETOMANY/form"><button>Add Teacher</button></a>
        
        <tbody>
            <c:forEach items="${teacher}" var="teacher">
    <tr>
        <td><c:out value="${teacher.classname}" /></td>
        <td><c:out value="${teacher.tname}" /></td>
<%--         <td><c:out value="${student.dob}" /></td>
        <td><c:out value="${student.age}" /></td> --%>
        <%-- <td><c:out value="${teacher.student.lid}" /></td>
        <td><c:out value="${teacher.student.tname}" /></td>
        <td><a href="edit/${student.id}">Edit</a></td>
        <td><a href="delete/${student.id}">Delete</a></td> --%>
        <td><a href="edit/${teacher.id}">Edit</a></td>
        <td><a href="delete/${teacher.id}">Delete</a></td>
    </tr>
</c:forEach>
        </tbody>
    </table>
    <br>
</body>
</html>