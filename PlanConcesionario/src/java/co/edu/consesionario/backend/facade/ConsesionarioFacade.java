/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.facade;

import co.edu.consesionario.backend.entidades.Consesionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class ConsesionarioFacade extends AbstractFacade<Consesionario> implements ConsesionarioFacadeLocal {

    @PersistenceContext(unitName = "PlanConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsesionarioFacade() {
        super(Consesionario.class);
    }
    
}
