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

@WebServlet("/adminProd/GuardarProductoModificado")
public class GuardarProductoModificado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuardarProductoModificado() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		receptamos los parametros
		String idActualizar = request.getParameter("id");
		String nombre = request.getParameter("txtnombre");
		String valor = request.getParameter("txtvalor");
		String stock = request.getParameter("txtstock");
//		preparamos los valores
		Producto producto = new Producto();
		producto.setId(Integer.parseInt(idActualizar));
		producto.setNombre(nombre);
		producto.setValor(valor);
		producto.setStock(stock);
//		llamamos al modelo
		GestorProducto gp = new GestorProducto();
		gp.guardarCambiosProducto(producto);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adminProd/mostrarProductos.jsp");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
