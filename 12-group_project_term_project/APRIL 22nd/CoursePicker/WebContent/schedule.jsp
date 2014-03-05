<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<script type="text/javascript">

        
	var daysOfWeek = new Array("", "Mon", "Tue", "Wed", "Thurs", "Fri");
	var hoursOfDay = new Array("8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00");
	
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
        
	/**
	*  Draw a single class meeting on the canvas - or draw all meetings??
        *  
        *  will always be .rect(x,y,156,45), where (x,y) is the top left corner of rectangle
	*/
	function drawClassMeeting() {
		ctx.rect(60.5, 60, 156, 45);//0.5 + x + p, p, w, h) //(x,y of top left corner, width, height)
                ctx.fillStyle = 'yellow';
                ctx.fill();
	}
	
	/**
	*  Initialize the canvas with grid lines and labels
	*/
	function initializeCanvas() {
		
		var bw = 780; //bow width
		var bh = 540;  //box height
		var p = 60;  //padding
		

		for (var x = 0, y = 0; x <= bw; x += 156, y++) {
		    ctx.moveTo(0.5 + x + p, p);
		    ctx.lineTo(0.5 + x + p, bh + p);
		    ctx.fillText(daysOfWeek[y], x + p - 96, p - 15);
		}

		for (var x = 0, y = 0; x <= bh; x += 45, y++) {
		    ctx.moveTo(p, 0.5 + x + p);
		    ctx.lineTo(bw + p, 0.5 + x + p);
                    ctx.fillText(hoursOfDay[y], p - 30, x + p + 5);
		}
                   
                
                
		ctx.strokeStyle = "black";
		ctx.stroke();
                
                
                
                
	}
        
</script>
</head>
<body onload = "initializeCanvas();">
			<canvas id="myCanvas" width="900" height="660" style="border:1px solid #000000;">

</canvas>
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
							<th>CRN</th><th>Subject</th><th>Course</th><th>Cred</th><th>Course Title</th><th>Days</th><th>Time</th><th>Bld</th><th>Room</th><th>Instructor</th><th>Status</th>
						</tr>
						<c:forEach items="${scheduleTree}" var="item" begin="0">
							<tr>
								<td style="text-align: center;">
									<input type="checkbox" name="deleteCourses" value="${item.key}">
								</td>
								<td>${item.key}</td>
								<c:forEach items="${item.value}" var="key" begin="0" end="3" varStatus="counter1">
									<td>${key}</td>
								</c:forEach>
								<td></td><td></td><td></td><td></td>
								
								<c:forEach items="${item.value}" var="key" begin="4" end="5" varStatus="counter1">
									<td>${key}</td>
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
