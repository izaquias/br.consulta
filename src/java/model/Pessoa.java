/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Izaquias
 */
@Entity
//@Table(name="Pessoa")
public class Pessoa implements Serializable {

    @Id
    private long cpf;
    private String nome;

    public Pessoa() {

    }

    public Pessoa(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;

    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
