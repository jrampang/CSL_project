/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Winemaker;

/**
 *
 * @author jrampang
 */
@Stateless
public class WinemakerFacade extends AbstractFacade<Winemaker> {

    @PersistenceContext(unitName = "CSL_project_2019_winePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WinemakerFacade() {
        super(Winemaker.class);
    }
    
}
