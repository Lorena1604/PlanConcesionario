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
    public Concesionario validarConcesionario(Concesionario concesionarioRe){
     Concesionario concesionario = null;
     String consulta;
     try{
        consulta = "SELECT idConcesionario, nit, nombre, telefono, direccion, contrasena, tipoUsuario FROM concesionarios con WHERE con.nit = ? and con.contrasena = guardarContrasena(?)";
        Query query = em.createNativeQuery(consulta,Concesionario.class);
        query.setParameter(1, concesionarioRe.getNit());
        query.setParameter(2, concesionarioRe.getContrasena());
        
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
