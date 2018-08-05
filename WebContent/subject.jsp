<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/log-reg-sub.css">
</head>
<body>
	<div class="instructions">
		<table>
			<tbody>
				<tr class="odd">
					<th width="25%">Questions</th>
					<td>1</td>
				</tr>
				<tr class="even">
					<th>Attempts allowed</th>
					<td>1</td>
				</tr>
				<tr class="odd">
					<th>Available</th>
					<td>Always</td>
				</tr>
				<tr class="even">
					<th>Pass rate</th>
					<td>75 %</td>
				</tr>
				<tr class="odd">
					<th>Time limit</th>
					<td>0:30:00</td>
				</tr>
				<tr class="even">
					<th>Backwards navigation</th>
					<td>Allowed</td>
				</tr>
			</tbody>
		</table>
	</div>

	<s:form action="quiz">
		<s:select label="Choose your Subject" headerKey="-1"
			headerValue="Choose" list="list" name="subject" />
		<s:submit value="Click here to Start" class="sub"/>
	</s:form>
</body>
</html>