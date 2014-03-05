<%-- 
    Document   : index
    Created on : Feb 18, 2013, 2:31:15 PM
    Author     : Dr. Dan and Meghan Redwine

    USER VIEW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dance Society Auction</title>
</head>
    <body>

        <div style="float:left;width:300px;position:fixed;background-color:#A5DF00">
            <h3>Dance Lessons</h3>
            <ul>
                <li><a href="">Lindy Hop dance lessons</a></li>
                <li><a href="">Texas Swing dance lessons</a></li>
                <li><a href="">Texas Swing dance lessons</a></li>
            </ul>
            <h3>Costumes</h3>
            <ul><li><a href="">Womens dress, size 8</a></li>
            </ul>
            <ul>
                
                <form action="admin.jsp" method="GET">
                    <table>
                        <tr><td><b>Admin Login</b></td></tr>
                        <tr><td>Username:</td><td><input type="text" name="user"/></td></tr>
                        <tr><td>Password:</td><td><input type="text" name="password"/></td></tr>
                        <tr><td><input type="submit" value="Login"/></td></tr>
                    </table>
                </form>
                
            </ul>

        </div>
        <div style="padding-left:310px">
            <h1>Dance Society Auction</h1>
            <h2>Lindy Hop Lessons from Rachel</h2>
            <img src="LindyHop.jpg" alt="Couple dancing the Lindy Hop">
            <br>
            <p><b>Description:</b> Learn the exciting "Lindy Hop" style of swing dancing at
            Rachel's Dance Studio. Package of 6 one-hour lessons for a couple.</p>
            <p><b>Availability:</b> Classes meet Tuesday nights from 7 to 8 pm. New classes start monthly.
            Must be used by Jan 1, 2014.</p>
            <p><b>Minimum bid:</b>$100.</p>
            <p><b>Auction Closes: </b></p>
            <br>
            <br>            
            <form action="index.jsp" method="GET">
                <table>
                    <tr><td><b>Place Bid</b></td></tr>
                    <tr><td>Your bid:</td><td><input type="text" name="bidAmt"/></td></tr>
                    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
                    <tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
                    <tr><td>Phone number:</td><td><input type="text" name="phone"/></td></tr>
                    <tr><td><input type="submit" value="Submit Bid"/></td></tr>
                </table>
            </form>
        </div>
        <p style="font-size:8pt">Lindy hop image: 4point4milliondays.com</p>
    </body>
</html>