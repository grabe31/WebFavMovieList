<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Movie: <input type ="text" name = "title" value= "${itemToEdit.title}">
Director: <input type = "text" name = "director" value= "${itemToEdit.director}">
Year: <input type = "text" name = "year" value= "${itemToEdit.year}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>