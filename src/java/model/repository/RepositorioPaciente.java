package model.repository;
//Falta a importação da classe de persistencia do banco de dados!

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernete.HibernateUtil;
import model.Paciente;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class RepositorioPaciente implements DaoGenerico<Paciente> {

    private static EntityManager manager;

    public RepositorioPaciente() {

    }

    @Override
    public void inserir(Paciente p) {
        manager = HibernateUtil.getManager();

        RepositorioPaciente.manager.getTransaction().begin();
        try {
            //p.setSUS(null);
            RepositorioPaciente.manager.persist(p);
            RepositorioPaciente.manager.getTransaction().commit();

        } catch (Exception e) {

            RepositorioPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível cadastrar o paciente, aconteceu algo inexperado!!");
            System.out.println(e.getMessage());
        } finally {
            RepositorioPaciente.manager.close();
            System.out.println("Fim da sessão!");
        }

    }

    @Override
    public void alterar(Paciente p) {
        manager = HibernateUtil.getManager();

        RepositorioPaciente.manager.getTransaction().begin();

        try {
            RepositorioPaciente.manager.merge(p);
            RepositorioPaciente.manager.getTransaction().commit();
            System.out.println("Paciente alterado com sucesso!!");
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente " + " alterado com sucesso!!!"));
        } catch (Exception e) {
            RepositorioPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            RepositorioPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public Paciente recuperar(Long SUS) {

        manager = HibernateUtil.getManager();

        try {

            return (Paciente) RepositorioPaciente.manager.find(Paciente.class, SUS);

        } catch (Exception e) {
            System.out.println("SUS inválido, não foi possível encontrar o requerido paciente.");
            System.out.println(e.getMessage());
        } finally {
            RepositorioPaciente.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }

    @Override
    public void excluir(Paciente p) {
        manager = HibernateUtil.getManager();

        RepositorioPaciente.manager.getTransaction().begin();

        try {
            p = RepositorioPaciente.manager.find(Paciente.class, p.getSUS());
            RepositorioPaciente.manager.remove(p);
            RepositorioPaciente.manager.getTransaction().commit();
            System.out.println("Paciente deletado com sucesso!!");

        } catch (Exception e) {
            RepositorioPaciente.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar essa operação!!");
            System.out.println(e.getMessage());

        } finally {
            RepositorioPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public List<Paciente> recuperarTodos() {
        manager = HibernateUtil.getManager();

        try {
            return (List) RepositorioPaciente.manager.createQuery("select p from Paciente p", Paciente.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            RepositorioPaciente.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

}
