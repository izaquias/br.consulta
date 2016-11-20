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
import model.Sistema;
import model.repository.RepositorioPaciente;
import model.repository.RepositorioSistema;

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "PacienteBean")
@SessionScoped
public class ControladorPacienteBean implements Controlador {

    private RepositorioSistema repositorioSistema = null;
    private RepositorioPaciente repositorio = null;
    private Paciente pacientes;
    private Sistema sistemas;

    @PostConstruct
    public void Inicializar() {
        pacientes = new Paciente();
        repositorio = new RepositorioPaciente();
        repositorioSistema = new RepositorioSistema();
        sistemas = new Sistema();
    }

    public ControladorPacienteBean() {

    }

    public RepositorioSistema getRepositorioSistema() {
        return repositorioSistema;
    }

    public void setRepositorioSistema(RepositorioSistema repositorioSistema) {
        this.repositorioSistema = repositorioSistema;
    }

    public Sistema getSistemas() {
        return sistemas;
    }

    public void setSistemas(Sistema sistemas) {
        this.sistemas = sistemas;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public RepositorioPaciente getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioPaciente repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String inserir() {
        sistemas = repositorioSistema.recuperar(sistemas.getId());
        pacientes.setSistema(sistemas);
        repositorio.inserir(pacientes);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O paciente " + pacientes.getNome() + " foi cadastrado com sucesso!"));

        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(pacientes);
        
        return "index.xhtml";
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage ("O paciente" + pacientes.getNome() +" foi deletado com sucesso!"));
        return "index.xhtml";
    }

}
