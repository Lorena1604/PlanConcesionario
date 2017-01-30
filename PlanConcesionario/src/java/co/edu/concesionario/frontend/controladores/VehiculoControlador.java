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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "vehiculoControlador")
@RequestScoped
public class VehiculoControlador {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    @EJB
    private EstadoFacadeLocal estadoFacade;

    private Concesionario concesionario;
    private Vehiculo vehiculo;
    private List<Estado> estado;
    private List<Vehiculo> vehiculos;
    private int precioB;

    public VehiculoControlador() {
    }

    public int getPrecioB() {
        return precioB;
    }

    public void setPrecioB(int precioB) {
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
    
     public String redireccion(){
        return "listaVehiculos?faces-redirect=true";
    } 

    public List<Vehiculo> listaVehiculos() {
        List<Vehiculo> resultado=null;
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        resultado = vehiculoFacade.listaPrecios(getPrecioB());
        setPrecioB(0);
        }catch(Exception e){
              context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "" + e.getMessage()));
        }
        return resultado;
    }
    
   

}
