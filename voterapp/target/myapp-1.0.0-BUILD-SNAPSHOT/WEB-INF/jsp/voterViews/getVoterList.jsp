<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet"></link>
<title>Voter List Details</title>
</head>
<body>
	<center>
		<b>Voter List</b>
		<form:form>
		<h2>${message}</h2>
			<table border="1">
				<tr>
					<td class="heading">Voter Id</td>
					<td class="heading">First Name</td>
					<td class="heading">Middle Name</td>
					<td class="heading">Last Name</td>
					<td class="heading">Gender</td>
					<td class="heading">Status</td>
					<td class="heading">Delete</td>
				</tr>
				<c:forEach var="voter" items="${voterList}">
					<tr>
						<td><a href="getVoterDetails?voterId=${voter.voterId}">${voter.voterId}</a></td>
						<td>${voter.voterFirstName}</td>
						<td>${voter.voterMiddleName}</td>
						<td>${voter.voterLastName}</td>
						<td>${voter.voterGender}</td>
						<td>${voter.voterStatus}</td>
						<td><a href="delete?voterId=${voter.voterId}">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10"><a href="insertVoterDetails">Add New
							Voter</a></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>