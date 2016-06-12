<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ec.edu.epn.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Producto producto = (Producto) request.getAttribute("PRODUCTO");
	%>
	<form action="GuardarProductoModificado?id=<%=producto.getId()%>" method="post">
		<table>
			<tr>
				<th>id</th>
				<th>nombre</th>
				<th>valor</th>
				<th>stock</th>
			</tr>

			<tr>
				<td><%=producto.getId()%></td>
				<td><input type="text" name="txtnombre"
					value="<%=producto.getNombre()%>"></td>
				<td><input type="text" name="txtvalor"
					value="<%=producto.getValor()%>"></td>
				<td><input type="text" name="txtstock"
					value="<%=producto.getStock()%>"></td>
				<input type="submit" value="guardar cambios">
			</tr>
		</table>
	</form>
</body>
</html>