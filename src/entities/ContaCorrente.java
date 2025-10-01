package entities;


import model.TipoConta;
import service.Conta;

public class ContaCorrente extends Conta {
    private Integer id;
    private TipoConta tipoConta;

    public ContaCorrente(Integer id, TipoConta tipoConta, String numeroConta, Double saldo, Cliente pessoa) {
        super(numeroConta, saldo, pessoa);
        this.id = id;
        this.tipoConta = tipoConta;

    }

    @Override
    public void depositar(double valor){
        if(valor > 0.0){
            setSaldo(getSaldo() + valor);
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0.0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        }
    }

    public TipoConta geTipoConta(){
        return tipoConta;
    }
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============== CONTA CORRENTE"+ " ===============\n");
        sb.append("{numero da conta : " + getNumeroConta() + "}\n");
        sb.append("{tipo de conta: " + this.tipoConta + " }\n");
        sb.append("{saldo : " + getSaldo() + "}\n");
        sb.append("{cliente : " + getCliente() + "}\n");

        return sb.toString();
    }

}
