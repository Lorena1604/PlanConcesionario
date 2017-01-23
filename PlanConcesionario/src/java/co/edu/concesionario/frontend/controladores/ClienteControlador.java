package co.edu.concesionario.frontend.controladores;

import co.edu.consesionario.backend.entidades.Cliente;
import co.edu.consesionario.backend.facade.ClienteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "clienteControlador")
@RequestScoped
public class ClienteControlador {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    private Cliente cliente;
    private List<Cliente> listaClientes;

    public ClienteControlador() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        listaClientes = clienteFacade.findAll();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        this.getListaClientes();
    }
}
