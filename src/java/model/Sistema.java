package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Izaquias
 */
@Entity
@Table(name = "Sistema")
public class Sistema implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "login", nullable = false, length = 35)
    private String login;
    @Column(name = "senha", nullable = false, length = 35)
    private String senha;
    @OneToMany(mappedBy="sistema")
    private List<Paciente> paciente;
    @OneToMany(mappedBy="sistema")
    private List<Medico> medico;
    public Sistema() {
    }

    public Sistema(long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public List<Medico> getMedico() {
        return medico;
    }

    public void setMedico(List<Medico> medico) {
        this.medico = medico;
    }
    
    
    public void cadastrarPaciente(){
        
    }
    
    public void cadastrarMedico(){
        
    }
    
    public void  agendarConsultaPaciente(){
        
    }

}
