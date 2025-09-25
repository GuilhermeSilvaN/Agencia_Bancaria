
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Pessoa;
import model.EstadoCivil;


public class App {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat stm = new SimpleDateFormat("dd/MM/yyyy");

        Pessoa p1 = new Pessoa("Guilherme Silva", "12345678910",stm.parse("12/02/2004"), EstadoCivil.SOLTEIRO);

        System.out.println(p1);
    }
}
