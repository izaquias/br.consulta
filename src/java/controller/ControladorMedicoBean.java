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
import model.Dao.DaoMedico;


/**
 *
 * @author Izaquias
 */

@SessionScoped
@ManagedBean(name="MedicoBean")
public class ControladorMedicoBean implements Controlador {
   
    private DaoMedico repositorio = null;
    private Medico medicos;
    

    public ControladorMedicoBean() {

    }

    @PostConstruct
    public void Inicializar() {
        
        repositorio = new DaoMedico();
        medicos = new Medico();
     

    }

    
    public DaoMedico getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(DaoMedico repositorio) {
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
       // sistemas = repositorioSistema.recuperar(sistemas.getId());
       // medicos.setSistema(sistemas);
        repositorio.inserir(medicos);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Médico(a) " + medicos.getNome() + " foi cadastrado(a) com sucesso!!!"));
        this.medicos = new Medico();
        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(medicos);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Médico(a) "+ medicos.getNome() +" dados alterados com sucesso!!!"));
         this.medicos = new Medico();
        return "menuMedico.xhtml";
    }

    @Override
    public String deletar() {
        //medicos = recuperar(medicos.getCrm());
        repositorio.excluir(medicos);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (" Médico " + medicos.getNome() +" foi deletado com sucesso!"));
        return "menuMedico.xhtml";
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
