/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.util.List;
import javax.persistence.EntityManager;
import model.Hibernete.HibernateUtil;
import model.Medico;

/**
 *
 * @author Izaquias
 */
public class RepositorioMedico implements DaoGenerico<Medico> {

    private static EntityManager manager;

    public RepositorioMedico() {

    }

    @Override
    public void inserir(Medico m) {
        manager = HibernateUtil.getManager();

        RepositorioMedico.manager.getTransaction().begin();

        try {
            RepositorioMedico.manager.persist(m);
            RepositorioMedico.manager.getTransaction().commit();
            System.out.println("Médico cadastrado com sucesso!");

        } catch (Exception e) {
            RepositorioMedico.manager.getTransaction().rollback();
            System.out.println("Não foi possível cadastrar o médico, algo inexperado acorreu!");
        } finally {
            RepositorioMedico.manager.close();
            System.out.print("Fim da sessão!");
        }

    }

    @Override
    public void alterar(Medico m) {
        manager = HibernateUtil.getManager();

        RepositorioMedico.manager.getTransaction().begin();

        try {
            RepositorioMedico.manager.merge(m);
            RepositorioMedico.manager.getTransaction().commit();
            System.out.println("Médico alterado com sucesso!!");
        } catch (Exception e) {
            RepositorioMedico.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            RepositorioMedico.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public Medico recuperar(Long crm) {
        manager = HibernateUtil.getManager();
        
        try{
        return RepositorioMedico.manager.find(Medico.class, crm);
        } catch (Exception e) {
            System.out.println("Algo inexperado aconteceu!!");
            System.out.println(e.getMessage());
        } finally {
            RepositorioMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }

    @Override
    public void excluir(Medico m) {
        manager = HibernateUtil.getManager();

        RepositorioMedico.manager.getTransaction().begin();
        try {
            m = manager.find(Medico.class, m.getCrm());
            RepositorioMedico.manager.remove(m);
            RepositorioMedico.manager.getTransaction().commit();
            System.out.println("Médico removido com sucesso!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RepositorioMedico.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover o médico, reveja a operação!!!");
        } finally {
            RepositorioMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }

    }

    @Override
    public List<Medico> recuperarTodos() {

        manager = HibernateUtil.getManager();

        try {

            return (List) RepositorioMedico.manager.createQuery("select m from Medico m", Medico.class).getResultList();
        } catch (Exception e) {
            System.out.println("Algo inexperado aconteceu!!");
            System.out.println(e.getMessage());
        } finally {
            RepositorioMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }

        return null;
    }

}
