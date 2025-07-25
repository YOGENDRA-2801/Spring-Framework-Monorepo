<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<h1>USER PROFILE</h1>
	<p>Form submitted successfully!</p>
	
	<!-- HTTP SERVLET REQUEST 
	<p><strong>Name:</strong> ${name}</p>
	<p><strong>Email:</strong> ${email}</p>
	<p><strong>Mobile:</strong> ${mobile}</p>
	-->
	
	<!-- Model Interface
	<p><strong>Name:</strong> ${model_name}</p>
	<p><strong>Email:</strong> ${model_email}</p>
	<p><strong>Mobile:</strong> ${model_mobile}</p>
	 -->
	 
	<!-- Model interface + User entity
	<p><strong>Name:</strong> ${model_user.getName()}</p>
	<p><strong>Email:</strong> ${model_user.getEmail()}</p>
	<p><strong>Mobile:</strong> ${model_user.getMobile()}</p>
	-->
	
	<!-- Model Attribute + User Entity -->
	<p><strong>Name:</strong> ${user.getName()}</p>
	<p><strong>Email:</strong> ${user.getEmail()}</p>
	<p><strong>Mobile:</strong> ${user.getMobile()}</p>
	
</body>
</html>