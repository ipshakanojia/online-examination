<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*,com.exam.dao.*,com.exam.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/log-reg-sub.css">

<script type="text/javascript" >
	function saveExam() {
		document.getElementById("exampaper").action = 'submitExam';
	}
	function setActionNext() {
		document.getElementById("exampaper").action = 'next';
	}
	function setActionPrevious() {
		document.getElementById("exampaper").action = 'previous';
	}

	function checkPreviousSelectionOption() {
		
		var x = document.getElementsByName("answer1");

		for (var i = 0; i < x.length; i++) {
			if (x[i].checked) {
				x[i].checked = false;
			}
		}
		for (var i = 0; i < x.length; i++) {
			var prev = document.getElementById('me').innerHTML;
			//alert(prev);
			if (x[i].value == prev) {
				x[i].checked = true;
				break;
			}
		}
	}
</script>

</head>
<body onload="checkPreviousSelectionOption();">
	<s:form id="exampaper" method="post">
		<s:iterator value="singleQuestion" status="status">
			<s:hidden value="%{question}" name="hquestion" />
			<s:property value="question" />
			<s:radio name="answer1" list="answer1" />
			<br/>
			<s:radio name="answer1" list="answer2" />
			<br />
			<s:radio name="answer1" list="answer3" />
			<br/>
			<s:radio name="answer1" list="answer4" />
			<br/>
		</s:iterator>
		<s:submit value="Next" onclick="setActionNext();" style="visibility:%{nextButtonVisibility}"/>
		<s:submit value="Previous"  onclick="setActionPrevious();" style="visibility:%{previousButtonVisibility}" />
		<s:submit value="SubmitExam" onclick="saveExam();"/>
		<div id = "me" > <s:property value="%{previousSelectionOption}" /></div>
 	</s:form>
</body>
</html>