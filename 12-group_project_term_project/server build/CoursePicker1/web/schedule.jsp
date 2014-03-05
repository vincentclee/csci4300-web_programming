<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- @author Meghan Redwine --%>
<%-- @author Alex Tozzi --%>
<%-- @author Johnathan Meggs --%>
<%-- @author Vincent Lee --%>
<!DOCTYPE html>
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
<%--Override container min-width for HTML5 Canvas --%>
<style>
.container {
	width: 90%;
	max-width: 1500px;
	min-width: 1104px;
	background-color: #FFF;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	var daysOfWeek = new Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
	var hoursOfDay = new Array("8 AM", "9 AM", "10 AM", "11 AM", "Noon", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM");
	var prefix = new Array("${JSONprefix}");
	var number = new Array("${JSONnumber}");
	var title = new Array("${JSONtitle}");
	var instructor = new Array("${JSONinstructor}");
	var day = new Array("${JSONday}");
	var startTime = new Array("${JSONstartTime}");
	var endTime = new Array("${JSONendTime}");
	var building = new Array("${JSONbuilding}");
	var room = new Array("${JSONroom}");
	var posX = new Array("${JSONposX}");
	var posY = new Array("${JSONposY}");
	var height = new Array("${JSONheight}");

	/**
     * @author Meghan Redwine
     * @param varX
     * @param varY
     * @param varH
     * 
     * Draws one class meeting 
     * Will always be .rect(x,y,156,h), where (x,y) is the top left corner of rectangle
	*/
	function drawClassMeetings(c, ctx) {
                <%--Draws one class meeting--%>
		for (var i=0; i<posX.length; i++) {
			//Draw box
			ctx.fillStyle = "orange";
			ctx.globalAlpha = 1;
			//0.5 + x + p, 60+45, w-static, h) //(x,y of top left corner, width, height) //(60.5, 206, 156, 56.1)
			//ctx.fillRect(parseInt(posX[i]), parseInt(posY[i]), 155, parseInt(height[i]));
			ctx.strokeStyle = "orange";
			
			var isSafari = /Safari/.test(navigator.userAgent) && /Apple Computer/.test(navigator.vendor);
			
			if (!isSafari) {
				var cornerRadius = 20;
				
				//Set faux rounded corners
				ctx.lineJoin = "round";
				
				ctx.lineWidth = cornerRadius;
				
				ctx.strokeRect(parseInt(posX[i])+(cornerRadius/2), parseInt(posY[i])+(cornerRadius/2), 155-cornerRadius, parseInt(height[i])-cornerRadius);
				ctx.fillRect(parseInt(posX[i])+(cornerRadius/2), parseInt(posY[i])+(cornerRadius/2), 155-cornerRadius, parseInt(height[i])-cornerRadius);
			} else {
				ctx.fillRect(parseInt(posX[i]), parseInt(posY[i]), 155, parseInt(height[i]));

			}
			

			ctx.globalAlpha = 1;
			
			//Draw Text on Box
			var tp = 3; //text padding x
			
                        ctx.fillStyle = "black";
                        ctx.font = "bold 10px Arial";
                        ctx.fillText(prefix[i]+" "+number[i], parseInt(posX[i])+tp, parseInt(posY[i])+10);
                        ctx.font = "10px Arial";
                        ctx.fillText(title[i], parseInt(posX[i])+tp, parseInt(posY[i])+20);
                        ctx.fillText(building[i]+"-"+room[i], parseInt(posX[i])+tp, parseInt(posY[i])+30);
                        ctx.fillText(startTime[i]+"-"+endTime[i], parseInt(posX[i])+tp+60, parseInt(posY[i])+30);
                        ctx.measureText(title[i]);
		}
	}
	
	/**
	 * Initialize the canvas with grid lines and labels
	 * @author Alex Tozzi
	 * @author Meghan Redwine
	 */
	function initializeCanvas() {
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		
		var bw = 780; //bow width
		var bh = 540;  //box height
		var p = 50;  //padding
		
		//Draws one vertical line
		for (var x = 0, y = 0; x <= bw; x += 156, y++) {
		    ctx.moveTo(-0.5 + x + p, p);
		    ctx.lineTo(-0.5 + x + p, bh + p);
		    
		    //Days of the week.
		    if (y < 5) {
			    ctx.textAlign = "center";
			    ctx.fillText(daysOfWeek[y], x + 78 + p, p - 10);
			    ctx.textAlign = "left";
		    }
		}

		//Draws one horizontal line
		for (var x = 0, y = 0; x <= bh; x += 45, y++) {
		    ctx.moveTo(p, 0.5 + x + p);
		    ctx.lineTo(bw + p, 0.5 + x + p);
		    
		    //Hour markers.
		    ctx.textAlign = "right";
		    ctx.fillText(hoursOfDay[y], p-5, x + p + 5);
		    ctx.textAlign = "left";
		}
		
		//Draw Normal Lines
		ctx.strokeStyle = "black";
		ctx.stroke();
		
		//Half Hour Lines
		for (var x = 0, y = 0; y < 12; x += 45, y++) {
		    ctx.moveTo(p, x+22.5+p);
		    ctx.lineTo(bw+p, x+22.5+p);
		}
		
		//Draw Half Hour 50% opacity lines
		ctx.globalAlpha = 0.2;
		ctx.stroke();
		
		drawClassMeetings(c, ctx);
	}
</script>
</head>
<body onload = "initializeCanvas()">
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
                    <%--Only list schedule if there is at lest one class in schedule--%>
                    <c:if test="${not empty scheduleList}">
                            <%--Lists one item in schedule --%>
                            <c:forEach items="${scheduleList}" var="item" begin="0">
                                    ${item}<br>
                            </c:forEach>
                    </c:if>
		</p>
	<!-- end .sidebar --></div>
	
	<div class="content">
		<div class="maincontent">
    		<h2>Schedule</h2>
    		
			<canvas id="myCanvas" width="880" height="640" style="border-top: 1px solid #000;border-right: 1px solid;border-bottom: 1px solid">
				Your browser does not support the HTML5 canvas tag.
			</canvas>
                <%--Only continute if scheduleTree has at least one item--%>
    		<c:if test="${not empty scheduleTree}">
    			<p><form name="deleteCourses" action="CourseController" method="post">
				<table border="1">
						<tr>
							<th style="padding: 0 10px 0 10px">
								<input type="checkbox" onClick="toggleALL(this)">
							</th>
							<th>Call #</th><th>Subject</th><th>Course</th><th>Credit</th><th>Course Title</th><th>Days</th><th>Time</th><th>Building</th><th>Room</th><th>Instructor</th>
						</tr>
                                                <%-- List one items from scheduleTree--%>
						<c:forEach items="${scheduleTree}" var="item" begin="0">
							<tr>
								<td style="text-align: center;">
									<input type="checkbox" name="deleteCourses" value="${item.key}">
								</td>
								<td>${item.key}</td>
                                                                <%--List one value of the item--%>
								<c:forEach items="${item.value}" var="key" begin="0" end="3">
									<td>${key}</td>
								</c:forEach>
								
								
								<td>
                                                                    <%--Add one value from items--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="6" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--Add one value from items--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="7" step="5" varStatus="counter">
                                                                            ${key} - ${item.value[counter.index+1]}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--Add one value from items--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="9" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--Add one value from items--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="10" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
								<%--Add one value from items--%>
								<c:forEach items="${item.value}" var="key" begin="4" end="4">
									<td title="${key}">${key}</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</table><br>
					<input type="submit" value="Delete">
					</form><br>
					
				<script type="text/javascript">
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
