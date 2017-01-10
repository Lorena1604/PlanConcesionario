/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "concesionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concesionario.findAll", query = "SELECT c FROM Concesionario c"),
    @NamedQuery(name = "Concesionario.findByIdConcesionario", query = "SELECT c FROM Concesionario c WHERE c.idConcesionario = :idConcesionario"),
    @NamedQuery(name = "Concesionario.findByNit", query = "SELECT c FROM Concesionario c WHERE c.nit = :nit"),
    @NamedQuery(name = "Concesionario.findByNombre", query = "SELECT c FROM Concesionario c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concesionario.findByTelefono", query = "SELECT c FROM Concesionario c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Concesionario.findByDireccion", query = "SELECT c FROM Concesionario c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Concesionario.findByContrasena", query = "SELECT c FROM Concesionario c WHERE c.contrasena = :contrasena")})
public class Concesionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConcesionario")
    private Integer idConcesionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private long nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 85)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "tipoUsuario", referencedColumnName = "idtipoUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoUsuario tipoUsuario;

    public Concesionario() {
    }

    public Concesionario(Integer idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public Concesionario(Integer idConcesionario, long nit, String nombre, int telefono, String direccion, String contrasena) {
        this.idConcesionario = idConcesionario;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public Integer getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(Integer idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcesionario != null ? idConcesionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concesionario)) {
            return false;
        }
        Concesionario other = (Concesionario) object;
        if ((this.idConcesionario == null && other.idConcesionario != null) || (this.idConcesionario != null && !this.idConcesionario.equals(other.idConcesionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.consesionario.backend.entidades.Concesionario[ idConcesionario=" + idConcesionario + " ]";
    }
    
}
