import model.Tempo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Testetp {
    static Scanner esc = new Scanner(System.in);

    public static void main(String[]args) {
        System.out.println("Digite a hora de entrada do veículo \n Escreva Ano-mes-diaThora:minutos");
        String entrada = esc.next();

        System.out.println("Digite a hora de saída do veículo \n Escreva Ano-mes-diaThora:minutos");
        String saida = esc.next();

        LocalDateTime date1 = LocalDateTime.parse(entrada);
        LocalDateTime date2 = LocalDateTime.parse(saida);
        Duration duracao = Duration.between(date1, date2);
        long dif = duracao.toHours();
        long diff = duracao.toMinutes();
        diff = diff%60 ;
        System.out.println("horas:" + dif + "  minutos:"+ diff + " " +duracao);
        //2022-09-05T10:45
        //2022-09-06T11:50

        }
}
