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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "detalleventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d"),
    @NamedQuery(name = "Detalleventa.findByIddetalleVenta", query = "SELECT d FROM Detalleventa d WHERE d.iddetalleVenta = :iddetalleVenta"),
    @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalleVenta")
    private Integer iddetalleVenta;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "codigoVehiculo", referencedColumnName = "codigoVehiculo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Vehiculo codigoVehiculo;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Venta idVenta;

    public Detalleventa() {
    }

    public Detalleventa(Integer iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public Integer getIddetalleVenta() {
        return iddetalleVenta;
    }

    public void setIddetalleVenta(Integer iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Vehiculo getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(Vehiculo codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleVenta != null ? iddetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.iddetalleVenta == null && other.iddetalleVenta != null) || (this.iddetalleVenta != null && !this.iddetalleVenta.equals(other.iddetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.consesionario.backend.entidades.Detalleventa[ iddetalleVenta=" + iddetalleVenta + " ]";
    }
    
}
