<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/layout.css"
	rel="stylesheet"></link>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<center>
		<div>
			<header> <tiles:insertAttribute name="header" /></header>
		</div>
		<div>
			<menu>
				<tiles:insertAttribute name="menu" />
			</menu>
		</div>
		<div>
			<bodylayout> <tiles:insertAttribute name="body" /></bodylayout>
		</div>
		<div>
			<footer> <tiles:insertAttribute name="footer" /></footer>
		</div>
	</center>
</body>
</html>