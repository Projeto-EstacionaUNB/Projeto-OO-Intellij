package view;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class Main {

    static Scanner esc = new Scanner(System.in);
    static List<Estacionamento> estacionamento;
    static List<Veiculo> listaDeCarros;

    public static void main(String[] args) {
        operacoes();
    }

    public static void operacoes() {
        estacionamento = new ArrayList<>();
        listaDeCarros = new ArrayList<>();
        List<Evento> listaDeEventos = new ArrayList<>();

        int operacao=0;

        do{
            operacao = menuPrincipal();

            Estacionamento tempEstacionamento = null;
            Contratante tempContrato = null;

            switch (operacao){
                case 1:
                    estacionamento.add(cadastroEstacionamento(tempEstacionamento,tempContrato));
                    break;

                case 2:
                    listaDeCarros.add(cadastroDeVeiculos());
                    break;

                case 3:

                    if (estacionamento.isEmpty()){
                        System.out.println("Não existe estacionamento cadastrado!");
                    }else{
                        procuraNomeEstacionamento();
                    }
                    break;

                case 4:
                    String perguntaRepete = "não";
                    do{
                        listaDeEventos.add(cadastrarEventos());
                        System.out.println("Deseja cadastrar outro evento ?");
                        perguntaRepete = esc.next();

                    }while(perguntaRepete == "não");
                    break;

                case 5:
                    procuraEstacionamento();
                    break;

                case 6:
                    System.out.println("Obrigado por usar o sistema :) ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida, escolha novamente !");
                    break;
            }
        }while(operacao !=6);
    }

    public static int menuPrincipal(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos ao Sistema de Estacionamento ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar Estacionamento   |");
        System.out.println("|   Opção 2 - Cadastrar Veiculos   |");
        System.out.println("|   Opção 3 - Entrar em um estacionamento     |");
        System.out.println("|   Opção 4 - Cadastrar Eventos         |");
        System.out.println("|   Opção 5 - Listar Estacionamentos    |");
        System.out.println("|   Opção 6 - Sair          |");
        int opcao = esc.nextInt();
        return opcao;
    }

    public static int menuEstacionamento(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Menu de Opções do Estacionamento ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar Acesso   |");
        System.out.println("|   Opção 2 - Listar Acesso   |");
        System.out.println("|   Opção 3 - Adicionar Eventos   |");
        System.out.println("|   Opção 4 - Alterar Dados de Eventos     |");
        System.out.println("|   Opção 5 - Alterar Dados Estacionamentos     |");
        System.out.println("|   Opção 6 - Cadastrar um Associado    |");
        System.out.println("|   Opção 7 - Sair          |");
        int opcao = esc.nextInt();
        return opcao;
    }

    public static int menuAcesso(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Menu de Opções de Acesso ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Acesso por comum   |");
        System.out.println("|   Opção 2 - Acesso Mensalista   |");
        System.out.println("|   Opção 3 - Sair          |");
        int opcao = esc.nextInt();
        return opcao;
    }

    public static Estacionamento cadastroEstacionamento(Estacionamento tempEstacionamento, Contratante tempContrato){
        System.out.println("Qual o nome do contratante desse Estacionamento ?");
        String nomeContratante = esc.next();

        System.out.println("Qual o valor retornará ao prestador do serviço ? ");
        double retornoPorcento = esc.nextDouble();

        tempContrato = new Contratante(nomeContratante,retornoPorcento,0);

        System.out.println("Qual o nome do estacionamento ?");
        String nomeEstacionamento1 = esc.next();

        System.out.println("Qual a capacidade do estacionamento ?");
        int qtdEstacionamento = esc.nextInt();

        System.out.println("Qual a horário que o mesmo abre ?");
        String horaAbre = esc.next();
        LocalTime horaAbre1 = LocalTime.parse(horaAbre);

        System.out.println("Qual a horário que o mesmo fecha ?");
        String horaFecha = esc.next();
        LocalTime horaFecha1 = LocalTime.parse(horaFecha);


        List<Evento> tempEvento = new ArrayList<>();

        List<Acesso> tempAcess = new ArrayList<>();

        List<Veiculo> tempVeiculo= new ArrayList<>();

        tempEstacionamento = new Estacionamento(nomeEstacionamento1,qtdEstacionamento, horaAbre1,horaFecha1, tempContrato,tempEvento,tempAcess,tempVeiculo);
        System.out.println("Cadastrado com sucesso!");
        System.out.println(tempEstacionamento);

        return tempEstacionamento;
    }

    public static void procuraEstacionamento(){
        for (Estacionamento x: estacionamento) {
            System.out.println(x.getContratato().getNomeContratante());
        }
    }

    public static void procuraNomeEstacionamento(){
        System.out.println("Escreva o nome do estacionamento que deseja entrar ?");
        String nomeProcura = esc.next();

        for (Estacionamento x: estacionamento) {
            if (nomeProcura.equals(x.getNomeEstacionamento())){
                int operacao=0;
                do{

                    operacao = menuEstacionamento();

                    switch (operacao) {
                        case 1:
                            int operacao1;
                            do{
                                operacao1 = menuAcesso();
                                controleAcesso(x, operacao1);
                            }while(operacao1 !=3);

                            break;

                        case 2:
                            procuraAcesso(x.getAcessoEstacionamento());
                            break;
                        case 3:
                            List<Evento> temporario = new ArrayList<>();

                            String repetePergunta = "não";

                            temporario.addAll(x.getEventos());
                                do{
                                    System.out.println("Qual o nome do Evento ?");
                                    String nomeEventotemp = esc.next();

                                    System.out.println("Qual a data do Evento ?");
                                    String dataEvento = esc.next();


                                    System.out.println("Qual o preço do evento ?");
                                    double precoEvento = esc.nextDouble();

                                    System.out.println("Qual a horário que o mesmo abre ?");
                                    String horaAbre = esc.next();

                                    System.out.println("Qual a horário que o mesmo fecha ?");
                                    String horaFecha = esc.next();

                                    Evento tempEvento = new Evento(nomeEventotemp,precoEvento,LocalDate.parse(dataEvento),LocalTime.parse(horaAbre),LocalTime.parse(horaFecha));

                                    temporario.add(tempEvento);
                                    x.setEventos(temporario);
                                }while(repetePergunta != "não");

                            break;

                        case 4:
                            System.out.println("Qual o nome do evento e a data ,do evento que deseja alterar ?");
                            String tempNomeEvento = esc.next();
                            String tempDataEvento = esc.next();
                            LocalDate tempDataEvento1 = LocalDate.parse(tempDataEvento);



                            for (Evento y: x.getEventos()) {
                               if(y.getNomeEvento().equals(tempNomeEvento) && y.getDataEvento().equals(tempDataEvento)){
                                   String desejo = "não";
                                   System.out.println("Deseja alterar o nome do Evento ? ");
                                   desejo = esc.next();
                                   if(desejo.equalsIgnoreCase("sim")){
                                        System.out.println("Escreva o novo nome do Evento: ");
                                        tempNomeEvento = esc.next();
                                    }

                                   desejo = "não";

                                   System.out.println("Deseja alterar o data do Evento ? ");
                                   desejo = esc.next();

                                    if(desejo.equalsIgnoreCase("sim")){
                                        System.out.println("Escreva a nova data do Evento: ");
                                        tempDataEvento = esc.next();
                                    }

                                   y.setNomeEvento(tempNomeEvento);
                                   y.setDataEvento(LocalDate.parse(tempDataEvento));
                               }
                            }

                            break;

                        case 5:
                            String desejo;

                            System.out.println("Deseja alterar todo o contrato ? S/N");
                            desejo = esc.next();

                            if(desejo == "S") {
                                System.out.println("Qual o novo nome do contratante desse Estacionamento ?");
                                String nomeContratante = esc.next();

                                System.out.println("Qual o novo valor retornará ao prestador do serviço ? ");
                                int retornoPorcento = esc.nextInt();

                                Contratante tempContrato = new Contratante(nomeContratante, retornoPorcento, 0);
                                x.setContratato(tempContrato);
                            }

                            System.out.println("Deseja alterar o nome do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(desejo=="S"){
                                System.out.println("Qual o nome do estacionamento ?");
                                String nomeEstacionamento1 = esc.next();
                                x.setNomeEstacionamento(nomeEstacionamento1);
                            }

                            System.out.println("Deseja alterar a capacidade do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(desejo=="S") {
                                System.out.println("Qual a capacidade do estacionamento ?");
                                int qtdEstacionamento = esc.nextInt();
                                x.setCapacidade(qtdEstacionamento);
                            }

                            System.out.println("Deseja alterar o horário de abertura Estacionamento ? S/N");
                            desejo = esc.next();

                            if(desejo=="S") {
                                System.out.println("Qual a horário que o mesmo abre ?");
                                String horaAbre = esc.next();
                                x.setHoraAbertura(LocalTime.parse(horaAbre));
                            }

                            System.out.println("Deseja alterar o horário de fechamento do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(desejo=="S") {
                                System.out.println("Qual a horário que o mesmo fecha ?");
                                String horaFecha = esc.next();
                                x.setHoraFechamento(LocalTime.parse(horaFecha));
                            }
                            break;
                        case 6:
                            List<Veiculo>temp = new ArrayList<>();

                            String repetePergunta1 = "não";

                            temp.addAll(x.getListaAssociados());
                            do{

                                System.out.println("Digite a placa do veículo ");
                                String temp1Placa = esc.next();

                                System.out.println("Digite a modelo do veículo ");
                                String temp1Modelo = esc.next();

                                System.out.println("Digite a marca do veículo ");
                                String temp1Marca = esc.next();

                               Veiculo temp1Veiculo = new Veiculo(temp1Placa, temp1Marca, temp1Modelo);

                                temp1Veiculo = new Veiculo(temp1Placa,temp1Modelo,temp1Modelo);
                                System.out.println("Cadastrado com sucesso!");

                                temp.add(temp1Veiculo);
                                x.setListaAssociados(temp);

                                System.out.println(x.getListaAssociados());

                            }while(repetePergunta1 != "não");

                            break;

                        case 7:
                            System.out.println("Encerrando Estacionamento...");
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                }while(operacao != 7);

            }else{
                System.out.println("Estacionamento não encontrado !");
            }
        }
    }

    public static Veiculo cadastroDeVeiculos(){
        System.out.println("Qual a marca do Carro ?");
        String marcaCarro = esc.next();

        System.out.println("Qual a placa do Carro ?");
        String placaCarro = esc.next();

        System.out.println("Qual o modelo do veículo ?");
        String modeloCarro = esc.next();

        Veiculo tempVeiculo = new Veiculo(placaCarro,marcaCarro,modeloCarro);
        System.out.println(tempVeiculo);

        return tempVeiculo;
    }

    public static Evento cadastrarEventos(){
        System.out.println("Qual o nome do Evento ?");
        String nomeEventotemp = esc.next();

        System.out.println("Qual a data do Evento ?");
        String dataEvento = esc.next();

        System.out.println("Qual o preço do evento ?");
        double precoEvento = esc.nextDouble();

        System.out.println("Qual a horário que o mesmo abre ?");
        String horaAbre2 = esc.next();

        System.out.println("Qual a horário que o mesmo fecha ?");
        String horaFecha2 = esc.next();

        Evento tempEvento1 = new Evento(nomeEventotemp,precoEvento,LocalDate.parse(dataEvento),LocalTime.parse(horaAbre2),LocalTime.parse(horaFecha2));

        return tempEvento1;
    }

    public static void procuraAcesso(List<Acesso> acess){
        for (Acesso x: acess) {
            System.out.println(x.getVeiculoCliente());
            System.out.println(x.getHoraEntrada());
            System.out.println(x.getHoraSaida());
            System.out.println(x.getDataInicial());
            System.out.println(x.getDataFinal());
        }
    }

    public static void controleAcesso(Estacionamento x, int operacao1) {
        Acesso tempAcess = null;
        switch (operacao1){
            case 1:
                List<Acesso> acessoTemporario = new ArrayList<>();
                acessoTemporario.addAll(x.getAcessoEstacionamento());
                double desconto =0;
                LocalTime NOITE = LocalTime.of(18,00);
                LocalTime NOITE2 = LocalTime.of(06,00);
                Duration NOTURNA = Duration.between(NOITE2,NOITE);


                System.out.println("Digite a hora de entrada do veículo \n Escreva Ano-mes-diaThora:minutos");
                String entrada = esc.next();

                System.out.println("Digite a hora de saída do veículo \n Escreva Ano-mes-diaThora:minutos");
                String saida = esc.next();


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                LocalDateTime date1 = LocalDateTime.parse(entrada);
                LocalDateTime date2 = LocalDateTime.parse(saida);

                date1.format(formatter);
                date2.format(formatter);

                Duration duracao = Duration.between(date1, date2);

                long horas = duracao.toHours();
                long minutos= duracao.toMinutes() % 60;


                if(date1.toLocalTime().isBefore(x.getHoraAbertura()) || date1.toLocalTime().isAfter(x.getHoraFechamento())){
                    System.out.println("O estacionamento está fechado, por isso não será possível realizar cadastro!");
                    break;
                }

                System.out.println("Digite a placa do veículo ");
                String tempPlaca = esc.next();

                System.out.println("Digite a modelo do veículo ");
                String tempModelo = esc.next();

                System.out.println("Digite a marca do veículo ");
                String tempMarca = esc.next();

                Veiculo tempVeiculo = new Veiculo(tempPlaca, tempMarca, tempModelo);
                System.out.printf("%d:%2d\n",horas,minutos);

                if(horas < 1){
                    System.out.println("Digite o valor dos 15 minutos do estacionamento ");
                    double valorFracao = esc.nextDouble();
                    System.out.println("Acesso por 15 Minutos: ");
                    double valorMinuto = Math.ceil(minutos / 15) * valorFracao;
                    System.out.println("O valor Total: " + valorMinuto);
                    tempAcess = new Tempo(date1.toLocalTime(),date2.toLocalTime(),date1.toLocalDate(),date2.toLocalDate(),tempVeiculo,desconto, valorFracao);
                }else if (horas >= 1 && horas <=9 ){
                    System.out.println("Digite o valor dos 15 minutos do estacionamento ");
                    double valorFracao = esc.nextDouble();
                    System.out.println("Acesso por Hora Cheia: ");
                    double valorHora = Math.ceil((horas * 60) / 15) * valorFracao + Math.ceil(minutos / 15) * valorFracao;

                    System.out.println("Digite o valor do desconto em decimal. Ex.: 0.20");
                    desconto = esc.nextDouble();
                    desconto = 1.00 - desconto;

                    System.out.printf("O valor Total (sem desconto): R$%.2f\n", valorHora);

                    double valorHora2 = valorHora * desconto;

                    System.out.printf("O valor Total (com desconto): R$%.2f\n", valorHora2);
                    tempAcess = new Tempo(date1.toLocalTime(),date2.toLocalTime(),date1.toLocalDate(),date2.toLocalDate(),tempVeiculo,desconto, valorFracao);
                    
                }else if(horas >9){
                    //Diaria Diurna
                    System.out.println("O tempo excedeu 9 horas e se tornou uma diaria");
                    System.out.println("Digite o valor da diaria ");
                    double valorDiaria = esc.nextDouble();

                    System.out.println(date1.toLocalTime());
                    if(date1.toLocalTime().isAfter(NOITE) || date1.toLocalTime().isBefore(NOITE2)){
                    //Diaria Noturna
                        System.out.println("Digite o percentual da diaria noturna");
                        double valorDiariaN= esc.nextDouble();
                        valorDiariaN = (1.00 - valorDiariaN)*valorDiaria;
                        System.out.printf("O valor Total da Diaria Noturna: R$%.2f\n", valorDiariaN);
                        tempAcess = new DiariaNoturna(date1.toLocalTime(),date2.toLocalTime(),date1.toLocalDate(),date2.toLocalDate(),tempVeiculo,valorDiaria,valorDiariaN);

                    }else {
                        System.out.printf("O valor Total da Diaria Diurna: R$%.2f\n", valorDiaria);
                        tempAcess = new Diaria(date1.toLocalTime(),date2.toLocalTime(),date1.toLocalDate(),date2.toLocalDate(),tempVeiculo,valorDiaria);
                        
                    }
                }

                acessoTemporario.add(tempAcess);

                x.setAcessoEstacionamento(acessoTemporario);

                break;
                
            case 2:
                System.out.println("Acesso por Mensalista: ");
                tempAcess = new Mensalista();

                System.out.println("Qual a placa do veiculo associado ?");
                String tempPlaca1 = esc.next();

                for (Veiculo y: x.getListaAssociados()) {
                    if(y.getPlaca().equals(tempPlaca1) ) {
                        System.out.println("O veículo já está cadastrado");
                        System.out.println("o custo foi");
                        break;

                    }else {
                        System.out.println("O veículo não está na Lista de Associados");
                        break;

                    }

                    }


                break;

            case 3:
                System.out.println("Cancelando cadastro...");
                break;

            default:
                System.out.println("Opção inválida, escolha novamente !");
                break;
        }
    }


}