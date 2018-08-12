<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/log-reg-sub.css">
<link rel="stylesheet" type="text/css" href="css/reg1.css">
<sj:head jquerytheme="start" jqueryui="true"/>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
</head>

<body>
	
	<form action="register" class="regForm" method="post">
	<h1>Registration Form</h1>
	<s:textfield name="name" class="input101" label="Name"/></br>
	<s:textfield name="surname" class="input101" label="Surname"/></br>
	<s:password name="password" class="input101" label="Password"/></br>
	
	<h5><b>DOB:</b></h5>
	<sj:datepicker name="dob" class="input101" changeYear="true" displayFormat="ddmmyy" maxDate="+0d"/></br>
	
	<s:textfield name="address" class="input101" label="Address"/></br>
	<s:textfield name="phone" class="input101" label="Phone"/></br>
	<s:textfield name="email" class="input101" label="Email"/></br>
	<s:textfield name="zip" class="input101" label="Zip"/>
	<s:submit value="Register" name="register" class="register"/>
	</form>
</body>