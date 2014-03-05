<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Z Credit Customer List</title>

</head>
<body>
<h1>E-Z Credit, Inc.</h1>



<c:if test="${not empty customerList}">
<h2>Valued Customers</h2>
<table border="1">
	<tr><th>Customer</th><th>Address</th><th>Unpaid Balance</th><th>Credit Limit</th></tr>
		<%--add item from customerList to a list item --%>
		<c:forEach items="${customerList}" var="item" begin="0" varStatus="counter">
			<tr><td><a href=<c:url value="/CustomerController?custID=${counter.count}"/>>${item.custName}</a></td><td>${item.custAddr}</td><td><fmt:formatNumber type="currency">${item.unpaidBalance}</fmt:formatNumber></td><td><fmt:formatNumber type="currency">${item.creditLimit}</fmt:formatNumber></td></tr>
		</c:forEach>
</table>
</c:if>


<%--START EXTRA JUNK

?userName=gdsfg
<c:param name=”query” value=”lookforit” />
<a href=<c:url value="/CustomerController"/><c:param name="custID" value='${counter.index}' />>
best option WORKS === <a href=<c:url value="/CustomerController?custID=${counter.index}"/>>${item.custName}</a>
<a href="/CreditController/get?custID=counter">
<a href="${createLink(action: 'list')}">my link</a>


<c:url value="/CustomerController" var="myURL"><c:param name="custID" value="${counter.index}"/></c:url>

END EXTRA JUNK--%>



<h2>Enter a new Customer</h2>
<form method="post" OnSubmit="return CheckForm()" action="CustomerController" >
<table>
<tr><td>Customer Name:</td><td><input type="text" name="custName"></td></tr>
<tr><td>Customer Address:</td><td><input type="text" name="custAddr"></td></tr>
<tr><td>Credit Limit:</td><td><input type="text" name="creditLimit"></td></tr>
<tr><td>Image URL:</td><td><input type="text" name="imageURL"></td></tr>
<tr><td colspan="2"><input type="Submit" value="Create Customer Account"></td></tr>
</table>
</form>


<script type="text/javascript">
<!--
// Set focus on first element in form -- not supported by Netscape 2
if (!(navigator.userAgent.substring(0,11) == "Mozilla/2.0")) 
   document.forms[0].elements[0].focus();

function CheckForm() {
	//Customer Name is not blank.
	if (document.forms[0].custName.value.length == 0) {
		alert("Please enter a customer name.");
		document.forms[0].elements[0].select();
		document.forms[0].elements[0].focus();
		return false;
    }
	//Customer Address is not blank.
	if (document.forms[0].custAddr.value.length == 0) {
		alert("Please enter a customer address.");
		document.forms[0].elements[1].select();
		document.forms[0].elements[1].focus();
		return false;
	}
	//^[1-9] The number must start with 1-9
	//\d* The number can then have any number of any digit
	//(...)$ look at the next group from the end (...)$
	//(...)?(...)? Look for two groups optionally. The first is for the comma, the second is for the decimal.
	//(,\d{3}){1} Look for one occurance of a comma followed by exactly three digits
	//\.\d{0,2} Look for a decimal followed by zero, one, or two digits.
  	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
	//Check for invalid money formats.
  	if (!regex.test(document.forms[0].creditLimit.value)) {
		alert("Please enter a valid credit limit.");
		document.forms[0].elements[2].select();
		document.forms[0].elements[2].focus();
		return false;
	}
  	return true;
}
// -->
</script>
</body>
</html>