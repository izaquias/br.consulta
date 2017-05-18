package model.Dao;
//Falta a importação da classe de persistencia do banco de dados!

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernete.HibernateUtil;
import model.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Izaquias
 */
public class DaoPaciente implements DaoGenerico<Paciente> {

    private static EntityManager manager;

    public DaoPaciente() {

    }

    @Override
    public void inserir(Paciente p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoPaciente.manager.getTransaction().begin();
        try {
            //p.setSUS(null);
            DaoPaciente.manager.persist(p);
            DaoPaciente.manager.getTransaction().commit();
            System.out.println("Paciente salvo com Èxito!!!");

        } catch (Exception e) {

            DaoPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível cadastrar o paciente, aconteceu algo inexperado!!");
            System.out.println(e.getMessage());
            System.out.println((e.getCause()));
        } finally {
            DaoPaciente.manager.close();
            System.out.println("Fim da sessão!");
        }

    }

    @Override
    public void alterar(Paciente p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoPaciente.manager.getTransaction().begin();

        try {
            DaoPaciente.manager.merge(p);
            DaoPaciente.manager.getTransaction().commit();
            System.out.println("Paciente alterado com sucesso!!");
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente " + " alterado com sucesso!!!"));
        } catch (Exception e) {
            DaoPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            DaoPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public Paciente recuperar(Long SUS) {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {

            return (Paciente) DaoPaciente.manager.find(Paciente.class, SUS);

        } catch (Exception e) {
            System.out.println("SUS inválido, não foi possível encontrar o requerido paciente.");
            System.out.println(e.getMessage());
        } finally {
            DaoPaciente.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }

    @Override
    public void excluir(Paciente p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoPaciente.manager.getTransaction().begin();

        try {
            p = DaoPaciente.manager.find(Paciente.class, p.getSUS());
            DaoPaciente.manager.remove(p);
            DaoPaciente.manager.getTransaction().commit();
            System.out.println("Paciente deletado com sucesso!!");

        } catch (Exception e) {
            DaoPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar essa operação!!");
            System.out.println(e.getMessage());

        } finally {
            DaoPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public List<Paciente> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) DaoPaciente.manager.createQuery("select p from Paciente p", Paciente.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            DaoPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }
    
     public Paciente recuperarPacienteEmailSenha(String email, String senha) {
        
        String hql = "from Paciente p where e_mail=:emailPaciente and senha=:senhaPaciente";
        
        Paciente p = null;
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            Query query = manager.createQuery(hql);
            p = (Paciente) query.setParameter("emailPaciente", email).setParameter("senhaPaciente", senha).getSingleResult();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return p;
    }

}
