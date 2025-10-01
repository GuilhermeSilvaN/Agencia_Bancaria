package service;

import entities.Cliente;
import model.TipoConta;

public abstract class Conta {
    private String numeroConta;
    private Double saldo;
    private Cliente cliente;
    private TipoConta tipoConta;

    public Conta (String numeroConta, Double saldo, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void depositar(double valor){
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

    public Cliente getCliente() {
        return cliente;
    }

    public TipoConta getTipoConta(){
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta){
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", pessoa= (" + cliente +
                ")}";
    }
}
