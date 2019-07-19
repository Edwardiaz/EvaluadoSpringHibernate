package net.evaluado.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.evaluado.entity.Proveedor;
import net.evaluado.util.HibernateUtil;

public class ProveedorDao {
	public void insertProveedor(Proveedor prov) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			transaccion = sesion.beginTransaction();
			sesion.save(prov);
			transaccion.commit();
		} catch (Exception e) {
			if(transaccion!=null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			System.out.println("ProvDao--->HAY UN PROBLEMA: "+e);
		}
	}
	
	public List<Proveedor> consultarProv(){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Proveedor", Proveedor.class).list();
		}
	}
	
	
}
