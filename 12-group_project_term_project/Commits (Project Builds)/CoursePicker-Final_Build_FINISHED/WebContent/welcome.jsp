<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="UGA's experimental course picking website, presented by Dan Everett.">
<meta name="keywords" content="dan, dran, everett, uga, coursepicker, course, picker, oasis, elc">
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
	
	<div class="sidebar">
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
		<p>Current Schedule:<br>
                    <%--Only add items from schedule if there is at least one item in schedule--%>
                    <c:if test="${not empty scheduleList}">
                        <%--List one item from schedule--%>
                        <c:forEach items="${scheduleList}" var="item" begin="0">
                                ${item}<br>
                        </c:forEach>
                    </c:if>
		</p>
	<!-- end .sidebar --></div>
	
	<div class="content">
		<div class="maincontent">
			<h1>Instructions</h1>
				<p>Click on a requirement to the left to view classes that will fulfill that requirement.<br>
                                   To add a class, select one class and click the "add course" button.<br>
                                   You're current classes will show up in the lower left corner. <br>
                                   To view and modify your current schedule, click "View Schedule". <br>
                                   When viewing schedule, you can delete one or multiple classes by selecting and pressing the "delete" button.</p>
		<!-- end .maincontent --></div>
	<!-- end .content --></div>

	<div class="footer">
		<p>Team 7 | Meghan Redwine | Alex Tozzi | Johnathan Meggs | Vincent Lee</p>
	<!-- end .footer --></div>
	
<!-- end .container --></div>
</body>
</html>