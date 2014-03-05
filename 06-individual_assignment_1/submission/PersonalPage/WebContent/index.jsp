<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean class="csci4300.Student" id="student" scope="session"/>
    <jsp:setProperty name="student" property="studentName" value="Vincent Lee"/>
    <jsp:setProperty name="student" property="description" value="I'm Vincent, and currently I attend the University of Georgia in beautiful Athens, Georgia. I intend to graduate with a degree in Computer Science. I enjoy public speaking and have always been fond of generating income online."/>
    <%-- Image sourced from Vincent Lee facebook account. --%>
    <jsp:setProperty name="student" property="imageURL" value="https://sphotos-a.xx.fbcdn.net/hphotos-snc6/270089_1601042502282_4495778_n.jpg"/>
    <jsp:setProperty name="student" property="newActivity" value="search engine optimization"/>
    <jsp:setProperty name="student" property="newActivity" value="website management"/>
    <jsp:setProperty name="student" property="newActivity" value="Google Adsense"/>
    <jsp:setProperty name="student" property="newActivity"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><jsp:getProperty name="student" property="studentName"/></title>
<style type="text/css">
	#wrapper {
		width: 680px;
		margin: 0 auto 0 auto;
		text-align: left;
	}
</style>
</head>
<body>
<div id="wrapper">
	<p><a href="<jsp:getProperty name="student" property="imageURL"/>">
	<img src="<jsp:getProperty name="student" property="imageURL"/>" style="float:right" width="270" height="284" alt=""></a></p>
		
	<h1><jsp:getProperty name="student" property="studentName"/></h1>

	<h3>Background</h3>
	<p><jsp:getProperty name="student" property="description"/></p>

	<h3>Interests</h3>
	<p><jsp:getProperty name="student" property="activitiesStatement"/></p>
	
	<form action="index.jsp" method="POST">

	<p>Add Interests: <input name="newActivity"/>
	<input type="submit" value="Add">
	<input type="Reset"></p>
	</form>
</div>
</body>
</html>