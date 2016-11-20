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
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.repository.RepositorioConsulta;
import model.repository.RepositorioMedico;
import model.repository.RepositorioPaciente;

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "ConsultaBean")
@SessionScoped

public class ControladorConsultaBean implements Controlador {

    private RepositorioConsulta repositorio = null;
    private RepositorioMedico repositorioMedico = null;
    private RepositorioPaciente repositorioPaciente = null;
    private Consulta consultas;
    private Medico medicos;
    private Paciente pacientes;
    private List<Paciente> pacientesList;
    private List<Paciente> pacienteSelected;

    public ControladorConsultaBean() {

    }
   

    @PostConstruct
    public void Inicializar() {
        repositorio = new RepositorioConsulta();
        repositorioMedico = new RepositorioMedico();
        repositorioPaciente = new RepositorioPaciente();

        consultas = new Consulta();
        medicos = new Medico();
        pacientes = new Paciente();
        pacienteSelected = repositorioPaciente.recuperarTodos();
        //copiar todos os pacientes, para que sua referencia não seja nula, após fechar a trasação(usar for para resolver.)!
        
    }
    
    public void retornaSelecionados(){
        
       /* for(Paciente ){
            
        }*/
    }

    public List<Paciente> getPacienteSelected() {
        return pacienteSelected;
    }

    public void setPacienteSelected(List<Paciente> pacienteSelected) {
        this.pacienteSelected = pacienteSelected;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public List<Paciente> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Paciente> pacientesList) {
        this.pacientesList = pacientesList;
    }

    public RepositorioPaciente getRepositorioPaciente() {
        return repositorioPaciente;
    }

    public void setRepositorioPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public RepositorioMedico getRepositorioMedico() {
        return repositorioMedico;
    }

    public void setRepositorioMedico(RepositorioMedico repositorioMedico) {
        this.repositorioMedico = repositorioMedico;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    public RepositorioConsulta getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public Consulta getConsultas() {
        return consultas;
    }

    public void setConsultas(Consulta consultas) {
        this.consultas = consultas;
    }

    @Override
    public String inserir() {
        pacientes = repositorioPaciente.recuperar(pacientes.getSUS());
        medicos = repositorioMedico.recuperar(medicos.getCrm());
        consultas.setPaciente(pacientesList);
        consultas.setMedico(medicos);
       
        repositorio.inserir(consultas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta registrada com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(consultas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta altereda com sucesso!!!"));
        return "index.xhtml";
    }

    @Override
    public String deletar() {
        repositorio.excluir(consultas);
        return "";
    }

    @Override
    public Consulta recuperar(Long id) {
        return repositorio.recuperar(id);
    }

    @Override
    public List<Consulta> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

}
