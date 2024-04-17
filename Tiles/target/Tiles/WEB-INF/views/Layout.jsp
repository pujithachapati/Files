<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tile:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
<center>
    <div>
        <tile:insertAttribute name="Header" />
        <tile:insertAttribute name="Menu"/>
        <tile:insertAttribute name="body"/>
        <tile:insertAttribute name="Footer"/>
    </div>
</center>
</body>
</html>
