import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkingDate {

    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        System.out.println("Data em milisegundos: " + calendar.getTime());

        System.out.println("------------");

        Date date = new Date();
        System.out.println("Data em milisegundos: " + date.getTime());
        System.out.println("Data em dia do mês: " + date.getDate());
        System.out.println("Data em dia da semana: " + date.getDay());
        System.out.println("Hora do dia: " + date.getHours());
        System.out.println("Minuto da hora: " + date.getMinutes());
        System.out.println("Segundos: " + date.getSeconds());
        System.out.println("Ano: " + (date.getYear()+1900));

        System.out.println("------------");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("A data atual de hoje é: " +simpleDateFormat.format(date));
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Formato para salvar no banco de dados: "+simpleDateFormat.format(date));
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("A data e hora de hoje são: "+simpleDateFormat.format(date));
        System.out.println("A data do objeto parse é: "+simpleDateFormat.parse("1987-12-21 09:00:00"));

    }
}
