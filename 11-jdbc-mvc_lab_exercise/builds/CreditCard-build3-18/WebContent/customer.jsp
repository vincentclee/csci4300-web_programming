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

<p><a href="/CreditCard/CustomerController">Back to customerList page</a></p>

<c:if test="${not empty customer.imageURL}">
	<div><img src="${customer.imageURL}" alt="${customer.custName}"></div>
</c:if>



<h1>${customer.custName}</h1>
<table>
<tr><td>Address:</td><td>${customer.custAddr}</td></tr>
<tr><td>Unpaid Balance:</td><td><fmt:formatNumber type="currency">${customer.unpaidBalance}</fmt:formatNumber></td></tr>
<tr><td>Credit Limit:</td><td><fmt:formatNumber type="currency">${customer.creditLimit}</fmt:formatNumber></td></tr>
<tr><td>Credit Limit Available:</td><td><fmt:formatNumber type="currency">${customer.creditLimit - customer.unpaidBalance}</fmt:formatNumber></td></tr>
</table>


<c:if test="${not empty customer.purchases}">
<h2>Purchases</h2>
<table border="1">
	<tr><th>Merchant</th><th>City</th><th>State</th><th>Date</th><th>Amount</th></tr>
		<%--add item from customer to a list item --%>
		<c:forEach items="${customer.purchases}" var="item" begin="0" varStatus="counter">
			<tr><td>${item.merchantName}</td><td>${item.merchantCity}</td><td>${item.merchantState}</td><td>${item.purchaseDate}</td><td><fmt:formatNumber type="currency">${item.purchaseAmount}</fmt:formatNumber></td></tr>
		</c:forEach>
</table>
</c:if>





<h2>Enter a new Purchase</h2>
<form method="post" OnSubmit="return CheckForm()" action="CreditController">
<table>
<tr><td>Merchant Name:</td><td><input type="text" name="merchantName"></td></tr>
<tr><td>Merchant City:</td><td><input type="text" name="merchantCity"></td></tr>
<tr><td>Merchant State:</td><td>
<select name="merchantState">
	<option value="--">------------</option>
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
// Set focus on first element in form -- not supported by Netscape 2
if (!(navigator.userAgent.substring(0,11) == "Mozilla/2.0")) 
   document.forms[0].elements[0].focus();

function CheckForm() {
	//Merchant Name is not blank.
	if (document.forms[0].merchantName.value.length == 0) {
		alert("Please enter a merchant name.");
		document.forms[0].elements[0].select();
		document.forms[0].elements[0].focus();
		return false;
    }
	//Merchant City is not blank.
	if (document.forms[0].merchantCity.value.length == 0) {
		alert("Please enter a merchant city.");
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
  	if (!regex.test(document.forms[0].purchaseAmount.value)) {
		alert("Please enter a valid purchase amount.");
		document.forms[0].elements[3].select();
		document.forms[0].elements[3].focus();
		return false;
	}
  	return true;
}
// -->
</script>
</body>
</html>
