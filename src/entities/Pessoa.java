package entities;

import model.EstadoCivil;

import java.util.Date;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String CPF;
    private Date dataNascimento;
    private EstadoCivil stateCivil;

    public Pessoa(String nome, String CPF, Date dataNascimento, EstadoCivil stateCivil) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.stateCivil = stateCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EstadoCivil getStateCivil() {
        return stateCivil;
    }

    public void setStateCivil(EstadoCivil stateCivil) {
        this.stateCivil = stateCivil;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", stateCivil=" + stateCivil +
                '}';
    }
}
