<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, ec.edu.epn.model.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de productos</h1>
	<a href="MostrarProductosCtrl">mostrarProductos</a>

	<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>valor</th>
			<th>stock</th>
			<th>actualizar</th>
			<th>eliminar</th>
		</tr>
		<%
			List<Producto> productos = (List<Producto>) request
					.getAttribute("PRODUCTOS");
			if (productos != null) {
				for (Producto p : productos) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getNombre() %></td>
			<td><%=p.getValor() %></td>
			<td><%=p.getStock() %></td>
			<td><a href="ActualizarProductoCtrl?id=<%= p.getId()%>">Actualizar</a></td>
			<td><a href="EliminarProductoCtrl?id=<%=p.getId() %>">Eliminar</td>
		</tr>
		<%
			}
			}
		%>

	</table>
</body>
</html>