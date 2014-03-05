<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 //EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Servlet</title>
</head>
<body>

	<h3>Hello Servlet</h3>
	<form method="get" action="Hello">
	<p>Enter your name, please:
	<input type="text" name="userName">
	<input type="submit"value="Go to Hello Servlet">
	</form>
	<p>
	<p>
	<h3>Reverso Page</h3>
	<form method="get" action="Controller">
	<p>You must visit the Hello Servlet and give your name before you go here:</p>
	<p>Enter a string</p>
	<input type="text" name="string">
	<input type="submit"value="See Reversed String">
	</form>
	

</body>
</html>