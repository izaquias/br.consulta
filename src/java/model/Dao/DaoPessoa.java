/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Hibernete.HibernateUtil;
import model.Pessoa;

/**
 *
 * @author Izaquias
 */
public class DaoPessoa implements DaoGenerico<Pessoa> {

    private static EntityManager manager;

    public DaoPessoa() {

    }

    @Override
    public void inserir(Pessoa p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        DaoPessoa.manager.getTransaction().begin();
        try {
           // p.setCpf(null);
            DaoPessoa.manager.persist(p);
            DaoPessoa.manager.getTransaction().commit();
        } catch (Exception e) {
            DaoPessoa.manager.getTransaction().rollback();
            System.out.println("Não foi possível cadastrar a pessoa, aconteceu algo inexperado!!");
            System.out.println(e.getMessage());

        } finally {

            DaoPessoa.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public void alterar(Pessoa t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa recuperar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Pessoa t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
