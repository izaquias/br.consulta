
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Izaquias
 */
@Entity
@Table(name = "Medico")
public class Medico implements Serializable {
    @Id
    @Column(nullable = false, length = 15)
    private long crm;
    @Column(name = "nome" , nullable = false, length = 35)
    private String nome;
    @Column(name = "idade" , nullable = false, length = 4)
    private int idade;
    @Column(name = "especialidade" , nullable = false, length = 35)
    private String especialidade;
    @Column(name = "salario" , nullable = false, length = 10)
    private double salario;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sistema_id")
    private Sistema sistema;
    
    public Medico(){
        
    }

    public Medico(long crm, String nome, int idade, String especialidade, double salario, Sistema sistema) {
        this.crm = crm;
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.salario = salario;
        this.sistema = sistema;
    }
    
    public long getCrm(){
        return crm;
    } 
    public void setCrm(long crm){
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    
}
