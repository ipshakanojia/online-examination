<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/log-reg-sub.css">
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
	<s:textfield name="name" class="input100" label="Name"/>
	<s:textfield name="surname" class="input100" label="Surname"/>
	<s:password name="password" class="input100" label="Password"/>
	<p>Dob:</p>
	<sj:datepicker name="dob" class="input100" changeYear="true" displayFormat="ddmmyy" maxDate="+0d"/>
	<s:textfield name="address" class="input100" label="Address"/>
	<s:textfield name="phone" class="input100" label="Phone"/>
	<s:textfield name="email" class="input100" label="Email"/>
	<s:textfield name="zip" class="input100" label="Zip"/>
	<s:submit value="Register" name="register" class="register"/>
	</form>
</body>