/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Countries;

/**
 *
 * @author jrampang
 */
@Stateless
public class CountriesFacade extends AbstractFacade<Countries> {

    @PersistenceContext(unitName = "CSL_project_2019_winePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountriesFacade() {
        super(Countries.class);
    }
    
}
