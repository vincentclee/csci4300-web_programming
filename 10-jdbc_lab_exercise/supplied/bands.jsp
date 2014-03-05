<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 body {font-family:Sans-serif}
 </style>
<title>My Favorite Bands</title>

</head>
<body>
<h1>My Favorite Bands and their Albums</h1>
<p>(Mockup version)</p>
<ul>
<li>Nightwish
<ul><li>Dark Passion Play</li></ul></li>

<li>Drive-by Truckers
<ul>
  <li>Southern Rock Opera</li>
  <li>Brighter Than Creation's Dark</li>
  </ul></li>
<li>Glenn Miller Orchestra
<ul>
<li>In the Mood</li>
<li>Tuxedo Junction</li>
</ul></li></ul>
<h1>Enter a new Band</h1>
<form method="post" action="bands.jsp">
Band Name: <input type="text" name="bandName">
<input type="submit" value="Add Band">
</form>
<h1>Enter a new Album</h1>
<form method="post" action="bands.jsp">
Band Name: <select name="bandId">
  <option value="1">Nightwish</option>
  <option value="2">Drive-by Truckers</option>
  <option value="3">Glenn Miller Orchestra</option>
  </select>&nbsp&nbsp;
Album Title: <input type="text" name="albumName">
<input type="submit" value="Add Album">
</form>
</body>
</html>