/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Hibernete.HibernateUtil;
import model.Medico;

/**
 *
 * @author Izaquias
 */
public class DaoMedico implements DaoGenerico<Medico> {

    private static EntityManager manager;

    public DaoMedico() {

    }

    @Override
    public void inserir(Medico m) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoMedico.manager.getTransaction().begin();

        try {
            DaoMedico.manager.persist(m);
            DaoMedico.manager.getTransaction().commit();
            System.out.println("Médico cadastrado com sucesso!");

        } catch (Exception e) {
            DaoMedico.manager.getTransaction().rollback();
           
            System.out.println("Não foi possível cadastrar o médico, algo inexperado acorreu!");
             System.out.println(e.getMessage());
        } finally {
            DaoMedico.manager.close();
            System.out.print("Fim da sessão!");
        }

    }

    @Override
    public void alterar(Medico m) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoMedico.manager.getTransaction().begin();

        try {
            DaoMedico.manager.merge(m);
            DaoMedico.manager.getTransaction().commit();
            System.out.println("Médico alterado com sucesso!!");
        } catch (Exception e) {
            DaoMedico.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            DaoMedico.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public Medico recuperar(Long crm) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try{
        return DaoMedico.manager.find(Medico.class, crm);
        } catch (Exception e) {
            System.out.println("Algo inexperado aconteceu!!");
            System.out.println(e.getMessage());
        } finally {
            DaoMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }

    @Override
    public void excluir(Medico m) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoMedico.manager.getTransaction().begin();
        try {
            m = manager.find(Medico.class, m.getCrm());
            DaoMedico.manager.remove(m);
            DaoMedico.manager.getTransaction().commit();
            System.out.println("Médico removido com sucesso!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            DaoMedico.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover o médico, reveja a operação!!!");
        } finally {
            DaoMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }

    }

    @Override
    public List<Medico> recuperarTodos() {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {

            return (List) DaoMedico.manager.createQuery("select m from Medico m", Medico.class).getResultList();
        } catch (Exception e) {
            System.out.println("Algo inexperado aconteceu!!");
            System.out.println(e.getMessage());
        } finally {
            DaoMedico.manager.close();
            System.out.println("Fim da sessão!!!");
        }

        return null;
    }
    
    public Medico recuperarMedicoEmailSenha(String email, String senha) {
        
        String hql = "FROM Medico m WHERE e_mail=:emailMedico and senha=:senhaMedico";
        
        Medico m = null;
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            Query query = manager.createQuery(hql);
            m = (Medico) query.setParameter("emailMedico", email).setParameter("senhaMedico", senha).getSingleResult();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return m;
    }

}
