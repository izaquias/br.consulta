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
    @Column(name = "sintoma", nullable = false, length = 30)
    private String sintoma;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sistema_id")
    private Sistema sistema;

    public Paciente() {
    }

    public Paciente(long SUS, String nome, int idade, String endereco, String sintoma) {
        this.SUS = SUS;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.sintoma = sintoma;
        
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

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

}
