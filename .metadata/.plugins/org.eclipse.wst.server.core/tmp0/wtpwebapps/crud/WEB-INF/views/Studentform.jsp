<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${student.id==null ?'save':'update'}" method="POST">
        <input type="hidden" id="id" name="id" value="${student.id}"/>

        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" value="${student.name}"><br><br>

        <label for="dob">Date of Birth:</label><br>
        <input type="date" id="dob" name="dob" value="${student.dob}"><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" value="${student.age}"><br><br>        
        
        <input type="submit" value="Submit">
</form>
</body>
</html>