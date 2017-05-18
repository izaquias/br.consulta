/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Consulta;
import model.Hibernete.HibernateUtil;

/**
 *
 * @author Izaquias
 */
public class DaoConsulta implements DaoGenerico<Consulta> {

    private static EntityManager manager;

    public DaoConsulta() {

    }

    @Override
    public void inserir(Consulta c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoConsulta.manager.getTransaction().begin();

        try {
            DaoConsulta.manager.persist(c);
            DaoConsulta.manager.getTransaction().commit();
            System.out.println("Consulta gerada com sucesso!!");

        } catch (Exception e) {
            DaoConsulta.manager.getTransaction().rollback();
            System.out.println("Aconteceu algo inesxperado, não foi possível salvar a consulta!!");
            System.out.println(e.getMessage());

        } finally {
            DaoConsulta.manager.close();
            System.out.println("Fim da sessão!!");
        }
    }

    @Override
    public void alterar(Consulta c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        DaoConsulta.manager.getTransaction().begin();

        try {
            DaoConsulta.manager.merge(c);
            DaoConsulta.manager.getTransaction().commit();
            System.out.println("Consulta alterada com sucesso!!!");
        } catch (Exception e) {
            DaoConsulta.manager.getTransaction().rollback();
            System.out.println("Não foi  possível realizar essa operação!!!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Consulta recuperar(Long id) {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            DaoConsulta.manager.find(Consulta.class, id);
        } catch (Exception e) {
            System.out.println("Não foi´possível retornar a requerida consulta!!!");
            System.out.println(e.getMessage());
        } finally {
            DaoConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }

        return null;
    }

    @Override
    public void excluir(Consulta c) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoConsulta.manager.getTransaction().begin();

        try {
            c = DaoConsulta.manager.find(Consulta.class, c.getId());
            DaoConsulta.manager.remove(c);
            DaoConsulta.manager.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta " + " removida com sucesso!!!"));
            System.out.println("Consulta removida com sucesso!!!");
        } catch (Exception e) {
            DaoConsulta.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover a referida consulta, reveja a operação!!!");
            System.out.println(e.getMessage());

        } finally {
            DaoConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }

    }

    @Override
    public List<Consulta> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            return (List) DaoConsulta.manager.createQuery("from Consulta c").getResultList();

        } catch (Exception e) {
            System.out.println("Não foi possível realizar essa transação!!!");
            System.out.println(e.getMessage());
        } finally {
            DaoConsulta.manager.close();
            System.out.println("Fim da sessão!!!");
        }
        return null;
    }

    public List <Consulta> recuperarConsultasMedico(long id, Long medico_crm) {

        String hql = "select id from Consulta c join Medico m where c.id=:idconsulta and m.medico_crm=:crmMedico";

        Consulta c = null;

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            Query query = manager.createQuery(hql);
            c = (Consulta) query.setParameter("idconsulta", id).setParameter("crmMedico", medico_crm).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return (List<Consulta>) c;
    }
    
    
    public Consulta recuperarConsultasPaciente(long id, Long paciente_SUS) {

        String hql = "select id from Consulta c join Paciente p where c.id=:idconsulta and p.paciente_SUS=:susPaciente";

        Consulta c = null;

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            Query query = manager.createQuery(hql);
            c = (Consulta) query.setParameter("idconsulta", id).setParameter("susPaciente", paciente_SUS).getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
