package entities;

import model.EstadoCivil;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private EstadoCivil stateCivil;

    public Cliente(){}

    public Cliente(int id, String nome, String CPF, LocalDate dataNascimento, EstadoCivil stateCivil) {
        this.id = id;
        this.nome = nome;
        setCPF(CPF);
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
        if (isCPFValid(CPF)){
            this.CPF = CPF;
        } else{
            System.out.println("CPF INVALIDO");
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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
        Cliente pessoa = (Cliente) o;
        return Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }

    //valida cpf;
    public static boolean isCPFValid(String cpf){
        //remover caracteres nao numericos;
        cpf = cpf.replaceAll("\\D", "");

        //verificar se tem 11 digitos;
        if(cpf.length() != 11) return false;

        //verificar se todos os digitos sao iguais (nao e valido);
        if(cpf.matches("(\\d)\\1{10}")) return false;

        try{
            //calculo do primeiro digito verificador;
            int soma = 0;
            for(int i = 0; i < 9; i++){
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }   

            int digito1 = 11 - (soma % 11);
            digito1 = (digito1 > 9) ? 0 : digito1;

            //calculo do segundo verificador;
            soma = 0;
            for (int i = 0; i < 10; i++){
                soma += (cpf.charAt(i) - '0') * (11 - i); 
            }

            int digito2 = 11 - (soma % 11);
            digito2 = (digito2 > 9) ? 0 : digito2;

            //verifica se os digitos calculados sao iguais ao informado;

            return digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0');

        } catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", stateCivil=" + stateCivil +
                '}';
    }
}
