package ec.edu.epn.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.model.Producto;
import ec.edu.epn.servicios.GestorProducto;

/**
 * Servlet implementation class ActualizarProductoCtrl
 */
@WebServlet("/adminProd/ActualizarProductoCtrl")
public class ActualizarProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarProductoCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.print("id rescatado"+ request.getParameter("id"));
		String idActualizar = request.getParameter("id");
		System.out.print("id rescatado"+ idActualizar);
//		llamar al modelo
		GestorProducto gp= new GestorProducto();
		Producto producto = new Producto();
		producto = gp.obtenerProducto(idActualizar);
//		publicar los resultados
		request.setAttribute("PRODUCTO", producto);
//		redireccionar a la vista de edicion de producto
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adminProd/actualizarProducto.jsp");
		rd.forward(request, response);
		
	
	}

}
