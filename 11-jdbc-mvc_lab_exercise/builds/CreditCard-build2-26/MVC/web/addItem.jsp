<%-- 
    Document   : addItem
    Created on : Feb 20, 2013, 9:59:50 PM
    Author     : Meghan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
    </head>
    <body>
        <h1>Add Item</h1>
        <form action="admin.jsp" method="GET">
            <table>
                <tr><td><b>Add new item to category: </b></td></tr>
                <tr><td>Item name:</td><td><input type="text" name="itemName"/></td></tr>
                <tr><td>Description:</td><td><input type="text" size="15" name="descr"/></td></tr>
                <tr><td>Availability:</td><td><input type="text" name="avail"/></td></tr>
                <tr><td>Minimum Bid:</td><td><input type="text" name="minBid"/></td></tr>
                <tr><td>Auction end date:</td><td><input type="text" name="endDate"/></td></tr>
                <tr><td><input type="submit" value="Add Item"/></td></tr>
            </table>
        </form>
    </body>
</html>
