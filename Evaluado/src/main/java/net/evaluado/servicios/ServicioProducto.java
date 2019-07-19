package net.evaluado.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.evaluado.dao.ProductoDao;

@Service("servicioPro")
public class ServicioProducto {
	
	@Autowired
	ProductoDao proDao;

	@Transactional
	public void eliminarProducto(int id) {
		proDao.eliminarProducto(id);
	}
}
