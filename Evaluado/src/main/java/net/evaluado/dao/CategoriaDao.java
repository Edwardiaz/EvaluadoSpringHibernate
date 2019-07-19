package net.evaluado.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.evaluado.entity.Categoria;
import net.evaluado.util.HibernateUtil;

public class CategoriaDao {
	
	public void insertCategoria(Categoria cat) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			transaccion = sesion.beginTransaction();
			sesion.save(cat);
			transaccion.commit();
		} catch (Exception e) {
			if(transaccion!=null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			System.out.println("CatDao--->HAY UN PROBLEMA: "+e);
		}
	}
	
	public List<Categoria> consultarCat(){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Categoria", Categoria.class).list();
		}
	}

}
