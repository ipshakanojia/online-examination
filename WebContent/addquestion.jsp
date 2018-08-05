<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/addques.css">
</head>
<body>
	<s:form action="addquestion" class="addquesForm" method="post">
		<s:textfield name="question" class="input10" label="Question"/>
		<s:textfield name="answer1" class="input10" label="Answer-A"/>
		<s:textfield name="answer2" class="input10" label="Answer-B"/>
		<s:textfield name="answer3" class="input10" label="Answer-C"/>
		<s:textfield name="answer4" class="input10" label="Answer-D"/>
		<s:textfield name="canswer" class="input10" label="Correct-Answer"/>
		<s:submit value="Save Question" class="saveques" />
	</s:form>
</body>
</html>