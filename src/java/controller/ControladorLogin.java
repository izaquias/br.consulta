/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Medico;
import model.Paciente;
import model.Dao.DaoMedico;
import model.Dao.DaoPaciente;

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "LoginBean")
@SessionScoped

public class ControladorLogin {

    private String email;
    private String senha;
    private Paciente paciente;
    private Medico medico;
    private DaoMedico daoMedico;
    private DaoPaciente daoPaciente;

    public ControladorLogin() {
    }

    @PostConstruct
    public void Inicializar() {
        paciente = new Paciente();
        medico = new Medico();
        daoMedico = new DaoMedico();
        daoPaciente = new DaoPaciente();
    }

    public String fazerLogin() {
        Paciente p = daoPaciente.recuperarPacienteEmailSenha(email, senha);

        String redireciona = "";

        if (p != null) {
            this.setPacienteLogado(p);
            redireciona = "menuPaciente.xhtml";//no caso será a url do menu das determinadas funcionalidades!
        } else {

            Medico m = daoMedico.recuperarMedicoEmailSenha(email, senha);

            if (m != null) {
                this.setMedicoLogado(m);
                redireciona = "menuMedico.xhtml";//menu aqui também!
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "Email ou senha invalidos"));
            }
        }

        return redireciona;
    }

    public String fazerLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "fazerLogin.xhtml";

    }

    private void setPacienteLogado(Paciente p) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PacienteLogado", p);
    }

    private void setMedicoLogado(Medico m) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MedicoLogado", m);

    }

    public boolean VerificaLogadoPaciente() {
        
        Paciente p  = (Paciente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PacienteLogado");
        return p != null;
    }
    public boolean VerificaLogadoMedico() {
        
        Medico m  = (Medico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MedicoLogado");
        return m != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public DaoMedico getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(DaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    public DaoPaciente getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

}
