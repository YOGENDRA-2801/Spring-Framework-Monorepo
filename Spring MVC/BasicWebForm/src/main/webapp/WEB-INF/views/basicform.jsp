<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BASIC FORM</h1>
	<form action="profile" method="post">
		<!-- IF USING MODEL ATTRIBUTE THEN THE NAME VALUE SHOULD BE EQUAL TO ENTITY CLASS PROPERTY NAME -->
		
		<label for="label_name">Full Name:</label>
		<input type="text" name="name" id="label_name" placeholder="Enter your full name" required />
		<br/>

		<label for="label_email">Email:</label>
		<input type="email" name="email" id="label_email" placeholder="Enter your email address" required />
		<br/>

		<label for="label_mobile">Mobile:</label>
		<input type="tel" name="mobile" id="label_mobile" pattern="[0-9]{10}" placeholder="Enter 10-digit mobile number" required />
		<br/>

		<input type="submit" value="submit form"/>
	</form>
</body>
</html>