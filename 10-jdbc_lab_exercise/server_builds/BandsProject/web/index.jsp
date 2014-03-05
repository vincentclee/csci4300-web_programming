<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="db.DBHelper" id="helper" scope="session"/>
<jsp:setProperty property="clear" name="helper" value=""/>
<jsp:setProperty property="bandName" name="helper"/>
<jsp:setProperty property="command" name="helper"/>
<jsp:setProperty property="albumName" name="helper"/>
<jsp:setProperty property="searchName" name="helper"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Band's and their Albums</title>
</head>
<body>
<h1>Most popular Bands and their Albums</h1>

<ol>
<c:forEach items="${helper.bandList}" var="item" begin="0" varStatus="counter">
	<li>${item.bandName}
		<ul>
			<c:forEach items="${item.albumNames}" var="value" begin="0">
				<li><c:out value="${value}"/></li>
			</c:forEach>
		</ul>
	</li>
</c:forEach>
</ol>



<h3>Add a Band</h3>
<form action="index.jsp" method="POST">
<p><input name="bandName">
<input type="submit" value="Add Band">
<input type="reset"></p>
</form>

<h3>Search for Albums by a Band</h3>
<form method="post" action="addToList">
<p><select name="command">
   <c:forEach items="${helper.bandList}" var="item" varStatus="counter">
       <option value="${counter.index}">${item.bandName}</option>
   </c:forEach>
</select>
<input name="searchName">
<input type="submit" value="Search Band">
<input type="reset"></p>
</form>

<dl>
<c:forEach items="${helper.findList}" var="value" begin="0">
				<dt><c:out value="${value}"/></dt>
</c:forEach>
</dl>

<h3>Add a Album to a Band</h3>
<form method="post" action="addToList">
<p><select name="command">
   <c:forEach items="${helper.bandList}" var="item" varStatus="counter">
       <option value="${counter.index}">${item.bandName}</option>
   </c:forEach>
</select>
<input name="albumName">
<input type="submit" value="Add Album">
<input type="reset"></p>
</form>

</body>
</html>