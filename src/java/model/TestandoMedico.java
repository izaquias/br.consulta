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
public class TestandoMedico {

    static EntityManager manager;

    public static void main(String[] args) {

        manager = HibernateUtil.getManager();
        Sistema s = new Sistema();
        Medico m = new Medico();

        s.setLogin("Izaquiascavalcante@gmail.com");
        s.setSenha("izaquias1222");

        m.setNome("Izaquias cavalcante");
        m.setIdade(32);
        m.setEspecialidade("Dermatologista");
        m.setSalario(2000);
        m.setSistema(s);

        manager.getTransaction().begin();
        manager.persist(m);
        manager.persist(s);
        
        manager.getTransaction().commit();
        manager.close();

    }

}
