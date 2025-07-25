<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size: 20px; font-family: Arial;">

	<h2>EXPRESSION LANGUAGE</h2>
	<p>If you are unable to use expression language on jsp page then it might have been disable</p>
	<p>To enable the expression language use isELIgnored=false in page directive <%@ page isELIgnored="false" %> </p>
	<br/><br/>
	
	<h2>MODEL ATTRIBUTE</h2>
	<p>HTML Form ke input field ki name attribute ki value same hone chahiye as that of property value of model/entity class</p>
	<p>To use custom name on jsp page while accessing values from object declare like this :- @ModelAttribute("model_user") User user</p>
	<p>Use like this --- @ModelAttribute User user --- if you want to use ref name only on jsp to access data</p>
	<br/><br/>
	
	<h2>Component Scan</h2>
	<p>Class level annotation use kr raha hai to component scan krna mat bhulna</p>
	<br/><br/>
	
	<h2>Flow & Component</h2>
	<p>Dispatcher Servlet (web.xml) => Handler Mapping (config file) => Controller Class + Handler method => View resolver (config file)</p>
	<p>JSP Pages (View) + Controller Classes (Java) + Web.xml file + Config File + Dependencies</p>
	<br/><br/>
	
	<h2>Model Interface</h2>
	<p>@RequestParam is an alternative for httpsrvltreq.getParameter </p>
	<p>Model interface allow controller to send data to view page , it act as a container for attribute </p>
	<p>Model ko explicitly return me likhne ki zarurat nahi wah automatically response me include ho jayega </p>
	<br/><br/>
	
	<h2>HTML EMAIL</h2>
	<p>For input type email browser already performs built-in validation for a valid email format, so a regex pattern is not strictly necessary.</p>
	<br/><br/>
	
	<h2>SERVLET RESPONSE</h2>
	<p>For this program you will not need http servlet response object/reference because</p>
	<pre>	1. You're only sending data from controller to JSP, not modifying the HTTP response directly.</pre>
	<pre>	2. You’re using HttpServletRequest to: Get form data via getParameter(...) && Set attributes via setAttribute(...) then in jsp using Expression Language (EL) ${name}</pre>
	<p>HttpServletResponse Uses :- Setting custom http headers , Writing directly to output stream , Sending redirects manually , Setting cookies</p>
	<br/><br/>
	
</body>
</html>