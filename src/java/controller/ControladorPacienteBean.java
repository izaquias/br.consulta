/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import model.Paciente;
import model.Dao.DaoPaciente;


/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "PacienteBean")
@SessionScoped
public class ControladorPacienteBean implements Controlador {

    
    private DaoPaciente repositorio = null;
    private Paciente pacientes;
    

    @PostConstruct
    public void Inicializar() {
        pacientes = new Paciente();
        repositorio = new DaoPaciente();
        
    }

    public ControladorPacienteBean() {

    }

   
    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public DaoPaciente getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(DaoPaciente repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String inserir() {
      
        repositorio.inserir(pacientes);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente " + pacientes.getNome() + " foi cadastrado(a) com sucesso!"));
        this.pacientes = new Paciente();
        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(pacientes);
        this.pacientes = new Paciente();
        return "menuPaciente.xhtml";
    }

    @Override
    public Paciente recuperar(Long id) {
        return repositorio.recuperar(id);
    }

    @Override
    public List<Paciente> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

    @Override
    public String deletar() {
        repositorio.excluir(pacientes);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage ("O(A) paciente" + pacientes.getNome() +" seu registro foi deletado com sucesso!"));
        return "menuPaciente.xhtml";
    }

}
