
package co.edu.concesionario.frontend.controladores;

import co.edu.concesionario.backend.entidades.Cliente;
import co.edu.concesionario.backend.entidades.TipoUsuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import co.edu.concesionario.backend.facade.ClienteFacadeLocal;
import co.edu.concesionario.backend.facade.TipoUsuarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@Named(value = "clienteControlador")
@RequestScoped
public class ClienteControlador {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB 
    private TipoUsuarioFacadeLocal tipoUsuarioFacade;
    
    private Cliente cliente;
    private TipoUsuario tipoUsuario;
    
    public ClienteControlador() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        tipoUsuario = new TipoUsuario(2);
    }
    
    public void registrarCliente(){
        
        try{
         cliente.setTipoUsuario(tipoUsuario);
         clienteFacade.create(cliente);
         manejarExito("registrar nuevo cliente");
        }catch(Exception e){
            manejarError(e);
        }
    }

     private void manejarError(Exception e){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"se produjo el siguiente error: ",e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al insertar: ",e.getMessage());
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }
    
    private void manejarExito(String operacion){
        String msg = "Se ha realizado exitosamente la operacion de "+operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción exitosa: ",msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }
    
}
