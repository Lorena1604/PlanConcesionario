package co.edu.concesionario.frontend.controladores;

import co.edu.consesionario.backend.entidades.Concesionario;
import co.edu.consesionario.backend.entidades.Estado;
import co.edu.consesionario.backend.entidades.Vehiculo;
import co.edu.consesionario.backend.facade.ConcesionarioFacadeLocal;
import co.edu.consesionario.backend.facade.EstadoFacadeLocal;
import co.edu.consesionario.backend.facade.VehiculoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "vehiculoControlador")
@RequestScoped
public class VehiculoControlador {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    @EJB
    private ConcesionarioFacadeLocal concesionarioFacade;
    @EJB
    private EstadoFacadeLocal estadoFacade;

    private Concesionario concesionario;
    private Vehiculo vehiculo;
    private List<Estado> estado;
    private List<Vehiculo> vehiculos;
    private Long precioB;

    public VehiculoControlador() {
    }

    public Long getPrecioB() {
        return precioB;
    }

    public void setPrecioB(Long precioB) {
        this.precioB = precioB;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Estado> getEstado() {
        estado = estadoFacade.findAll();
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public List<Vehiculo> getVehiculos() {
        vehiculos = vehiculoFacade.findAll();
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
    }
    
     public String redireccion(Long precio){
         this.precioB = precio;
        return "listarVehiculos";
    } 

    public List<Vehiculo> listaVehiculos() {
        List<Vehiculo> listaPrecios = null;
        vehiculos = vehiculoFacade.listaPrecios(precioB);
        return listaPrecios;
    }
    
   

}
