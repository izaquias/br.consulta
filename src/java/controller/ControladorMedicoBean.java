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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Medico;
import model.Sistema;
import model.repository.RepositorioMedico;
import model.repository.RepositorioSistema;

/**
 *
 * @author Izaquias
 */

@SessionScoped
@ManagedBean(name="MedicoBean")
public class ControladorMedicoBean implements Controlador {
    private RepositorioSistema repositorioSistema = null;
    private RepositorioMedico repositorio = null;
    private Medico medicos;
    private Sistema sistemas;

    public ControladorMedicoBean() {

    }

    @PostConstruct
    public void Inicializar() {
        repositorioSistema = new RepositorioSistema();
        repositorio = new RepositorioMedico();
        medicos = new Medico();
        sistemas = new Sistema();

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
    
    public RepositorioMedico getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioMedico repositorio) {
        this.repositorio = repositorio;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    @Override
    public String inserir() {
        sistemas = repositorioSistema.recuperar(sistemas.getId());
        medicos.setSistema(sistemas);
        repositorio.inserir(medicos);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O médico " + medicos.getNome() + " foi cadastrado com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(medicos);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Médico "+ medicos.getNome() +" alterado com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public String deletar() {
        //medicos = recuperar(medicos.getCrm());
        repositorio.excluir(medicos);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage ("O médico " + medicos.getNome() +" foi deletado com sucesso!"));
        return "index.xhtml";
    }

    @Override
    public Medico recuperar(Long id) {
        return repositorio.recuperar(id);
    }

    @Override
    public List<Medico> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

}
