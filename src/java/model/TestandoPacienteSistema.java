/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Hibernete.HibernateUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TestandoPacienteSistema {
    static EntityManager manager;
    
    public static void main(String [] args){
        manager = HibernateUtil.getManager();

        Paciente p = new Paciente();
        
        Sistema s = new Sistema();
        
        s.setLogin("mahatmaGandi@gmail.com");
        s.setSenha("gandi2122");

       // p.setSUS(12249);
        p.setNome("Gandi");
        p.setIdade(46);
        p.setEndereco("india");
        p.setSintoma("lutapela paz");
        p.setSistema(s);

        manager.getTransaction().begin();
        manager.persist(s);
        manager.persist(p);
        manager.getTransaction().commit();
        manager.close();
    }
}
