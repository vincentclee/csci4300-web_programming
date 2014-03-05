<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="UGA's experimental course picking website, presented by Dan Everrett.">
<meta name="keywords" content="dan, dran, everrett, uga, coursepicker, course, picker, oasis, elc">
<title>${title}</title>
<link rel="Shortcut Icon" type="image/x-icon" href="images/favicon.ico">
<link rel="stylesheet" href="styles.css" type="text/css" media="screen">
<!--[if lte IE 7]>
<style> .content { margin-right: -1px; }
ul.nav a { zoom: 1; } </style>
<![endif]-->
</head>
<body>
<div class="container">
	<div class="header">
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
			<tr>                    		
				<td valign="middle" align="left">
					<a href="CourseController?page=welcome"><img src="images/portal_logo.png" alt=""></a>
				</td>
				<td valign="middle" align="center">
					<a href="CourseController?page=welcome"><img src="images/SchoolName.gif" alt=""></a>
				</td>
				<td valign="middle" align="right">
					<a href="CourseController?page=welcome"><img src="images/flag.png" alt=""></a>
				</td>
			</tr>
		</table>
	<!-- end .header --></div>
	
	<div class="sidebar1">
		<ul class="nav">
			<li><a href="CourseController?page=university-requirements">University Requirements</a></li>
			<li><a href="CourseController?page=franklin-college-requirements">Franklin College Requirements</a></li>
			<li><a href="CourseController?page=area-i-foundation-courses">AREA I: Foundation Courses</a></li>
			<li><a href="CourseController?page=area-ii-sciences">AREA II: Sciences</a></li>
			<li><a href="CourseController?page=area-iii-quantitative-reasoning">AREA III: Quantitative Reasoning</a></li>
			<li><a href="CourseController?page=area-iv-world-lang-culture-humanities-arts">AREA IV: World Lang & Culture, Humanities & Arts</a></li>
			<li><a href="CourseController?page=area-v-social-sciences">AREA V: Social Sciences</a></li>
			<li><a href="CourseController?page=area-f-vi-major-related-requirements">AREA F/VI: Major Related Requirements</a></li>
			<li><a href="CourseController?page=major-requirements">Major Requirements</a></li>
		</ul>
		
		<p><a href="CourseController?page=schedule">View Schedule</a></p>
		<p>Current Schedule:</p>
		<p>
		<c:if test="${not empty scheduleList}">
			<c:forEach items="${scheduleList}" var="item" begin="0">
				${item}<br>
			</c:forEach>
		</c:if>
		</p>
	<!-- end .sidebar1 --></div>
	
	<div class="content">
		<div class="maincontent">
    		<h2>Schedule</h2>
    		<p>Graph Goes here</p>
    		
    		


    		<c:if test="${not empty scheduleTree}">
    			<p><form name="deleteCourses" action="CourseController" method="post">
				<table border="1">
						<tr>
							<th style="padding: 0 10px 0 10px">
								<input type="checkbox" onClick="toggleALL(this)">
							</th>
							<th>Call #</th><th>Subject</th><th>Course</th><th>Credit</th><th>Course Title</th><th>Days</th><th>Time</th><th>Building</th><th>Room</th><th>Instructor</th>
						</tr>
						<c:forEach items="${scheduleTree}" var="item" begin="0">
							<tr>
								<td style="text-align: center;">
									<input type="checkbox" name="deleteCourses" value="${item.key}">
								</td>
								<td>${item.key}</td>
								<c:forEach items="${item.value}" var="key" begin="0" end="3">
									<td>${key}</td>
								</c:forEach>
								
								
								<td>
								<c:forEach items="${item.value}" var="key" begin="6" step="5">
									${key}<br>
								</c:forEach>
								</td>
								
								<td>
								<c:forEach items="${item.value}" var="key" begin="7" step="5" varStatus="counter">
									${key} - ${item.value[counter.index+1]}<br>
								</c:forEach>
								</td>
								
								<td>
								<c:forEach items="${item.value}" var="key" begin="9" step="5">
									${key}<br>
								</c:forEach>
								</td>
								
								<td>
								<c:forEach items="${item.value}" var="key" begin="10" step="5">
									${key}<br>
								</c:forEach>
								</td>
								
								
								<c:forEach items="${item.value}" var="key" begin="4" end="4">
									<td title="${key}">${key}</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
					<input type="submit" value="Delete">
					</form><p>
					
				<script language="javascript">
					function toggleALL(source) {
						checkboxes = document.getElementsByName('deleteCourses');
						for(var i = 0, n = checkboxes.length; i < n; i++)
							checkboxes[i].checked = source.checked;
					}
				</script>
			</c:if>
    		
    		
		<!-- end .maincontent --></div>
	<!-- end .content --></div>

	<div class="footer">
		<p>Team 7 | Meghan Redwine | Alex Tozzi | Johnathan Meggs | Vincent Lee</p>
	<!-- end .footer --></div>
	
<!-- end .container --></div>
</body>
</html>
