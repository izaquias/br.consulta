/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hibernete;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Izaquias
 */
public class HibernateUtil {

    private final EntityManagerFactory factory;
    private static HibernateUtil hibernateUtil;

    private HibernateUtil() {
        factory = Persistence.createEntityManagerFactory("Persistencia");
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

}
