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
@Table(name = "Paciente")
public class Paciente implements Serializable {

    @Id
    @Column(unique = true, length = 15)
    private long SUS;
    @Column(name = "nome", nullable = false, length = 35)
    private String nome;
    @Column(name = "idade", nullable = false, length = 35)
    private int idade;
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;
    @Column(name="e_mail", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "senha", nullable = false, length = 15)
    private String senha;
    @Column(name = "sintoma", nullable = false, length = 30)
    private String sintoma;
  
    
    

    public Paciente() {
    }

    public Paciente(long SUS, String nome, int idade, String endereco, String sintoma, String email, String senha) {
        this.SUS = SUS;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.sintoma = sintoma;
        this.email = email;
        this.senha = senha;
        
    }

    public long getSUS() {
        return SUS;
    }

    public void setSUS(long SUS) {
        this.SUS = SUS;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
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
