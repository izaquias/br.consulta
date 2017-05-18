/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Hibernete.HibernateUtil;
import javax.persistence.EntityManager;
import model.Dao.DaoMedico;

/**
 *
 * @author Izaquias
 */
public class TestandoMedico {

    static EntityManager manager;

    public static void main(String[] args) {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        //Verifica a existência ou não do registro passado!
        DaoMedico rm= new DaoMedico();
        Medico m=rm.recuperarMedicoEmailSenha("dracula@hotmail.com", "dracula39");
        if(m!=null){
            System.out.print(m.getNome());
        }else{
            System.out.print("não existe");
        }
        
    }

}
