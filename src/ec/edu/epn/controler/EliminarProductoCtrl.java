package ec.edu.epn.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.servicios.GestorProducto;

/**
 * Servlet implementation class EliminarProductoCtrl
 */
@WebServlet("/adminProd/EliminarProductoCtrl")
public class EliminarProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoCtrl() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idEliminar = request.getParameter("id");
		GestorProducto gp = new GestorProducto();
		gp.eliminarProducto (idEliminar);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adminProd/mostrarProductos.jsp");
		rd.forward(request, response);
	}

}
