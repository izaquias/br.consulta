/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import model.Pessoa;
import model.Dao.DaoPessoa;

/**
 *
 * @author Izaquias
 */
@ManagedBean(name="PessoaBean")
@ViewScoped
public class ControladorPessoaBean implements Controlador{
    private DaoPessoa repositorio = null;
    private Pessoa pessoas;
    
    @PostConstruct
   public void Inicializar()
   {
       repositorio = new DaoPessoa();
       pessoas = new Pessoa();
   }
    
    public ControladorPessoaBean(){
        
    }

    public DaoPessoa getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(DaoPessoa repositorio) {
        this.repositorio = repositorio;
    }

    public Pessoa getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa pessoas) {
        this.pessoas = pessoas;
    }
    

    @Override
    public String inserir() {
        repositorio.inserir(pessoas);
        return "";
    }

    @Override
    public String alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa recuperar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
