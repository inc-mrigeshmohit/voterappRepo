<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Voter Registration Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet"></link>
<script
	src="${pageContext.request.contextPath}/resources/js/datetimepicker_css.js"></script>
<script language="javascript" type="text/javascript">
	var xmlHttp
	var xmlHttp
	function showState(str) {

		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp == null) {
			alert("Browser does not support XMLHTTP Request")
			return;
		}
		var url = "selectState";
		url += "?stateName=" + str;
		xmlHttp.onreadystatechange = stateChange;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function stateChange() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			document.getElementById("stateId").innerHTML = xmlHttp.responseText;
		}
	}

	function showCity(str) {
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp == null) {
			alert("Browser does not support XMLHTTP Request");
			return;
		}

		var url = "selectCity";
		url += "?stateName=" + str;
		alert("I am in showCity at new location = " + str);
		alert("url : " + url);
		xmlHttp.onreadystatechange = stateChange1;
		xmlHttp.open("POST", url, true);
		xmlHttp.send(null);
	}
	function stateChange1() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			document.getElementById("stateId").innerHTML = xmlHttp.responseText;
		}
	}
</script>
</head>
<body>
	<center>
		<b>Voter Registration Form </b>
		<div>
			<form:form action="/myapp/saveVoterDetails" method="post"
				modelAttribute="insertVoter">
				<table>
					<tr>
						<td>Voter Id :</td>
						<td><form:input path="voterId" /></td>
					</tr>
					<tr>
						<td>First Name :</td>
						<td><form:input path="voterFirstName" /></td>
						<td>Middle Name :</td>
						<td><form:input path="voterMiddleName" /></td>
						<td>Last Name :</td>
						<td><form:input path="voterLastName" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:radiobutton path="voterGender" value="male" />Male
							<form:radiobutton path="voterGender" value="female" />Female</td>
					</tr>
					<tr>
						<td>Status :</td>
						<td><form:input path="voterStatus" /></td>
					</tr>
					<tr>
						<td>Date Of Birth :</td>
						<td><form:input path="voterDob" type="text" id="demo1" /></td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/dateTimeImages/cal.gif"
							onclick="javascript:NewCssCal('demo1','yyyyMMdd')"
							style="cursor: pointer" /></td>
					</tr>
					<tr>
						<td>Father's Name :</td>
						<td><form:input path="voterFathersName" /></td>
					</tr>
					<tr>
						<td>PhoneNumber :</td>
						<td><form:input path="voterPhoneNo" /></td>
					</tr>
					<tr>
						<td>Email Id :</td>
						<td><form:input path="voterEmailId" /></td>
					</tr>
					<tr>
						<td>HouseNo :</td>
						<td><form:input path="voterAddress.houseNo" /></td>
					</tr>
					<tr>
						<td>Address1 :</td>
						<td><form:input path="voterAddress.addres1" /></td>
						<td>Address2 :</td>
						<td><form:input path="voterAddress.addres2" /></td>
						<td>Address3 :</td>
						<td><form:input path="voterAddress.addres3" /></td>
					</tr>
					<tr>
						<td>State :</td>
						<td><form:input path="voterAddress.state" /></td>
						<%-- <td><form:select path="${voterAddress.state}"
								onchange="showCity(this.value)">
								<form:option value="0" label="Select" itemValue="stateId"
									itemLabel="stateName" />
								<form:options items="${stateList}" />
							</form:select></td> --%>
						<td>City :</td>
						<td><form:input path="voterAddress.city" /></td>
						<%-- <td><form:select path="${voterAddress.city}">
								<form:option value="0" label="Select" itemValue="cityId"
									itemLabel="cityName" />
								<form:options items="${cityList}" />
							</form:select>
						</td> --%>
					</tr>
					<tr>
						<td>PinCode :</td>
						<td><form:input path="voterAddress.pinCode" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save" /></td>
					</tr>
					<tr>
						<td colspan="2"><a href="getVoterList">Click Here to See
								Voter List</a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
</body>
</html>