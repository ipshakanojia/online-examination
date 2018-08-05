<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/log-reg-sub.css">
<style type="text/css">

.errorMessage {
	color: red;
}

</style>
</head>
<body>
	<s:form action="login" class="wrap-login100" method="post">
	<h1>LOG IN</h1>
		<s:textfield name="username" id="username" class="input100" label="Username" />
		<s:password name="password" class="input100" label="Password" />
		<s:submit value="Login" class="login"/>
		
	
	
	<a style="text-decoration:none" href="registration.jsp" class="login set">Sign up</a></br></br>
		<a style="text-decoration:none" href="addquestion.jsp" class="login set">Add New Question</a>
		</s:form>
</body>
</html>