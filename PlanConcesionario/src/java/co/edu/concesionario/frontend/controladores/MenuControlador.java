
package co.edu.concesionario.frontend.controladores;

import co.edu.consesionario.backend.entidades.Cliente;
import co.edu.consesionario.backend.entidades.Concesionario;
import co.edu.consesionario.backend.entidades.Permiso;
import co.edu.consesionario.backend.facade.PermisoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuControlador")
@SessionScoped
public class MenuControlador implements Serializable{
    
    @EJB
    private PermisoFacadeLocal permisoFacade;
    
    private List<Permiso> listaPermisos;
    private MenuModel modelo;
    
    public MenuControlador() {
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        modelo = new DefaultMenuModel();
        this.establecerPermisos();
    }
    
    public void listarMenus(){
        try{
            listaPermisos =  permisoFacade.findAll();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public void establecerPermisos(){
        Cliente cliente;
        FacesContext context = FacesContext.getCurrentInstance();
        
        for (Permiso per : listaPermisos) {
            cliente = (Cliente) context.getExternalContext().getSessionMap().get("Cliente");
            if (per != null && per.getIdTipoUsuario().equals(cliente.getTipo())) {
               DefaultMenuItem menu = new DefaultMenuItem(per.getNombre());
               menu.setUrl(per.getUrlPermiso());
               modelo.addElement(menu);
            }
        }
    }
}
