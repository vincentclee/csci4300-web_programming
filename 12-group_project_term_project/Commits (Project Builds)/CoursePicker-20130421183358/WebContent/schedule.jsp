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
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
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
		
		<p><a href="CourseController?page=schedule">View my Schedule</a></p>
		<p>
		<c:if test="${not empty userName}">
			${userName}<br>
		</c:if>
		Current Schedule:</p>
		
		<p>CSCI 10730<br>CSCI 9720<br>CSCI 13900<br>CSCI 18030<br>CSCI 45232<br></p>
	<!-- end .sidebar1 --></div>
	
	<div class="content">
		<div class="maincontent">
    		<h2>Schedule</h2>
    		<p>Graph Goes here</p>
		<!-- end .maincontent --></div>
	<!-- end .content --></div>

	<div class="footer">
		<p>Team 7 | Meghan Redwine | Alex Tozzi | Johnathan Meggs | Vincent Lee</p>
	<!-- end .footer --></div>
	
<!-- end .container --></div>
</body>
</html>
