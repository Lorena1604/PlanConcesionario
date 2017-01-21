/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.facade;

import co.edu.consesionario.backend.entidades.Vehiculo;
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
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "PlanConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
    @Override
    public List<Vehiculo> listaPrecios(int precio){
        List<Vehiculo> vehiculo = null;
        String consulta;
        Query query;
        
        try{
          consulta ="SELECT v.codigoVehiculo, v.placa, v.marca, v.modelo, v.precio, v.idConcesionario, v.idEstado FROM vehiculos v WHERE v.precio >= ? ORDER BY v.precio";
        
          query = em.createNativeQuery(consulta,Vehiculo.class);  
          query.setParameter(1, precio);
          
            if (query.getResultList().size()>0) {
                vehiculo = query.getResultList();
            }
            
        }catch(Exception e){
            e.getMessage();
        }
        
        return vehiculo;
    }
    
}
