package net.evaluado.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.evaluado.entity.Categoria;
import net.evaluado.entity.Producto;


	@Entity
	@Table(name = "productos")

	public class Producto  implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "idProducto")
	    private Integer idProducto;
	    @Column(name = "nombrePro")
	    private String nombrePro;
	    @Column(name = "precio")
	    private Double precio;
	    @Column(name = "fechaVencimiento")
	    private String fechaVen;
	    @Column(name = "idCategoria")
	    private int idCat;
	    @Column(name = "cantidad")
	    private Integer cantidad;
	    @Column(name = "idProveedor")
	    private int idProv;
	    @Column(name = "precioEspecial")
	    private double precioEspecial;
	    
	    @JoinColumn(name = "idCategoria", insertable=false, updatable=false)
	    @ManyToOne
	    private Categoria Categoria;
	    
	    @JoinColumn(name = "idProveedor", insertable=false, updatable=false)
	    @ManyToOne
	    private Proveedor proveedor;

	    public Producto() {
	    }

	    public Producto(Integer idProducto) {
	        this.idProducto = idProducto;
	    }

	    public Integer getIdProducto() {
			return idProducto;
		}

		public void setIdProducto(Integer idProducto) {
			this.idProducto = idProducto;
		}

		public String getNombrePro() {
			return nombrePro;
		}

		public void setNombrePro(String nombrePro) {
			this.nombrePro = nombrePro;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public String getFechaVen() {
			return fechaVen;
		}

		public void setFechaVen(String fechaVen) {
			this.fechaVen = fechaVen;
		}

		public int getIdCat() {
			return idCat;
		}

		public void setIdCat(int idCat) {
			this.idCat = idCat;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public int getIdProv() {
			return idProv;
		}

		public void setIdProv(int idProv) {
			this.idProv = idProv;
		}

		public Categoria getCategoria() {
			return Categoria;
		}

		public void setCategoria(Categoria categoria) {
			Categoria = categoria;
		}

		public Proveedor getProveedor() {
			return proveedor;
		}

		public void setProveedor(Proveedor proveedor) {
			this.proveedor = proveedor;
		}
		
		public double getPrecioEspecial() {
			return precioEspecial;
		}

		public void setPrecioEspecial(double precioEspecial) {
			this.precioEspecial = precioEspecial;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idProducto != null ? idProducto.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Producto)) {
	            return false;
	        }
	        Producto other = (Producto) object;
	        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "entity.Productos[ idProducto=" + idProducto + " ]";
	    }
	    
	}
