<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Title</title>
<style type="text/css">
td {
	vertical-align: top;
}
div.scroll {
	border: 1px solid;
	padding:10px; 
	height: 200px;
	width: 900px;
	resize: both;
	overflow: auto;
}
</style>
</head>
<body>






<%--
<button onclick="myFunction()">Try it</button>

<script>
function myFunction() {
	var selectedItem = document.getElementByName(${selectedItems});
document.write("Oops! The document disappeared!");
document.write(selectedItem[0]);
}
</script>

 --%>



<canvas id="myCanvas" width="200" height="100" style="border:1px solid #d3d3d3;">
Your browser does not support the HTML5 canvas tag.</canvas>

<script>
var value1 = new String("${selectedItems}");

var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.font="30px Arial";
ctx.fillText(value1,10,50);

</script>









<c:forEach items="${selectedItems}" var="item" begin="0" varStatus="counter">
${item}
</c:forEach>






<form name="test" action="CourseController" method="post">

<p>18</p>
<div class="scroll">

<table border="1">
	<tr>
	<th>Select</th><th>CRN</th><th>Subject</th><th>Course</th><th>Cred</th><th>Course Title</th><th>Days</th><th>Time</th><th>Bld</th><th>Room</th><th>Instructor</th><th>Status</th>
	</tr>
	<c:forEach items="${coursesTree18}" var="item" begin="0" varStatus="counter">
		<tr>
			<td style="text-align: center;">
				<input type="checkbox" name="18" value="${item.key}">
			</td>
			<td>${item.key}</td>
			<c:if test="${item.value.size() == 11}">
				<c:forEach items="${item.value}" var="key" begin="0" end="4" varStatus="counter1">
					<td>${key}</td>
				</c:forEach>
				<td>
				<c:forEach items="${item.value}" var="key" begin="5" end="6" varStatus="counter2">
					${key}
					<c:if test="${counter2.index == 5}">
					-
					</c:if>
				</c:forEach>
				
				</td>
				<c:forEach items="${item.value}" var="key" begin="7" varStatus="counter3">
					<td>${key}</td>
				</c:forEach>
			</c:if>
			
			<c:if test="${item.value.size() != 11}">
				<c:forEach items="${item.value}" var="key" begin="0" end="3" varStatus="counter4">
					<td>${key}</td>
				</c:forEach>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="4" end="5" varStatus="counter5">
					${key}<br>
				</c:forEach>
				</td>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="6" end="7" varStatus="counter6">
					${key}
					<c:if test="${counter6.index == 6}">
					-
					</c:if>
				</c:forEach>
				<br>
				<c:forEach items="${item.value}" var="key" begin="8" end="9" varStatus="counter7">
					${key}
					<c:if test="${counter7.index == 8}">
					-
					</c:if>
				</c:forEach>
				</td>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="10" end="11" varStatus="counter8">
					${key}<br>
				</c:forEach>
				</td>
				<td>
				<c:forEach items="${item.value}" var="key" begin="12" end="13" varStatus="counter9">
					${key}<br>
				</c:forEach>
				</td>
				
				
				<c:forEach items="${item.value}" var="key" begin="14" varStatus="counter10">
					<td>${key}</td>
				</c:forEach>
			</c:if>
		</tr>
	</c:forEach>
</table>
</div>



<p>19</p>
<div class="scroll">
<table border="1">
	<tr>
	<th>Select</th><th>CRN</th><th>Subject</th><th>Course</th><th>Cred</th><th>Course Title</th><th>Days</th><th>Time</th><th>Bld</th><th>Room</th><th>Instructor</th><th>Status</th>
	</tr>
	<c:forEach items="${coursesTree19}" var="item" begin="0" varStatus="counter">
		<tr>
			<td style="text-align: center;">
				<input type="checkbox" name="18" value="${item.key}">
			</td>
			<td>${item.key}</td>
			<c:if test="${item.value.size() == 11}">
				<c:forEach items="${item.value}" var="key" begin="0" end="4" varStatus="counter1">
					<td>${key}</td>
				</c:forEach>
				<td>
				<c:forEach items="${item.value}" var="key" begin="5" end="6" varStatus="counter2">
					${key}
					<c:if test="${counter2.index == 5}">
					-
					</c:if>
				</c:forEach>
				
				</td>
				<c:forEach items="${item.value}" var="key" begin="7" varStatus="counter3">
					<td>${key}</td>
				</c:forEach>
			</c:if>
			
			<c:if test="${item.value.size() != 11}">
				<c:forEach items="${item.value}" var="key" begin="0" end="3" varStatus="counter4">
					<td>${key}</td>
				</c:forEach>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="4" end="5" varStatus="counter5">
					${key}<br>
				</c:forEach>
				</td>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="6" end="7" varStatus="counter6">
					${key}
					<c:if test="${counter6.index == 6}">
					-
					</c:if>
				</c:forEach>
				<br>
				<c:forEach items="${item.value}" var="key" begin="8" end="9" varStatus="counter7">
					${key}
					<c:if test="${counter7.index == 8}">
					-
					</c:if>
				</c:forEach>
				</td>
				
				<td>
				<c:forEach items="${item.value}" var="key" begin="10" end="11" varStatus="counter8">
					${key}<br>
				</c:forEach>
				</td>
				<td>
				<c:forEach items="${item.value}" var="key" begin="12" end="13" varStatus="counter9">
					${key}<br>
				</c:forEach>
				</td>
				
				
				<c:forEach items="${item.value}" var="key" begin="14" varStatus="counter10">
					<td>${key}</td>
				</c:forEach>
			</c:if>

		</tr>
	</c:forEach>
</table>
</div>


<input type="submit" value="Submit">
</form>



</body>
</html>