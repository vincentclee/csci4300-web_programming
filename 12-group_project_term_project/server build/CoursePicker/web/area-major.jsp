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
    
    <%--Header--%>
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
        <%--Sidebar--%>
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
                    <%--Only list items if there is at least one item--%>
                    <c:if test="${not empty scheduleList}">
                            <%--print next item in scheduleList--%>
                            <c:forEach items="${scheduleList}" var="item" begin="0">
                                    ${item}<br>
                            </c:forEach>
                    </c:if>
		</p>
	<!-- end .sidebar --></div>
	
	<div class="content">
		<div class="maincontent">
			<h1>${title}</h1>
						
			<%--Checks if error and displays error message--%>
			<c:if test="${classAddError}">
				<%-- Error message if applicable  --%>
				<p style="color:red">Class not added because of time conflicts.</p>
			</c:if>
			
   			<form name="courses" action="CourseController" method="post">
   			
   			<%--Lists one requirement from coursesTree--%>
   			<c:forEach items="${coursesTree}" var="courseTree" begin="0" varStatus="counter">
   				<h3><c:out value="${requirementsList[counter.index]}"/></h3>
   				<div class="scrollcontent">
  					<table border="1">
						<tr>
							<th>Select</th><th>Call #</th><th>Subject</th><th>Course</th><th>Credit</th><th>Course Title</th><th>Days</th><th>Time</th><th>Building</th><th>Room</th><th>Instructor</th><th>Status</th>
						</tr>
						<c:forEach items="${courseTree}" var="item" begin="0">
							<tr>
								<td style="text-align: center;">
                                                                        <%--If class is full disable ability to choose it--%>
									<c:if test="${item.value[5] == 'Full'}">
										<input type="radio" name="addCourseCheckbox" value="${item.key}" disabled>
									</c:if>
                                                                        <%--If class is available allow user to add it--%>
									<c:if test="${item.value[5] == 'Avail'}">
										<input type="radio" name="addCourseCheckbox" value="${item.key}">
									</c:if>
								</td>
								<td>${item.key}</td>
                                                                    <%--List next key in item.value--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="0" end="3">
                                                                            <td>${key}</td>
                                                                    </c:forEach>
								
								<td>
                                                                    <%--List next key in item.value, starting wth 6--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="6" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--list next key in item.value beginning with 7--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="7" step="5" varStatus="counter">
                                                                            ${key} - ${item.value[counter.index+1]}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--list next key in item.value beginning with 9--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="9" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
								<td>
                                                                    <%--list next key in item.value beginning with 10--%>
                                                                    <c:forEach items="${item.value}" var="key" begin="10" step="5">
                                                                            ${key}<br>
                                                                    </c:forEach>
								</td>
								
                                                                <%--list next key in item.value beginning with 4--%>
								<c:forEach items="${item.value}" var="key" begin="4" end="5">
                                                                        <%--Change key color if full--%>
									<c:if test="${key == 'Full'}">
										<td><strong><font color="red">${key}</font></strong></td>
									</c:if>
									<c:if test="${key != 'Full'}">
										<td>${key}</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br>
			</c:forEach>
   			
   			
   			<input type="submit" value="Add Course">
			</form><br>
   			
   			
   			
   			
   		

		<!-- end .maincontent --></div>
	<!-- end .content --></div>

	<div class="footer">
		<p>Team 7 | Meghan Redwine | Alex Tozzi | Johnathan Meggs | Vincent Lee</p>
	<!-- end .footer --></div>
	
<!-- end .container --></div>
</body>
</html>