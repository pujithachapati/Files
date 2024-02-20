<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="userform.title" text="Default Title"/></title>
</head>
<body>
<h1><spring:message code="userform.title" text="Default Title"/></h1>
<form>
	<p><a href="?language=en_US">English</a>|<a href="?language=zh_CN">chinese</a></p>
	<p><lable><spring:message code="userform.username" text="Default username"/><input name="username"></lable></p>
	<p><label><spring:message code="userform.password" text="Default password"/><input name="password"></label></p>
	<input type="submit" value="<spring:message code="userform.signup" text="Default signup"/>"/>
</form>
</body>
</html>