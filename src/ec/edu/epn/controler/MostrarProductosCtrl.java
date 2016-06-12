package ec.edu.epn.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.model.Producto;
import ec.edu.epn.servicios.GestorProducto;

@WebServlet("/adminProd/MostrarProductosCtrl")
public class MostrarProductosCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MostrarProductosCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorProducto gp = new GestorProducto();
		List<Producto> productos = null;
		productos= gp.consultaProducto("");
		//publicar en la request
		request.setAttribute("PRODUCTOS" ,productos);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adminProd/mostrarProductos.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
