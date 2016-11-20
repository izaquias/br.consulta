package model;

import model.Hibernete.HibernateUtil;
import javax.persistence.EntityManager;
import model.repository.RepositorioPaciente;
/**
 *
 * @author Izaquias
 */
public class TestandoPaciente {

    static EntityManager manager;

    public static void main(String[] args) {
        manager = HibernateUtil.getManager();

        Paciente p = new Paciente();
        RepositorioPaciente rp = new RepositorioPaciente();

       // p.setSUS(12249);
        p.setNome("Scorpion");
        p.setIdade(36);
        p.setEndereco("mortal");
        p.setSintoma("Go over here");
        
        rp.excluir(p);
        manager.getTransaction().begin();
        //manager.persist(p);
        manager.getTransaction().commit();
        manager.close();

    }
}
