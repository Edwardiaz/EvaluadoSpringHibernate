package net.evaluado.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.evaluado.dao.CategoriaDao;
import net.evaluado.dao.ProductoDao;
import net.evaluado.dao.ProveedorDao;
import net.evaluado.entity.Categoria;
import net.evaluado.entity.Producto;
import net.evaluado.entity.Proveedor;
import net.evaluado.servicios.ServicioProducto;

@Controller
public class EvaluadoController {
	double cate;
	ServicioProducto servicioPro;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String handler(Model m) {

		return "index";
	}

//producto
	@RequestMapping(value = "/proo")
	public String insertarProductos(
			
			@RequestParam(value = "nombrePro") String nombrePro,
			@RequestParam(value = "precio") double precio, 
			@RequestParam(value = "fechav") String fecha,
			@RequestParam(value = "categoria") int idCategoria, 
			@RequestParam(value = "cantidad") int cantidad,
			@RequestParam(value = "proveedor") int idProveedor) {
		
		ProductoDao proDao = new ProductoDao();
		Producto prod = new Producto();

		prod.setNombrePro(nombrePro);
		if(idCategoria==1) {
			
			cate=precio+precio*0.1;
		prod.setPrecioEspecial(cate);
		}else if(idCategoria==2) {
			cate=precio+precio*0.3;
			prod.setPrecioEspecial(cate);
		}
		else if(idCategoria==3) {
			cate=precio+precio*0.15;
			prod.setPrecioEspecial(cate);
		}
		else if(idCategoria==4) {
			cate=precio+precio*0.7;
			prod.setPrecioEspecial(cate);
		}
		prod.setPrecio(precio);
		prod.setFechaVen(fecha);
		prod.setIdCat(idCategoria);
		prod.setCantidad(cantidad);
		prod.setIdProv(idProveedor);
		proDao.insertarProducto(prod);

		return "index";
	}

	@RequestMapping("/listaP")
	public String consultarProducto(Model m) {
		ProductoDao proDao = new ProductoDao();

		List<Producto> listaPro = proDao.consultarProductos();
		m.addAttribute("listaPro", listaPro);
		return "productosMostrar";
	}
	
	@RequestMapping(value = "/eliminar/{idProducto}", method = RequestMethod.GET)
	public String eliminarProducto(@PathVariable("idProducto") int id) {
		ProductoDao proDao = new ProductoDao();
		proDao.eliminarProducto(id);
		return "productosMostrar";
 
	}

//	@RequestMapping("/Evaluado/{idProducto}/EliminarProducto")
//	public String eliminarProducto(@PathVariable("idProducto") int idProducto) {
//
//		
//		
//		return "productosMostrar";
//	}

//fin producto
	// inicio categoria
	@RequestMapping("/listaC")
	public String consultarCategoria(Model m) {
		CategoriaDao catDao = new CategoriaDao();
		// Categoria categoria = new Categoria();
		List<Categoria> listaCate = catDao.consultarCat();
		m.addAttribute("listaCat", listaCate);
		return "mostrarCat";
	}

	// fin categoria
//inicio proveedor
	@RequestMapping(value = "/proveedor")
	public String insertarProveedor(
			@RequestParam(value = "nombreProv") String nombreProv,
			@RequestParam(value = "telefono") String telefono,
			@RequestParam(value = "direccion") String direccion) {
		ProveedorDao provDao = new ProveedorDao();
		Proveedor prov = new Proveedor();

		prov.setNombreProve(nombreProv);
		prov.setTelefono(telefono);
		prov.setDireccion(direccion);
		provDao.insertProveedor(prov);
		return "index";
	}

	@RequestMapping("/listaProv")
	public String consultarProveedores(Model m) {
		ProveedorDao provDao = new ProveedorDao();

		List<Proveedor> listaProv = provDao.consultarProv();
		m.addAttribute("listaProv", listaProv);
		return "proveedorMostrar";
	}
	// fin proveedor
}
