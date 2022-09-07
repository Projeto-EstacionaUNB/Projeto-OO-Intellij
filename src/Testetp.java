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
        long Horas = duracao.toHours();
        long Minutos= duracao.toMinutes();
        Minutos = Minutos%60 ;
        System.out.println("horas:" + Horas + "  minutos:"+ Minutos + " " +duracao);
        //2022-09-05T10:45
        //2022-09-06T11:50

        System.out.println("Digite a fração de tempo do estacionamento \n Escreva em minutos");
        String fracao = esc.next();
        double Fracao = Double.parseDouble(fracao);
        double numerofração = Math.ceil(Minutos/Fracao);
        System.out.println(numerofração);

        System.out.println("Digite o valor da fração do estacionamento ");
        String valorFracao = esc.next();
        double ValorFracao = Double.parseDouble(valorFracao);

        System.out.println("Digite o valor do desconto \n Escreva em decial \n Exemplo : 20 porcento de desconto é 0.20");
        String desconto = esc.next();
        double Desconto = Double.parseDouble(desconto);
        Desconto = 1.00 - Desconto;
        double numeroFracoes = Horas * (60/Fracao);
        System.out.println("Numero de frações dentro das horas : " + numeroFracoes);
        double valorHora = numeroFracoes * ValorFracao;

        System.out.println("valor das horas sem desconto : " + valorHora);
        double valorHoras = valorHora * Desconto;

        System.out.println("valor das horas com desconto: " + valorHoras);

        double valorMinutos = numerofração * ValorFracao;
        System.out.println("valor dos minutos: " + valorMinutos);

        double custo = valorHoras + valorMinutos;
        System.out.println("O custo foi de : " + custo);

        //2022-09-05T12:07
        //2022-09-05T14:40
        }
}
