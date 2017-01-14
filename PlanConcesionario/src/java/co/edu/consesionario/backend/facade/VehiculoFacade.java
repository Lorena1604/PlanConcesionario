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
    public List<Vehiculo> listaPrecios(Long precio){
        List<Vehiculo> vehiculo = null;
        String consulta;
        Query query;
        
        try{
          consulta ="SELECT v.marca, v.modelo, v.precio, c.nombre, e.descripcion FROM vehiculos v "
                  + "JOIN concesionarios c ON v.idConcesionario = c.idConcesionario "
                  + "JOIN estados e ON v.idEstado = e.idEstado WHERE v.precio >= ?1";
        
          query = em.createQuery(consulta);
          query.setParameter(1, precio);
          
          List<Vehiculo> lista = query.getResultList();
            if (!lista.isEmpty()) {
                vehiculo = (List<Vehiculo>) lista.get(0);
            }
            
        }catch(Exception e){
            e.getMessage();
        }
        
        return vehiculo;
    }
    
}
