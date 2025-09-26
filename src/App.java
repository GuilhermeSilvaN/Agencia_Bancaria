
import java.text.ParseException;
import java.text.SimpleDateFormat;


import entities.ContaCorrente;
import entities.Pessoa;
import model.EstadoCivil;
import service.Conta;


public class App {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat stm = new SimpleDateFormat("dd/MM/yyyy");

        Pessoa p1 = new Pessoa("Guilherme Silva", "12345678910",stm.parse("12/02/2004"), EstadoCivil.SOLTEIRO);

        Conta conta1 = new ContaCorrente("11223344", 2500.00, p1, 200.00);

        System.out.println(conta1);


    }
}
