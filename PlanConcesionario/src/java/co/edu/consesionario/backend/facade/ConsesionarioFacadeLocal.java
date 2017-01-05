/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.consesionario.backend.facade;

import co.edu.consesionario.backend.entidades.Consesionario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ConsesionarioFacadeLocal {

    void create(Consesionario consesionario);

    void edit(Consesionario consesionario);

    void remove(Consesionario consesionario);

    Consesionario find(Object id);

    List<Consesionario> findAll();

    List<Consesionario> findRange(int[] range);

    int count();
    
}
