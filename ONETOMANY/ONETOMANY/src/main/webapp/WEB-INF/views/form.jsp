<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Form</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function () {
    	var i = ${fn:length(teacher.students)}; // Start with the number of existing students

        $("#addButton").click(function () {
            var newRow = '<tr>' +
				'<td>' +
    			'<input type="hidden" name="students[' + i + '].id" class="id" value=""/>'+
                '<td>' +
                '<input type="text" name="students[' + i + '].sname" class="sname" value=""/>' +
                '</td>' +
                '<td>' +
                '<input type="text" name="students[' + i + '].attendance" class="attendance" value=""/>' +
                '</td>' +
                '<td>' +
                '<button type="button" class="removeButton button" onclick="$(this).closest(\'tr\').remove();">Remove</button>' +
                '</td>' +
                '</tr>';
            
            $("#studentTable tbody").append(newRow);
            i++; // Increment for the next row
        });
    });
</script>

</head>
<body>
	<div id="formContainer">
		<form action="${teacher.id==null ?'save':'update'}" method="post">
				<table>
						<!-- <thead>
						<tr>
							<th>ClassName</th>
							<th>TeacherName</th>
							<th>Gender</th>
						</tr>
					</thead> -->
					<tbody>
						<tr>
						<td><input type="hidden" name="id" id="id" value="${teacher.id}" /></td>
						<td>TeacherName:<input type="text" name="tname" id="tname" value="${teacher.tname}" required/></td>
						<td>ClassName:<input type="number" name="classname" id="classname" value="${teacher.classname}" required/></td>
<%-- 						<td><input type="text" name="gender" id="gender" value="${teacher.teacher_Gender}" required/></td>
 --%>					
 						<td>Date:<input type="date" name="date" id="date" value="${teacher.date}" required/></td>
 						
 						<td>Gender:
    					<label>Male</label>
    					<input type="checkbox" name="gender" value="male" ${teacher.gender == 'male' ? 'checked' : ''} />
    
    					<label>Female</label>
    					<input type="checkbox" name="gender" value="female" ${teacher.gender == 'female' ? 'checked' : ''} />
					</td>	
 
 					</tr>
					</tbody>
				</table>
			<div id="studentContainer">
				<div style="display:flex;justify-content: space-between;">
				</div>
				<table id="studentTable" align="center">
					<thead>
						<tr>
							<th>StudentName</th>
<!-- 							<th>StudentID</th>
 -->							<th>Attendance</th>
							<button type="button" id="addButton" class="button">Add new row</button>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${teacher.students}" varStatus="loop">
    					<tr>
        				<td><input type="hidden" name="students[${loop.index}].id" class="id" value="${student.id}" required/></td>
       					<td><input type="text" name="students[${loop.index}].sname" class="sname" value="${student.sname}" required/></td>
        				<td><input type="text" name="students[${loop.index}].attendance" class="attendance" value="${student.attendance}" required/></td>
        				<td><button type="button" class="removeButton button" onclick="$(this).closest('tr').remove();">Remove</button></td>
    					</tr>
					</c:forEach>
					</tbody>
				 </table>
				<input type="submit" value="Submit" class="button" />
			</div>
		</form>
	</div>
</body>
</html>