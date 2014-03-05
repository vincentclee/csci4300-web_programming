<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Returns current date as a sql timestamp--%>
<c:set var="timestamp" scope="page" value="<%=new java.sql.Timestamp(System.currentTimeMillis())%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dance Society Auction</title>
<style type="text/css">
IMG {
	width:  400px;
	height: auto;
}
.sidebar {
	float:left;
	width:300px;
	position:fixed;
	background-color:#A5DF00;
}
.main {
	padding-left:310px;
}
.statusbar {
	background-color: #FBE39E;
	border-bottom: 1px solid #999999;
	border-right: 1px solid #999999;
	padding: 8px 0 11px 15px;
	white-space: nowrap;
}
</style>
<%--JSP Clock to check item ending time --%>
<%--http://www.elated.com/articles/creating-a-javascript-clock/--%>
<script type="text/javascript">
function updateClock() {
	var currentTime = new Date();
	var currentHours = currentTime.getHours();
	var currentMinutes = currentTime.getMinutes();
	var currentSeconds = currentTime.getSeconds();
	currentMinutes = (currentMinutes < 10 ? "0" : "") + currentMinutes;
	currentSeconds = (currentSeconds < 10 ? "0" : "") + currentSeconds;
	var timeOfDay = (currentHours < 12) ? "AM" : "PM";
	currentHours = (currentHours > 12) ? currentHours - 12 : currentHours;
	currentHours = (currentHours == 0) ? 12 : currentHours;
	var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;
	document.getElementById("clock").firstChild.nodeValue = currentTimeString;
}
</script>
</head>
<body onload="updateClock(); setInterval('updateClock()', 1000)">

<div class="sidebar">
	<%--add item from category tree to a list item--%>
	<c:forEach items="${categoryTree}" var="item" begin="0" varStatus="counter">
		<h3>${item.key}</h3>
			<ul>
				<%-- Print an item name corresponding with the category as a list item--%>
				<c:forEach items="${item.value}" var="key" begin="0" varStatus="counter1">
					<li><a href="<c:url value="/AuctionController?itemID=${counter1.count}&categoryID=${counter.count}"/>"><c:out value="${key}"/></a></li>
				</c:forEach>
			</ul>
	</c:forEach>

	<%--Sign In Form--%>
	<form method="post" action="AuctionController">
		<table>
			<tr><td><b>Sign In</b></td></tr>
			<tr><td>Username:</td><td><input type="text" name="username" required></td></tr>
			<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
			<tr><td><input type="submit" value="Sign In"></td></tr>
		</table>
	</form>
	<%--Checks for login success and displays error message--%>
	<c:if test="${loginFailed}">
		<%-- Error message if applicable  --%>
		<p style="color:red"><b>Login Failed</b></p>
	</c:if>
</div>


