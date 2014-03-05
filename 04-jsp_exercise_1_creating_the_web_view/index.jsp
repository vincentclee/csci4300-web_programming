<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "creditcard.CustomerAccount"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >


<title>Customer Account</title>
</head>
<body>
<% CustomerAccount instance = new CustomerAccount(1, "Gordon Gecko", "1 Wall Street, NYC", 10000000.0);
		instance.setImageUrl
		("http://cedricmnich.files.wordpress.com/2007/11/gordongecko.gif");%>
<h1>E-Z Credit, Inc.</h1>
<img src="<%= instance.getImageUrl() %>" style="float:right" width="226" height="284">
<p>Valued customer: <%= instance.getCustName() %></p>
<p>Address: <%= instance.getCustAddress() %></p>
<%-- TODO: format money amounts for unpaid balance and credit limit --%>
<p>Unpaid Balance: $<%= instance.getUnpaidBalance() %></p>
<p>Credit Limit: $<%= instance.getCreditLimit() %></p>
<p>Gordon Gecko image : cedricmnich.wordpress.com</p>
<p></p>
<p></p>



</body>
</html>