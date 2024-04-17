<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
    <center>
        <div>
            <tiles:insertAttribute name="Header" />
            <tiles:insertAttribute name="Menu"/>
            <tiles:insertAttribute name="body"/>
            <tiles:insertAttribute name="Footer"/>
        </div>
    </center>
</body>
</html>

