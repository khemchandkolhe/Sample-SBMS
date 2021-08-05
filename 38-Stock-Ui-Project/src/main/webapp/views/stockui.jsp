<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3 align="center">
		Stock Ui Application
		<h3>
			<h3 align="center">${totalStockPrice}</h3>
			<form action="getTotalCost" method="POST">
				<table align="center" border="1">
					<tr>
						<td>Company Name</td>
						<td><input type="text" name="cname"></td>
					</tr>
					<tr>
						<td>Quntity</td>
						<td><input type="text" name="qty"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="GetTotalCost"></td>
					</tr>
				</table>
</body>
</html>