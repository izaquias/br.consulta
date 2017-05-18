/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Izaquias
 */
@Entity
@Table(name = "Consulta")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "data", nullable = false, length = 12)
    private String data;
     @Column(name = "hora", nullable = false, length = 12)
    private String hora; 
   
    //@Lob
   
    @ManyToOne(cascade = CascadeType.MERGE)
    private Paciente paciente;//Ou: private String [] paciente; OU private Collection < Paciente > paciente ;
  
    @ManyToOne(cascade = CascadeType.MERGE)
    private Medico medico;

    public Consulta() {

    }

    public Consulta(long id, Paciente paciente, String data, String hora) {
        this.id = id;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
     public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
}
