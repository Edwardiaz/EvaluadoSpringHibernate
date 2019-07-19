package net.evaluado.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

	@Entity
	@Table(name = "proveedores")
	public class Proveedor implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "idProveedor")
	    private Integer idProveedor;
	    @Column(name = "nombreProve")
	    private String nombreProve;
	    @Column(name = "telefono")
	    private String telefono;
	    @Column(name = "direccion")
	    private String direccion;
	    
	    @OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER)
	    private Set<Producto> productosProveSet;

	    public Proveedor() {
	    }

	    public Proveedor(Integer idProveedor) {
	        this.idProveedor = idProveedor;
	    }

		public Integer getIdProveedor() {
			return idProveedor;
		}

		public void setIdProveedor(Integer idProveedor) {
			this.idProveedor = idProveedor;
		}

		public String getNombreProve() {
			return nombreProve;
		}

		public void setNombreProve(String nombreProve) {
			this.nombreProve = nombreProve;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		@XmlTransient
	    public Set<Producto> getProductosProveSet() {
	        return productosProveSet;
	    }

	    public void setProductosProveSet(Set<Producto> productosProveSet) {
	        this.productosProveSet = productosProveSet;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Proveedor)) {
	            return false;
	        }
	        Proveedor other = (Proveedor) object;
	        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "entity.Categorias[ idProveedor=" + idProveedor + " ]";
	    }
	    
	}