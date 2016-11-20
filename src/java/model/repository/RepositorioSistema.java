/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import model.Hibernete.HibernateUtil;
import model.Sistema;

/**
 *
 * @author Izaquias
 */
public class RepositorioSistema implements DaoGenerico<Sistema> {

    private static EntityManager manager;

    public RepositorioSistema() {

    }

    @Override
    public void inserir(Sistema s) {
        manager = HibernateUtil.getManager();

        RepositorioSistema.manager.getTransaction().begin();

        try {
            RepositorioSistema.manager.persist(s);
            RepositorioSistema.manager.getTransaction().commit();
        } catch (Exception e) {
            RepositorioSistema.manager.getTransaction().rollback();
            System.out.println("Não foi possível registrar o sistema, aconteceu algo inexperado!!");
            System.out.println(e.getMessage());

        } finally {
            RepositorioSistema.manager.close();
            System.out.println("Fim da sessão!!");

        }
    }

    @Override
    public void alterar(Sistema s) {
        manager = HibernateUtil.getManager();

        RepositorioSistema.manager.getTransaction().begin();
        try {

            RepositorioSistema.manager.merge(s);
            RepositorioSistema.manager.getTransaction().commit();
            System.out.println("alterado com sucesso!!!");
        } catch (Exception e) {
            RepositorioSistema.manager.getTransaction().rollback();
            System.out.println("Não foi possível Alterar!!!");
            System.out.println(e.getMessage());
        } finally {
            RepositorioSistema.manager.close();
            System.out.println("Fim da sessão!!!");
        }
    }

    @Override
    public Sistema recuperar(Long id) {
        manager = HibernateUtil.getManager();

        return RepositorioSistema.manager.find(Sistema.class, id);

    }

    @Override
    public void excluir(Sistema s) {
        manager = HibernateUtil.getManager();
        RepositorioSistema.manager.getTransaction().begin();
        try {
            s =  manager.find(Sistema.class, s.getId());
            RepositorioSistema.manager.remove(s);
            RepositorioSistema.manager.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login deletado com sucesso!!!"));
        } catch (Exception e) {
           System.out.print("Não foi possível excluir!");
            System.out.println(e.getMessage());
        }finally{
             RepositorioSistema.manager.close();
            System.out.println("Fim da sessão!!!");
        }
    }

    @Override
    public List<Sistema> recuperarTodos() {
        manager = HibernateUtil.getManager();
        try {
            return RepositorioSistema.manager.createQuery("from Sistema s").getResultList();
        } catch (Exception e) {
            System.out.println("Não foi possível listar!!!");
            System.out.println("Erro" + e.getMessage());
        } finally {
            RepositorioSistema.manager.close();
            System.out.println("Fim da sessão!!!");

        }

        return null;
    }

}
