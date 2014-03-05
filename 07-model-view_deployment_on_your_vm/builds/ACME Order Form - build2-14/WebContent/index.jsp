<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="acme.ShoppingCartBean" id="bean" scope="session" />
<jsp:setProperty property="itemID" name="bean"/>
<jsp:setProperty property="quantity" name="bean"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ACME Dangerous Products Inc.</h1>
        <p>Helping to turn your demented schemes into reality</p>
        <div style="width:600px">
              <img src="http://upload.wikimedia.org/wikipedia/en/2/20/Wile_E_Coyote.gif"
                    width="226" height="363" alt="Wile E. Coyote" style="float:right">
              <form method="post" action="addToCart">
                  <table>
                      <tr><th>  Item: </th><th>Quantity</th>
                  <tr><td><select name="itemID">
                      <option value="0">Rocket-powered Roller Skates</option>
                      <option value="1">Exploding tennis balls, case</option>
                      <option value="2">Dehydrated Boulder</option>
                      <option value="3">Earthquake Pill, bottle of 12</option>
                      <option value="4">Batman Outfit</option>
                      <option value="5">Catapult</option>
                  </select>
                      </td>
                 <td><input type="text" size="4" name="quantity"></td></tr>
                  <tr><td><input type="submit" value="Add to Cart"></td></tr>
                     </table>
              </form>
              
              <%-- Error message if applicable  --%>
			<p style="color:red"><jsp:getProperty name="bean" property="errorMessage"/></p>
              
              <h3 style="color:green">Your Cart:</h3>
			  <table border="1">
              	<tr><th>ID</th><th>Item</th><th>Quantity</th></tr>
              	<c:forEach items="${bean.cart}" var="item" begin="0">
              		<tr><td>${item.itemID}</td><td>${item.description}</td><td>${item.quantity}</td></tr>
              	</c:forEach>
              </table>
              <p>Wile E. Coyote and the ACME Corporation are creations of cartoonist
                  Chuck Jones. The image is from Wikipedia Commons.</p>
        </div>
    </body>
</html>
