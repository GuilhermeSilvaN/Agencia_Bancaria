package service;

import entities.Pessoa;

public abstract class Conta {
    private String numeroConta;
    private Double saldo;
    private Pessoa pessoa;

    public Conta (String numeroConta, Double saldo, Pessoa pessoa) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    public void Depositar(double valor){
        if(valor > 0.0){
            this.saldo += valor;
        }
    }

    public void sacar(double valor){
        if(saldo >= valor){
            this.saldo -= valor;
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", pessoa= (" + pessoa +
                ")}";
    }
}
