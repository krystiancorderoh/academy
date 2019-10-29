import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
class TestDates_Format {
    public static void main(String args[]) { 
    	// Sistema actual La fecha y la hora se asignan a objDate 
    	Date objDate = new Date(); 
 
        System.out.println(objDate); 
        // El formato de fecha está especificado
        String strDateFormat = "EEEE d 'de' MMMM 'de' yyyy";   
        // La cadena de formato de fecha se pasa como un argumento 
        // al objeto de formato de fecha
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat, new Locale("ES", "MX")); 
        // El formato de fecha se aplica a la fecha actual
        System.out.println(objSDF.format(objDate)); 
    }
}
