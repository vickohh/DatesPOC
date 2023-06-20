import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class Main {

    private String data1 = "06/16/2028";
    private String data2 = "06/16/2028";



    public  static void main(String[] args) {
        String fecha1 = "6/25/2023";
        String fecha2 = "8/16/2023";

        String FechaFinal_1 = getUTCFormat(fecha1);
//        String FechaFinal_2 = getUTCFormat(fecha2);
//
//        System.out.println("Fecha inicial:  "+ fecha1);
//        System.out.println("Fecha Final:  "+ FechaFinal_1);

//        compararFechas(FechaFinal_1,FechaFinal_2);
//
//        System.out.println("Fecha inicial:  "+ fecha2);
//        System.out.println("Fecha Final:  "+ FechaFinal_2);
//
//        if (FechaFinal_1.equals(FechaFinal_2)) {
//            System.out.println("getUTCFormat - Las fechas son iguales.");
//        } else {
//            System.out.println("getUTCFormat -Las fechas son diferentes.");
//        }
//
//        getUTCFormatDate(fecha1, fecha2);
//        comparacion(false);



        LocalDateTime  localDateTime = LocalDateTime.now();

        System.out.println("local day time: " + localDateTime);


        compararFechas(FechaFinal_1, localDateTime);




    }
    public static void compararFechas(String fecha_1,LocalDateTime localDateTime ){

        String fecha1 = fecha_1;
        // Crear un formateador de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Formatear la fecha y hora actual
        String fechaFormateadaLocal = localDateTime.format(formatter);
        System.out.println("Fecha formateada local: " + fechaFormateadaLocal);

        compararFechas( fecha_1,fechaFormateadaLocal );
    }



    public static void compararFechas(String fecha1,String fecha2 ){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDate localDate1 = LocalDate.parse(fecha1, formatter);
        LocalDate localDate2 = LocalDate.parse(fecha2, formatter);

        long diasDiferencia = ChronoUnit.DAYS.between(localDate1, localDate2);

        System.out.println("fecha 1: " + localDate1 + "  fecha 2:  " + localDate2);

        System.out.println("Días de diferencia: " + diasDiferencia);
    }



    public static String getUTCFormat(String fechaToConvert){
        String fechaString = fechaToConvert;
        String fechaUTCString = StringUtils.EMPTY;

        String formatoFecha = "MM/dd/yyyy";

        SimpleDateFormat formatter = new SimpleDateFormat(formatoFecha);
        //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            Date fecha = formatter.parse(fechaString);

            SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            fechaUTCString = sdfUTC.format(fecha);

            System.out.println("fecha transformada: "+ fechaUTCString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaUTCString;
    }

    public static void getUTCFormatDate(String fechaToConvert1,String fechaToConvert2 ){

        String fechaString1 = fechaToConvert1;
        String fechaString2 = fechaToConvert2;
        String fechaUTCString = StringUtils.EMPTY;

        String formatoFecha = "MM/dd/yyyy";

        SimpleDateFormat formatter = new SimpleDateFormat(formatoFecha);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            Date fecha1 = formatter.parse(fechaString1);
            Date fecha2 = formatter.parse(fechaString2);

            SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            sdfUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

            String fechaFinal1 = sdfUTC.format(fecha1);
            String fechaFinal2 = sdfUTC.format(fecha2);

            Date fecha1F = sdfUTC.parse(fechaFinal1);
            Date fecha2F = sdfUTC.parse(fechaFinal2);

            if (fecha1F.equals(fecha2F)) {
                System.out.println("getUTCFormatDate - Las fechas son iguales.");
            } else {
                System.out.println("getUTCFormatDate - Las fechas son diferentes.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String comparacion(boolean valor) {

        String respuesta = StringUtils.EMPTY;

        if (valor) {
             respuesta ="valor";
        } else {
            respuesta = null;
        }

        System.out.println(respuesta);
        return respuesta;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}