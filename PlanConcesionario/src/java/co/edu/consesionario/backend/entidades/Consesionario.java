/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "consesionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consesionario.findAll", query = "SELECT c FROM Consesionario c"),
    @NamedQuery(name = "Consesionario.findByNit", query = "SELECT c FROM Consesionario c WHERE c.nit = :nit"),
    @NamedQuery(name = "Consesionario.findByNombre", query = "SELECT c FROM Consesionario c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Consesionario.findByTelefono", query = "SELECT c FROM Consesionario c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Consesionario.findByDireccion", query = "SELECT c FROM Consesionario c WHERE c.direccion = :direccion")})
public class Consesionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private Integer nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nitConsesionario", fetch = FetchType.EAGER)
    private List<Vehiculo> vehiculoList;

    public Consesionario() {
    }

    public Consesionario(Integer nit) {
        this.nit = nit;
    }

    public Consesionario(Integer nit, String nombre, String direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consesionario)) {
            return false;
        }
        Consesionario other = (Consesionario) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.consesionario.backend.entidades.Consesionario[ nit=" + nit + " ]";
    }
    
}
