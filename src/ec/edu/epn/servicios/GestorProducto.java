package ec.edu.epn.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.model.Producto;

public class GestorProducto {

	public List<Producto> consultaProducto(String nombreBusqueda) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenciaExamen");
		EntityManager em = emf.createEntityManager();
		List<Producto> productos = new ArrayList<Producto>();
		Query q = em.createQuery(
				"select p from Producto as p where p.nombre like ?",
				Producto.class);
		q.setParameter(1, nombreBusqueda + "%");
		productos = q.getResultList();
		return productos;
	}

	public Producto obtenerProducto(String idActualizar) {
		Integer id = Integer.parseInt(idActualizar);
		List<Producto> productos = new ArrayList<Producto>();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenciaExamen");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select p from Producto as p where p.id=?",
				Producto.class);
		q.setParameter(1, id);
		productos = q.getResultList();
		return productos.get(0);
	}

	public void guardarCambiosProducto(Producto producto) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenciaExamen");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		em.close();

	}

	public void eliminarProducto(String idEliminar) {
	
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenciaExamen");
		EntityManager em = emf.createEntityManager();
		Producto producto = em.find(Producto.class, Integer.parseInt(idEliminar));
		em.getTransaction().begin();
		em.remove(producto);
		em.getTransaction().commit();
		em.close();
		
	}
}
