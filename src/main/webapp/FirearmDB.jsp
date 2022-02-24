<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Firearm Database</title>
</head>
<body>
<div class="container">
<h1>Firearm database</h1>

<form method = "post" action = "NavServlet" >
<table class="table table-striped table-hover">
<c:forEach items="${requestScope.allGuns}" var="currentitem">
<tr>
   <td><input type="radio" name="id" value="${currentitem.gun.id}"></td>
   <td>${currentitem.gun.company}</td>
   <td>${currentitem.gun.type}</td>
   <td>${currentitem.ammo}</td>
   </tr>
</c:forEach>
</table>
<input type = "submit" value="edit" name="eItem">
<input type = "submit" value="delete" name="eItem">
</form>
</div>
<button type="button" onclick="window.location.href='index.html';">Go back to main menu</button>

</body>
</html>