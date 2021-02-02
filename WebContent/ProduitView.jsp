<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@  taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Recherche</title>
</head>
<body>
	<form action="controlleur" method="post" >
		<input type="text" name ="motCle" value ="${modele.motCle}">
		<input type ="submit" value="OK">
	</form>
	<table border="1" width="80%">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
		
		<c:forEach items="${modele.produits}" var="p">
			<tr>
				<td>${p.idProduit}</td>
				<td>${p.nomProduit}</td>
				<td>${p.prix}</td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>
			