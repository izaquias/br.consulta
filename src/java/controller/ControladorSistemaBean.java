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
import model.Sistema;
import model.repository.RepositorioSistema;

/**
 *
 * @author Izaquias
 */
@SessionScoped
@ManagedBean(name="SistemaBean")
public class ControladorSistemaBean implements Controlador{

     private RepositorioSistema repositorio = null;
    private Sistema sistemas;
    
    @PostConstruct
   public void Inicializar()
   {
       sistemas = new Sistema();
        repositorio = new RepositorioSistema();
   }

    public ControladorSistemaBean() {
        
    }

    public RepositorioSistema getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioSistema repositorio) {
        this.repositorio = repositorio;
    }

    public Sistema getSistemas() {
        return sistemas;
    }

    public void setSistemas(Sistema sistemas) {
        this.sistemas = sistemas;
    }
    
    
    @Override
    public String inserir() {
        repositorio.inserir(sistemas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login cadastrado com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(sistemas);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login alterado com sucesso!!!"));
        return "index.xhtml";
        
    }

    @Override
    public String deletar() {
        repositorio.excluir(sistemas);
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login deletado com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public Sistema recuperar(Long id) {
        return repositorio.recuperar(id);
    }

    @Override
    public List<Sistema> recuperarTodos() {
       return repositorio.recuperarTodos();
    }
    
}
