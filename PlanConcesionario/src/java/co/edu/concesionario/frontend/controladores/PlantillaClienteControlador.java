package co.edu.concesionario.frontend.controladores;

import co.edu.consesionario.backend.entidades.Cliente;
import co.edu.consesionario.backend.entidades.Concesionario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "plantillaClienteControlador")
@ViewScoped
public class PlantillaClienteControlador implements Serializable {

    public PlantillaClienteControlador() {
    }

    public void verificarSesionCliente() {
        Cliente cliente;
        IniciarSesionControlador aux = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
                cliente = (Cliente) context.getExternalContext().getSessionMap().get("Cliente");
                if (cliente == null) {
                    context.getExternalContext().redirect("permisos.xhtml");
                }

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
       public void verificarSesionConcesionario() {
        Concesionario concesionario;
        IniciarSesionControlador aux = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
                concesionario = (Concesionario) context.getExternalContext().getSessionMap().get("Concesionario");
                if (concesionario == null) {
                    context.getExternalContext().redirect("permisos.xhtml");
                }
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
