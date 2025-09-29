
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import entities.ContaCorrente;
import entities.Cliente;
import model.EstadoCivil;
import service.Conta;


public class App {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat stm = new SimpleDateFormat("dd/MM/yyyy");

        Cliente p1 = new Cliente("Guilherme Silva", "11111111111",LocalDate.of(2004, 2, 12), EstadoCivil.SOLTEIRO);

        Conta conta1 = new ContaCorrente("11223344", 2500.00, p1, 200.00);

        System.out.println(conta1);


    }
}
