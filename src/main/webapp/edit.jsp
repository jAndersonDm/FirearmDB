<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Firearm database</title>
</head>
<body>

<h2>Edit a firearm </h2>
<form action = "EditItemServlet" method="post">
<label for="company">Company:</label><input type ="text" name = "company" value= "${editIt.gun.company}"><br />
<label for="type">Type:<input type="text" name="type"  value="${editIt.gun.type}"></label>
<label for="ammo">Ammunition:<input type="text" name="ammo"  value="${editIt.ammo}"></label>
<br />
<input type = "hidden" name = "id" value="${editIt.id}">
<input type = "submit" value="Save">
</form>
</body>
</html>