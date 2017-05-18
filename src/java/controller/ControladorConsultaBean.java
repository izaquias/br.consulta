/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Dao.DaoConsulta;
import model.Dao.DaoMedico;
import model.Dao.DaoPaciente;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "ConsultaBean")
@SessionScoped

public class ControladorConsultaBean implements Controlador {

    private DaoConsulta repositorio = null;
    private DaoMedico repositorioMedico = null;
    private DaoPaciente repositorioPaciente = null;
    private Consulta consultas;
    private Medico medicos;
    private Paciente pacientes;
    private List<Paciente> pacienteSelected;
    
    private boolean skip;
    
    public ControladorConsultaBean() {

    }

    @PostConstruct
    public void Inicializar() {
        repositorio = new DaoConsulta();
        repositorioMedico = new DaoMedico();
        repositorioPaciente = new DaoPaciente();

        consultas = new Consulta();
        medicos = new Medico();
        pacientes = new Paciente();
       
        //copiar todos os pacientes, para que sua referencia não seja nula, após fechar a trasação(usar for para resolver.)!

    }
     public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "consulta";
        }
        else {
            return event.getNewStep();
        }
    }
/*
    //método que clona uma lista para ser inserida!
    public List<Paciente> retornaSelecionados() {
        
        List<Paciente> pacientAux = new ArrayList<>();

        for (Paciente p : pacientesList) {

            Paciente pAux = new Paciente();
            pAux.setEndereco(p.getEndereco());
            pAux.setIdade(p.getIdade());
            pAux.setSUS(p.getSUS());
            pAux.setSintoma(p.getSintoma());
            pAux.setNome(p.getNome());
            

            pacientAux.add(pAux);
        }
        return pacientAux;
    }*/
    
    public void changePacientes(SelectEvent selectEvent)
{
        Consulta consulta = (Consulta) selectEvent.getObject();
        consultas = consulta;
        long id;
        id = consulta.getId();
        consultas = recuperar(consultas.getId());
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

    public DaoPaciente getRepositorioPaciente() {
        return repositorioPaciente;
    }

    public void setRepositorioPaciente(DaoPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public DaoMedico getRepositorioMedico() {
        return repositorioMedico;
    }

    public void setRepositorioMedico(DaoMedico repositorioMedico) {
        this.repositorioMedico = repositorioMedico;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    public DaoConsulta getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(DaoConsulta repositorio) {
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
        consultas.setPaciente(pacientes);
        consultas.setMedico(medicos);

        repositorio.inserir(consultas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta registrada com sucesso!!!"));
        this.consultas = new Consulta();
                
        return "menuPaciente.xhtml";
    }

    @Override
    public String alterar() {
        repositorio.alterar(consultas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta altereda com sucesso!!!"));
        this.consultas = new Consulta();
        return "menuPaciente.xhtml";
    }

    @Override
    public String deletar() {
        repositorio.excluir(consultas);
        return "menuPaciente.xhtml";
    }

    @Override
    public Consulta recuperar(Long id) {
        return repositorio.recuperar(id);
    }

    @Override
    public List<Consulta> recuperarTodos() {
        return repositorio.recuperarTodos();
    }
    
    public List<Consulta> consultasMedico(long id, Long medico_crm){
         
        return repositorio.recuperarConsultasMedico(id, medico_crm);
    }
    
    public Consulta consultasPaciente(long id, Long paciente_SUS){
        return repositorio.recuperarConsultasPaciente(id, paciente_SUS);
    }
   

}
