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
<style>
/* Style for form container */
#formContainer {
	width: 70%;
	margin: 0 auto; /* Center the form horizontally */
	padding: 20px;
	border: 1px solid #dddddd;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Style for table */
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #dddddd;
	padding: 8px;
	text-align: left;
}

/* Style for input fields */
input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

/* Style for Add button */
#addButton {
	margin:15px 5px;
	background-color: #2cb5db;
}

.button{
	color: white;
	border: none;
	padding: 5px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	cursor: pointer;
	border:none;
	border-radius: 5px;
}

.removeButton {
	background-color: #f44336;	
}

.Button {
	background-color: #f44336;	
}

.removeButton:hover {
	background-color: #da190b;
}
</style>
<script>
    $(document).ready(function () {
    	var i = ${fn:length(teacher.students)}; // Start with the number of existing students

        $("#addButton").click(function () {
            var newRow = '<tr>' +
				'<td>' +
    			'<input type="hidden" name="students[' + i + '].studentId" class="studentId" value=""/>'+
                '<td>' +
                '<input type="text" name="students[' + i + '].studentName" class="studentName" value=""/>' +
                '</td>' +
                '<td>' +
                '<input type="text" name="students[' + i + '].studentMobile" class="studentMobile" value=""/>' +
                '</td>' +
                '<td>' +
                '<input type="text" name="students[' + i + '].studentGender" class="studentGender" value=""/>' +
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
		<form action="save" method="post">
				<table>
						<thead>
						<tr>
							<th>No.</th>
							<th>Teacher Name</th>
							<th>Class Name</th>
							<th>Teacher Gender</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<td><input type="hidden" name="teacher_Id" id="teacherId" value="${teacher.teacher_Id}" /></td>
						<td><input type="text" name="teacher_Name" id="teacherName" value="${teacher.teacher_Name}" required/></td>
							<td><input type="text" name="className" id="className" value="${teacher.className}" required/></td>
							<td><input type="text" name="teacher_Gender" id="teacherGender" value="${teacher.teacher_Gender}" required/></td>
						</tr>
					</tbody>
				</table>
			<div id="studentContainer">
				<div style="display:flex;justify-content: space-between;">
					<h2>Students List:</h2>
					<button type="button" id="addButton" class="button">Add new row</button>
				</div>
				<table id="studentTable">
					<thead>
						<tr>
							<th>No.</th>
							<th>Student Name</th>
							<th>Student Mobile</th>
							<th>Student Gender</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${teacher.students}" varStatus="loop">
							<tr>
						   		<td><input type="hidden" name="students[${loop.index}].studentId" class="studentId" value="${student.studentId}"/></td>
								<td><input type="text" name="students[${loop.index}].studentName}" class="studentName" value="${student.studentName}" required/></td>
								<td><input type="text" name="students[${loop.index}].studentMobile}" class="studentMobile" value="${student.studentMobile}" required/></td>
								<td><input type="text" name="students[${loop.index}].studentGender}" class="studentGender" value="${student.studentGender}" required/></td>
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