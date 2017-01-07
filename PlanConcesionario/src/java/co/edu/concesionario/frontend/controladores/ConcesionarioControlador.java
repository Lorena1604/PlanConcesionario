
package co.edu.concesionario.frontend.controladores;

import co.edu.concesionario.backend.entidades.Concesionario;
import co.edu.concesionario.backend.entidades.TipoUsuario;
import co.edu.concesionario.backend.facade.ConcesionarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@Named(value = "concesionarioControlador")
@RequestScoped
public class ConcesionarioControlador {

    @EJB
    private ConcesionarioFacadeLocal concesionarioFacade;
   
    private Concesionario concesionario;
    private TipoUsuario tipoUsuario;
    
    public ConcesionarioControlador() {
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @PostConstruct
    public void init(){
        concesionario = new Concesionario();
        tipoUsuario = new TipoUsuario(1);
    }
    
    public void registrarConsesionario(){
        
        try{
         concesionario.setTipoUsuario(tipoUsuario);
         concesionarioFacade.create(concesionario);
         manejarExito("registrar nuevo concesionario");
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
