/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.facade;

import co.edu.consesionario.backend.entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "PlanConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    @Override
    public Cliente validarCliente(Cliente clienteRegistrado){
       Cliente cliente = null;
       String consulta;
       try{
         consulta = "FROM clientes c WHERE c.cedula =?1 and c.contrasena =guardarContrasena(?2)";
         Query query = em.createQuery(consulta);
         query.setParameter(1, clienteRegistrado.getCedula());
         query.setParameter(2, clienteRegistrado.getContrasena());
         
         List<Cliente> lista = query.getResultList();
           if (!lista.isEmpty()) {
               cliente = lista.get(0);
           }
       }catch(Exception e){
            e.getMessage();
       }
       
       return cliente;
    }
    
}
