/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.facade;

import co.edu.consesionario.backend.entidades.Concesionario;
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
public class ConcesionarioFacade extends AbstractFacade<Concesionario> implements ConcesionarioFacadeLocal {

    @PersistenceContext(unitName = "PlanConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcesionarioFacade() {
        super(Concesionario.class);
    }
    
    @Override
    public Concesionario validarConcesionario(long nitU, String usuario){
     Concesionario concesionario = null;
     String consulta;
     try{
        consulta = "FROM concesionario con WHERE con.nit = ?1 and con.nombre = guardarContrasena(?2)";
        Query query = em.createQuery(consulta);
        query.setParameter(1, nitU);
        query.setParameter(2, usuario);
        
        List<Concesionario> listaCon = query.getResultList();
         if (!listaCon.isEmpty()) {
             concesionario = listaCon.get(0);
         }
        
     }catch(Exception e){
         throw e;
     }
     
     return concesionario;   
    }
}
