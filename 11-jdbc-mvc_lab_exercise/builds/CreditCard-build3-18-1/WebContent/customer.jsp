<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${customer.custName}</title>
<style type="text/css">
IMG {
	float:right;
	width:  350px;
	height: auto;
}
</style>
</head>
<body>

<p><a href="/CreditCard/CustomerController">Back to Customer List</a></p>

<%--check image URL - if null, does not display image, else displays image--%>
<c:if test="${not empty customer.imageURL}">
	<div><img src="${customer.imageURL}" alt="${customer.custName}"></div>
</c:if>



<%-- Displays customer information --%>
<h1>${customer.custName}</h1>
<table>
<tr><td>Address:</td><td>${customer.custAddr}</td></tr>
<tr><td>Unpaid Balance:</td><td><fmt:formatNumber type="currency">${customer.unpaidBalance}</fmt:formatNumber></td></tr>
<tr><td>Credit Limit:</td><td><fmt:formatNumber type="currency">${customer.creditLimit}</fmt:formatNumber></td></tr>
<tr><td>Credit Limit Available:</td><td><fmt:formatNumber type="currency">${customer.creditLimit - customer.unpaidBalance}</fmt:formatNumber></td></tr>
</table>

<%--Checks purchases - if empty, does not display --%>
<c:if test="${not empty customer.purchases}">
<h2>Purchases</h2>
<table border="1">
	<tr><th>Merchant</th><th>City</th><th>State</th><th>Date</th><th>Amount</th></tr>
		<%--adds a row of purchase information  --%>
		<c:forEach items="${customer.purchases}" var="item" begin="0" varStatus="counter">
			<tr><td>${item.merchantName}</td><td>${item.merchantCity}</td><td>${item.merchantState}</td><td>${item.purchaseDate}</td><td><fmt:formatNumber type="currency">${item.purchaseAmount}</fmt:formatNumber></td></tr>
		</c:forEach>
</table>
</c:if>




<%--form to enter a new purchase --%>
<h2>Enter a new Purchase</h2>
<form method="post" OnSubmit="return CheckForm()" action="CreditController">
<table>
<tr><td>Merchant Name:</td><td><input type="text" name="merchantName"></td></tr>
<tr><td>Merchant City:</td><td><input type="text" name="merchantCity"></td></tr>
<tr><td>Merchant State:</td><td>
<select name="merchantState">
	<option value="--">------------</option><%--Other - for merchants not in the US --%>
	<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
</select></td></tr>
<tr><td>Purchase Amount:</td><td><input type="text" name="purchaseAmount"></td></tr>
<tr><td colspan="2"><input type="Submit" value="Add Purchase"></td></tr>
</table>
</form>

<script type="text/javascript">
<!--
function CheckForm() {
	//Checks that Merchant Name is not blank.
	if (document.forms[0].merchantName.value.length == 0) {
		alert("Please enter a merchant name.");
		return false;
    }
	//Checks that merchant city is not blank
	if (document.forms[0].merchantCity.value.length == 0) {
		alert("Please enter a merchant city.");
		return false;
	}

	//this checks if credit limit is valid
	//Sourced from http://stackoverflow.com/questions/2227370/currency-validation
  	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;

	//Check for invalid money formats.
	if (!regex.test(document.forms[0].purchaseAmount.value)) {
		alert("Please enter a valid purchase amount.");
		return false;
	}
  	return true;
}
// -->
</script>

<%--Checks if error and displays error message--%>
<c:if test="${purchaseError}">
	<%-- Error message if applicable  --%>
	<p style="color:red">Purchase exceeds credit limit.</p>
</c:if>

</body>
</html>
