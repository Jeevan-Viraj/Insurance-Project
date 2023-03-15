<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insurance</h1>
<form action="vehicle/action"method="get">
		<div align="center" class="container">
		<label><b>Type</b></label> 
				<select style="align-content: center" name="type" id="type">
					<option value="auto">Auto</option>
					<option value="health">Health</option>
					<option value="mortgage">Mortgage</option>
				</select>
			<br/> 
			<label><b>Zip</b></label> 
			<input type="text" onkeypress="return validateFloat(event,this)" maxlength="5"
				placeholder="Enter Zipcode" name="zip" required>
			<br/> 
			<button type="submit">Get A Quote</button>
</body>
</html>