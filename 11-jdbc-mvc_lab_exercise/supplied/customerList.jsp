<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Z Credit Customer List</title>

</head>
<body>
<h1>E-Z Credit, Inc.</h1>
<h2>Valued Customers</h2>
<table border="1">
<%--TODO: replace dummy records with c:forEach loop --%>
<%--TODO: JSTL formatting of money amounts --%>
<%--TODO: Links to individual account pages --%>
  <tr><th>Customer</th><th>Address</th><th>Unpaid Balance</th><th>Credit Limit</th></tr>
  <tr><td>Gordon Gecko</td><td>1 Wall St., NYC.</td><td>$0.00</td><td>$10000000.00</td></tr>
</table>
</body>
<h2>Enter a new Customer</h2>
<form method="post" action="CreditController">
<table>
<tr><td>Customer name:</td><td>input element goes here </td></tr>
<tr><td>Customer address:</td><td>input element goes here </td></tr>
<tr><td>Credit Limit:</td><td>input element goes here </td></tr>
<tr><td>Image URL</td><td>input element goes here </td></tr>
<tr><td colspan="2"><input type="Submit" value="Create Customer Account"></td></tr>
</table>
</form>
</html>