/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Hibernete.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TestandoPacienteConsulta {

    static EntityManager manager;

    public static void main(String[] args) {

        manager = HibernateUtil.getManager();

        Consulta c = new Consulta();

        Paciente p = new Paciente();
        p.setSUS(2132345465);
        p.setNome("Izaquiele");
        p.setIdade(18);
        p.setEndereco("Angelim");
        p.setSintoma("Paranóia e Esquecimento");
        
        
        //Pensar como salvar uma lista de pacientes, pois essa forma não tá inserindo no banco! 
        c.setPaciente ((List<Paciente>) p);

        c.setData("12/28/1995");
        c.setHora("20:20:30");
       

        manager.getTransaction().begin();
        manager.persist(p);
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();

    }

}
