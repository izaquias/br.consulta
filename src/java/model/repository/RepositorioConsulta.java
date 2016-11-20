/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.util.List;
import javax.persistence.EntityManager;
import model.Consulta;
import model.Hibernete.HibernateUtil;


/**
 *
 * @author Izaquias
 */
public class RepositorioConsulta implements DaoGenerico<Consulta>{
    
    private static EntityManager manager;

    public RepositorioConsulta() {
        
    }
    
    @Override
    public void inserir(Consulta c) {
        manager = HibernateUtil.getManager();
        
        RepositorioConsulta.manager.getTransaction().begin();
        
        try {
            RepositorioConsulta.manager.persist(c);
            RepositorioConsulta.manager.getTransaction().commit();
            System.out.println("Consulta gerada com sucesso!!");
            
        } catch (Exception e) {
            RepositorioConsulta.manager.getTransaction().rollback();
            System.out.println("Aconteceu algo inesxperado, não foi possível salvar a consulta!!");
            System.out.println(e.getMessage());
            
        }finally{
            RepositorioConsulta.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public void alterar(Consulta c) {
        manager = HibernateUtil.getManager();
       RepositorioConsulta.manager.getTransaction().begin();
       
        try {
           RepositorioConsulta.manager.merge(c);
           RepositorioConsulta.manager.getTransaction().commit();
            System.out.println("Consulta alterada com sucesso!!!");
        } catch (Exception e) {
            RepositorioConsulta.manager.getTransaction().rollback();
            System.out.println("Não foi  possível realizar essa operação!!!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Consulta recuperar(Long id) {
        
       manager = HibernateUtil.getManager();
        
        try {
            RepositorioConsulta.manager.find(Consulta.class, id);
        } catch (Exception e) {
            System.out.println("Não foi´possível retornar a requerida consulta!!!");
            System.out.println(e.getMessage());
        }finally{
            RepositorioConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        
        
        return  null;
    }

    @Override
    public void excluir(Consulta c) {
        manager = HibernateUtil.getManager();
        
        
        try {
            RepositorioConsulta.manager.remove(c);
            RepositorioConsulta.manager.getTransaction().commit();
            System.out.println("Consulta removida com sucesso!!!");
        } catch (Exception e) {
            RepositorioConsulta.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover a referida consulta, reveja a operação!!!");
            
        }finally{
            RepositorioConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }
            
    }

    @Override
    public List<Consulta> recuperarTodos() {
       manager = HibernateUtil.getManager();
        try {
         return (List)  RepositorioConsulta.manager.createQuery("from Consulta c").getResultList();
            
        } catch (Exception e) {
            System.out.println("Não foi possível realizar essa transação!!!");
            System.out.println(e.getMessage());
        }finally{
            RepositorioConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }
    
}
