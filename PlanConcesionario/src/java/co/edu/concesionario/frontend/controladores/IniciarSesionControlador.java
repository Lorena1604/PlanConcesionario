package co.edu.concesionario.frontend.controladores;

import co.edu.consesionario.backend.entidades.Cliente;
import co.edu.consesionario.backend.entidades.Concesionario;
import co.edu.consesionario.backend.facade.ClienteFacadeLocal;
import co.edu.consesionario.backend.facade.ConcesionarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named(value = "iniciarSesionControlador")
@RequestScoped
public class IniciarSesionControlador implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private ConcesionarioFacadeLocal concesionarioFacade;

    private Cliente cliente;
    private Concesionario concesionario;
    private long usuario;
    private String contrasenaU;

    public IniciarSesionControlador() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public String getContrasenaU() {
        return contrasenaU;
    }

    public void setContrasenaU(String contrasenaU) {
        this.contrasenaU = contrasenaU;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        concesionario = new Concesionario();
    }

    public String iniciarSesion() {
        Cliente clienteU;
        Concesionario concesionarioU;
        String redireccion = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            cliente.setCedula(getUsuario());
            cliente.setContrasena(getContrasenaU());
            clienteU = clienteFacade.validarCliente(cliente);
            if (clienteU != null) {
                redireccion = "registrarCliente";
            } else {

                concesionario.setNit(getUsuario());
                concesionario.setContrasena(getContrasenaU());
                concesionarioU = concesionarioFacade.validarConcesionario(concesionario);
                if (concesionarioU != null) {
                    redireccion = "registrarCliente";
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario incorrecto"));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "" + e.getMessage()));
        }
        return redireccion;
    }

}
