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

<%-- Grid of customers --%>
<%--checks if there are any customers before displaying grid  --%>
<c:if test="${not empty customerList}">
<h2>Valued Customers</h2>
<table border="1">
	<tr><th>Customer</th><th>Address</th><th>Unpaid Balance</th><th>Credit Limit</th></tr>
		<%--adds one row to customerList --%>
		<c:forEach items="${customerList}" var="item" begin="0" varStatus="counter">
			<tr><td><a href=<c:url value="/CustomerController?custID=${counter.count}"/>>${item.custName}</a></td><td>${item.custAddr}</td><td><fmt:formatNumber type="currency">${item.unpaidBalance}</fmt:formatNumber></td><td><fmt:formatNumber type="currency">${item.creditLimit}</fmt:formatNumber></td></tr>
		</c:forEach>
</table>
</c:if>

<%--New customer form --%>
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
function CheckForm() {
	//Customer Name is not blank.
	if (document.forms[0].custName.value.length == 0) {
		alert("Please enter a customer name.");//Pop up box - alerts user to enter a customer name
		return false;
    }
	//Customer Address is not blank.
	if (document.forms[0].custAddr.value.length == 0) {
		alert("Please enter a customer address.");//Pop up box - alerts user to enter a customer address
		return false;
	}

	//this checks if credit limit is valid
	//Sourced from http://stackoverflow.com/questions/2227370/currency-validation
  	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
	
	
	//Check for invalid money formats.
  	if (!regex.test(document.forms[0].creditLimit.value)) {
		alert("Please enter a valid credit limit.");//alert box
		return false;
	}
  	return true;
}
// -->
</script>
</body>
</html>