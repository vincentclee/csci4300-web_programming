<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean class=creditcard.CustomerAccount id="account" scope="session"/>
    <jsp:setProperty name="account" property="accountNo" value="1"/>
    <jsp:setProperty name="account" property="custName" value="Gordon Gecko"/>
    <jsp:setProperty name="account" property="custAddress" value="1 Wall Street, NYC"/>
    <jsp:setProperty name="account" property="imageUrl" value="http://cedricmnich.files.wordpress.com/2007/11/gordongecko.gif"/>
    <jsp:setProperty name="account" property="creditLimit" value="10000000"/>
    <jsp:setProperty name="account" property="purchaseAmount"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>Customer Account</title>
</head>
<body>
<h1>E-Z Credit, Inc.</h1>
<img src="<jsp:getProperty name="account" property="imageUrl"/>" style="float:right" width="226" height="284">
<p>Valued customer: <jsp:getProperty name="account" property="custName"/></p>
<p>Address: <jsp:getProperty name="account" property="custAddress"/></p>

<%-- Using fmt:formatNumber part of JSTL Core <fmt:formatNumber> Tag to format money values  --%>
<fmt:setLocale value="en_US"/>
<p>Unpaid Balance: <fmt:formatNumber type="currency"><jsp:getProperty name="account" property="unpaidBalance"/></fmt:formatNumber></p>
<p>Credit Limit: <fmt:formatNumber type="currency"><jsp:getProperty name="account" property="creditLimit"/></fmt:formatNumber></p>
<p>Gordon Gecko image : cedricmnich.wordpress.com</p>

<%-- Adding a purchase below  --%>
<h2>Enter a new Purchase</h2>
<form action="index.jsp" method="POST">

<p>Purchase Amount: $<input name="purchaseAmount"/>
<input type="submit" value="Enter Purchase">
<input type="reset"></p>
</form>

<%-- Error message if applicable  --%>
<p style="color:red"><jsp:getProperty name="account" property="errorMessage"/></p>
</body>
</html>