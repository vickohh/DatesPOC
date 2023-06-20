import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ValidarFechas {

    public static void main(String[] args) {

        String fecha1 = "2021-05-30T08:24:41.000Z";
        String fecha2 = "20/09/2021";

        boolean formato1;

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.000z");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            // Validar fecha1 en formato yyyy-MM-dd
            LocalDate localDate1 = LocalDate.parse(fecha1, formatter1);
            System.out.println("Fecha 1 válida: " + localDate1);
            formato1 = true;

        } catch (DateTimeParseException e) {
            System.out.println("Fecha 1 inválida");
            formato1 = false;
        }

        try {
            // Validar fecha2 en formato dd/MM/yyyy
            LocalDate localDate2 = LocalDate.parse(fecha2, formatter2);
            System.out.println("Fecha 2 válida: " + localDate2);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha 2 inválida");
        }

        System.out.println(formato1);
    }
}