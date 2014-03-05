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
<title>Dance Society Auction - Admin</title>
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
		<%--Creates a button to add a new item--%>
		<form method="post" action="AuctionController">
			<input type="hidden" name="categoryNumber" value="${counter.index}">
			<input type="hidden" name="categoryName" value="${item.key}">
			<table>
				<tr><td><h3>${item.key}</h3></td><td><input type="submit" name="addItem" value="Add Item"></td></tr>
			</table>
		</form>		
			<ul>
				<%-- Print an item name corresponding with the category as a list item--%>
				<c:forEach items="${item.value}" var="key" begin="0" varStatus="counter1">
					<li><a href="<c:url value="/AuctionController?itemID=${counter1.count}&categoryID=${counter.count}"/>"><c:out value="${key}"/></a></li>
				</c:forEach>
			</ul>
	</c:forEach>
	
	<%--Creates a button to add a new category--%>
	<form method="post" action="AuctionController">
		<input type="submit" name="addCategory" value="Add Category">
	</form>	

	<%--Sign In Form--%>
	<div align="right">
		<form method="post" action="AuctionController">
			<b>Welcome, ${username}</b><br>
			<input type="submit" name="signout" value="Sign out">
		</form>
	</div>
</div>


<c:if test="${addCategory}">
<div class="main">
	<h1>Dance Society Auction</h1>
	<%--Form which allows admins to add new categories to the auction--%>
	<form name="addCat" method="post" onsubmit="return checkForm()" action="AuctionController">
		<p>Category Name: <input type="text" name="addCategoryFinal" required></p>
		<input type="submit" value="Add New Category">
	</form>
	<script type="text/javascript">
	function checkForm() {
		//Checks that the addCategoryFinal field is not blank.
		if (document.addCat.addCategoryFinal.value.length == 0) {
			alert("Please enter a category name.");
			return false;
	    }
		//Checks that addCategoryFinal can fit into the database varchar(30)
		if (document.addCat.addCategoryFinal.value.length > 30) {
			alert("Your category name is too long.");
			return false;
	    }
		return true;
	}
	</script>
	<%--Form which cancels the current listing form and returns--%>
	<form method="post" action="AuctionController">
		<button name="cancel" type="submit">Cancel</button>
	</form>
</div>
</c:if>


<c:if test="${addItem}">
<div class="main">
	<h1>Dance Society Auction</h1>
	<h2>Create your listing</h2>
	<p><b>Category: ${categoryName}</b></p>
	<%--Form which allows admins to add new items to the auction--%>
	<form name="addItm" method="post" onsubmit="return checkForm1()" action="AuctionController">
		<table>
			<tr><td>Item Name: </td><td><input type="text" name="itemName" maxlength="33" size="85" required></td></tr>
			<tr><td>Listing Title: </td><td><input type="text" name="listingName" maxlength="80" size="85" required></td></tr>
			<tr><td>Image URL: </td><td><input type="text" name="imageURL" maxlength="500" size="85" required></td></tr>
			<tr><td>Description: </td><td><textarea rows="6" cols="65" name="description" required></textarea></td></tr>
			<tr><td>Availability: </td><td><textarea rows="3" cols="65" name="availability" required></textarea></td></tr>
			<tr><td>Starting Price: </td><td><input type="text" name="startingBid" required></td></tr>
			<tr><td>Duration: </td><td>
				<select name="duration">
						<option value="1">1 day</option>
						<option value="3">3 days</option>
						<option value="5">5 days</option>
						<option value="7">7 days</option>
				</select></td></tr>
				</table>
			<input type="submit" value="Add New Item">
		
	</form>
	<script type="text/javascript">
	function checkForm1() {
			//this checks if money value is valid
			//Sourced from http://stackoverflow.com/questions/2227370/currency-validation
		  	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
			
			//Checks that the itemName field is not blank.
			if (document.addItm.itemName.value.length == 0) {
				alert("Please enter a item name.");
				return false;
		    }
			//Checks that itemName can fit into the database varchar(33)
			if (document.addItm.itemName.value.length > 33) {
				alert("Your item name is too long.");
				return false;
		    }
			//Checks that the listingName field is not blank.
			if (document.addItm.listingName.value.length == 0) {
				alert("Please enter a listing name.");
				return false;
		    }
			//Checks that listingName can fit into the database varchar(80)
			if (document.addItm.listingName.value.length > 80) {
				alert("Your listing name is too long.");
				return false;
		    }
			//Checks that the imageURL field is not blank.
			if (document.addItm.imageURL.value.length == 0) {
				alert("Please enter a image URL.");
				return false;
		    }
			//Checks that imageURL can fit into the database varchar(500)
			if (document.addItm.imageURL.value.length > 500) {
				alert("Your image URL is too long.");
				return false;
		    }
			//Checks that the description field is not blank.
			if (document.addItm.description.value.length == 0) {
				alert("Please enter a description.");
				return false;
		    }
			//Checks that description can fit into the database varchar(500)
			if (document.addItm.description.value.length > 500) {
				alert("Your description is too long.");
				return false;
		    }
			//Checks that the availability field is not blank.
			if (document.addItm.availability.value.length == 0) {
				alert("Please enter an availability.");
				return false;
		    }
			//Checks that availability can fit into the database varchar(140)
			if (document.addItm.availability.value.length > 140) {
				alert("Your availability is too long.");
				return false;
		    }
			
			//Check for invalid money formats.
		  	if (!regex.test(document.addItm.startingBid.value)) {
				alert("Please enter a valid starting bid.");//alert box
				return false;
			}
		  	return true;
		}
	</script>
	<%--Form which cancels the current listing form and returns--%>
	<form method="post" action="AuctionController"><button name="cancel" type="submit">Cancel</button></form>
</div>
</c:if>


<c:if test="${not addItem && not addCategory}">
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
	<c:if test="${currentBid != 0.0}">
		<c:if test="${timestamp > endDate}">
			<p><b>Winning bid: </b><fmt:formatNumber type="currency">${currentBid}</fmt:formatNumber></p>
			<p><b>Bidder name: </b>${nameHighest}</p>
			<p><b>Bidder email: </b>${emailHighest}</p>
		</c:if>
		<c:if test="${timestamp < endDate}">
			<p><b>Current bid: </b><fmt:formatNumber type="currency">${currentBid}</fmt:formatNumber></p>
			<p><b>Bidder name: </b>${nameHighest}</p>
			<p><b>Bidder email: </b>${emailHighest}</p>
		</c:if>
	</c:if>
	<c:if test="${currentBid == 0.0}">
		<p><b>Starting bid: </b><fmt:formatNumber type="currency">${startingBid}</fmt:formatNumber></p>
	</c:if>
</div>
</c:if>
</body>
</html>