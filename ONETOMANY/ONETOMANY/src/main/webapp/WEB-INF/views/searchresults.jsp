<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.onetomany.model.Teacher" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="search" method="get">
    	<label for="keyword">Search</label>
    	<input type="text" id="keyword" name="keyword" />
    	<button type="submit">Search</button>
    </form>
    <h2>Search Results</h2>
    <table>
    	<thead>
    		<tr>
    			<th>ClassName</th>
    			<th>TeacherName</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="teacher" items="${searchresults}">
    		<tr>
    			<td>${teacher.classname}</td>
    			<td>${teacher.tname}</td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
</body>
</html>