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
<script
	src="${pageContext.request.contextPath}/resources/js/datetimepicker_css.js"></script>

<title>Voter Details</title>
</head>
<body>
	<center>
		<b>Voter Details</b>
		<form:form  action="/myapp/update" method="post">
			<table border="1">
				<tr>
					<td class="heading">Voter Id</td>
					<td><input type="text" name=voterId value="${voter.voterId}" ></td>
				</tr>
				<tr>
					<td class="heading">First Name</td>
					<td><input type="text" name=voterFirstName value="${voter.voterFirstName}" ></td>
				</tr>
				<tr>
					<td class="heading">Middle Name</td>
					<td><input type="text" name=voterMiddleName value="${voter.voterMiddleName}" ></td>
				</tr>
				<tr>
					<td class="heading">Last Name</td>
					<td><input type="text" name=voterLastName value="${voter.voterLastName}" ></td>
				</tr>
				<tr>
					<td class="heading">FatherName</td>
					<td><input type="text" name=voterFathersName value="${voter.voterFathersName}" ></td>
				</tr>
				<tr>
					<td class="heading">Gender</td>
					<td><input type="text" name=voterGender value="${voter.voterGender}" ></td>
				</tr>
				<tr>
					<td class="heading">DoB</td>
					<td><input type="text" name=voterDob value="${voter.voterDob}" ></td>
				</tr>
				<tr>
					<td class="heading">Status</td>
					<td><input type="text" name=voterStatus value="${voter.voterStatus}" ></td>
				</tr>
				<tr>
					<td class="heading">PhoneNo</td>
					<td><input type="text" name=voterPhoneNo value="${voter.voterPhoneNo}" ></td>
				</tr>
				<tr>
					<td class="heading">EmailId</td>
					<td><input type="text" name=voterEmailId value="${voter.voterEmailId}" ></td>
				</tr>
				<tr>
					<td class="heading">House No</td>
					<td><input type="text" name=voterAddress.houseNo value="${voter.voterAddress.houseNo}" ></td>
				</tr>
				<tr>
					<td class="heading">Address 1</td>
					<td><input type="text" name=voterAddress.addres1 value="${voter.voterAddress.addres1}" ></td>
				</tr>
				<tr>
					<td class="heading">Address 2</td>
					<td><input type="text" name=voterAddress.addres2 value="${voter.voterAddress.addres2}" ></td>
				</tr>
				<tr>
					<td class="heading">Address 3</td>
					<td><input type="text" name=voterAddress.addres3 value="${voter.voterAddress.addres3}" ></td>
				</tr>
				<tr>
					<td class="heading">City</td>
					<td><input type="text" name=voterAddress.city value="${voter.voterAddress.city}" ></td>
				</tr>
				<tr>
					<td class="heading">State</td>
					<td><input type="text" name=voterAddress.state value="${voter.voterAddress.state}" ></td>
				</tr>
				<tr>
					<td class="heading">Pincode</td>
					<td><input type="text" name=voterAddress.pinCode value="${voter.voterAddress.pinCode}" ></td>
				</tr>
				<tr>
					<td><a href="getVoterList" />Back</td>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>