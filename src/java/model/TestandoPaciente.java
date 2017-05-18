package model;

import model.Hibernete.HibernateUtil;
import javax.persistence.EntityManager;
import model.Dao.DaoPaciente;
/**
 *
 * @author Izaquias
 */
public class TestandoPaciente {

    static EntityManager manager;

    public static void main(String[] args) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
         
        //Remove o registro passado,caso exista no banco!
        //Obs.: Funciona se a devida classe não possui ORM
        Paciente p = new Paciente();
        DaoPaciente rp = new DaoPaciente();

       // p.setSUS(12249);
        p.setNome("Scorpion");
        p.setIdade(36);
        p.setEndereco("mortal");
        p.setSintoma("Go over here");
        
        rp.excluir(p);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();

    }
}
