package entities;


import service.Conta;

public class ContaCorrente extends Conta {
    private Double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, Double saldo, Pessoa pessoa, Double limiteChequeEspecial) {
        super(numeroConta, saldo, pessoa);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0.0 && (getSaldo() + limiteChequeEspecial) >= valor) {
            setSaldo(getSaldo() - valor);
        }
    }

    public Double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
    public void setLimiteChequeEspecial(Double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============== CONTA CORRENTE"+ " ===============\n");
        sb.append("{numero da conta : " + getNumeroConta() + "}\n");
        sb.append("{saldo : " + getSaldo() + "}\n");
        sb.append("{cliente : " + getPessoa() + "}\n");
        sb.append("{limite de cheque especial : " + String.format("%.2f", getLimiteChequeEspecial()) + "}\n");

        return sb.toString();
    }

}