<div class="main">
	<h1>Dance Society Auction</h1>

	<c:if test="${timestamp > endDate}">
		<%--From Ebay's code for ended items --%>
		<div class="statusbar">
			<%--Checks whether item has been sold and prints out appropriate message--%>
			<c:if test="${currentBid == 0.0}">
				<b>Bidding has ended on this item. Item not sold.</b>
			</c:if>
			<c:if test="${currentBid != 0.0}">
				<b>Bidding has ended on this item. </b>
			</c:if>
		</div>
	</c:if>

	<h2>${listingName}</h2>
	<img src="${imageURL}" alt="${listingName}"><br>
	<p><b>Description: </b>${description}</p>
	<p><b>Availability: </b>${availability}</p>

	<%--Display JSP Clock --%>
	<c:if test="${clock}">
		<span id="clock">&nbsp;</span>
	</c:if>

	<%--Create a date which the countdown timer will accept --%>
	<fmt:formatDate pattern="MM/dd/yyyy hh:mm:ss a" value="${endDate}" var="timeRemaining" scope="page"/>
	
	<%--Set up active countdown timer --%>
	<%--http://www.hashemian.com/tools/javascript-countdown.htm--%>
	<script type="text/javascript">
		//TargetDate = "03/028/2013 10:24:23 AM";
		TargetDate = "${timeRemaining}";
		CountActive = true;
		CountStepper = -1;
		LeadingZero = false;
		DisplayFormat = "%%D%%d %%H%%h %%M%%m %%S%%s";
		FinishMessage = "It is finally here!";
	</script>

	<%--Display appropriate conditions. Either time left, or ended--%>
	<c:if test="${timestamp < endDate}">
		<p><b>Time left: </b><script  type="text/javascript" src="countdown.js"></script> (<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${endDate}"/>)</p>
	</c:if>
	<c:if test="${timestamp > endDate}">
		<p><b>Ended: </b><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${endDate}"/></p>
	</c:if>

	<%--Check if the item had bid's --%>
	<%--Generate auto bid increment feature --%>
	<c:if test="${currentBid != 0.0}">
		<c:if test="${timestamp > endDate}">
			<p><b>Winning bid: </b><fmt:formatNumber type="currency">${currentBid}</fmt:formatNumber></p>
		</c:if>
		<c:if test="${timestamp < endDate}">
			<p><b>Current bid: </b><fmt:formatNumber type="currency">${currentBid}</fmt:formatNumber></p>
			<c:set var="bidIncrement" scope="page" value="${currentBid+0.010}"/>
		</c:if>
	</c:if>
	<c:if test="${currentBid == 0.0}">
		<p><b>Starting bid: </b><fmt:formatNumber type="currency">${startingBid}</fmt:formatNumber></p>
		<c:set var="bidIncrement" scope="page" value="${startingBid}"/>
	</c:if>


	<%--Only display bid form when auction is active --%>
	<c:if test="${timestamp < endDate}">
		<form method="post" onsubmit="return checkForm()" action="AuctionController">
			<table>
				<tr><td><b>Place Bid</b></td></tr>
				<tr><td>Your bid: </td><td><input type="text" name="bid" value="<fmt:formatNumber type="number" pattern="##############.##" value="${bidIncrement}"/>" required></td></tr>
				<tr><td>Name: </td><td><input type="text" name="name" value="${name}" required></td></tr>
				<tr><td>Email: </td><td><input type="text" name="email" value="${email}" required></td></tr>
				<tr><td><input type="submit" value="Place Bid"></td></tr>
			</table>
		</form>
			
		<script type="text/javascript">
		function checkForm() {
			//this checks if bid is valid
			//Sourced from http://stackoverflow.com/questions/2227370/currency-validation
		  	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
			
			var currentBid = ${currentBid};
			var startingBid = ${startingBid};
			
			//Check for invalid money formats.
		  	if (!regex.test(document.forms[1].bid.value)) {
				alert("Please enter a valid bid.");//alert box
				return false;
			}
			
			//Check bid amount
			if (currentBid == 0.0) {
				if (startingBid > document.forms[1].bid.value) {
					alert("Please enter a higher bid amount.");
					return false;
				}
			}
			if (currentBid != 0.0) {
				if (currentBid >= document.forms[1].bid.value) {
					alert("Please enter a higher bid amount.");
					return false;
				}
			}
			//Checks that the name field is not blank.
			if (document.forms[1].name.value.length == 0) {
				alert("Please enter a name.");
				return false;
		    }
			//Checks that name can fit into the database varchar(30)
			if (document.forms[1].name.value.length > 30) {
				alert("Your name is too long.");
				return false;
		    }
			
			//Sourced from http://www.tizag.com/javascriptT/javascriptform.php
			var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
			//Check for invalid email formats.
		  	if (!emailExp.test(document.forms[1].email.value)) {
				alert("Please enter a valid email.");
				return false;
			}
		  	return true;
		}
		</script>
		
		<%--Checks if error and displays error message--%>
		<c:if test="${error}">
			<%-- Error message if applicable  --%>
			<p style="color:red">Error: Please enter a valid bid.</p>
		</c:if>
	</c:if>
</div>
</body>
</html>