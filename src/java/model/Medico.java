
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column(name="e_mail", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "senha", nullable = false, length = 15)
    private String senha;
    
    
    public Medico(){
        
    }

    public Medico(long crm, String nome, int idade, String especialidade, double salario, String email, String senha) {
        this.crm = crm;
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.salario = salario;
        this.email = email;
        this.senha = senha;
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

}
