package net.evaluado.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.evaluado.entity.Producto;
import net.evaluado.util.HibernateUtil;

@Repository
public class ProductoDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public void insertarProducto(Producto pro) {
		Transaction transaccion = null;
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.save(pro);
			transaccion.commit();

		} catch (Exception e) {

			if (transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			System.out.println("ProdDao--->HAY UN PROBLEMA: " + e);
		}
	}

	public List<Producto> consultarProductos() {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			return sesion.createQuery("from Producto", Producto.class).list();
		}

	}
	
	public void eliminarProducto(int id) {
		Transaction transaccion = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Producto pro = (Producto) sesion.load(Producto.class, new Integer(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.delete(pro);
			transaccion.commit();
		}
	}
	
	public void consultarById(int id) {
		Transaction transaccion = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Producto pro = (Producto) sesion.load(Producto.class, new Integer(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.update(pro);
			transaccion.commit();
		}
	}
	
//	public Producto productoById(int id) {
//		Session sesion;
//		CriteriaBuilder builder = sesion.getCriteriaBuilder();
//		
//		CriteriaQuery <Producto> crit = builder.createQuery(Producto.class);
//		crit.from(Producto.class);
//
//		return crit.getResultType(Producto.class);
//	}

//	public Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	public void EliminarProducto(Producto prod) {
//		getSession().delete(prod);
//	}
}
