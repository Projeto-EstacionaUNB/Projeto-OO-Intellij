package view;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import exception.*;
import model.*;

public class Main {

    static Scanner esc = new Scanner(System.in);
    static List<Estacionamento> estacionamento;
    static List<Veiculo> listaDeCarros;

    public static void main(String[] args) throws DescricaoEmBrancoException, ObjetoNãoEncontradoException, ValorAcessoInvalidoException {
        operacoes();
    }

    public static void operacoes() throws DescricaoEmBrancoException, ObjetoNãoEncontradoException, ValorAcessoInvalidoException {
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

                    if (estacionamento.isEmpty()){
                        throw new ObjetoNãoEncontradoException();
                    }else{
                        procuraNomeEstacionamento();
                    }
                    break;

                case 3:

                    if (estacionamento.isEmpty()){
                        throw new ObjetoNãoEncontradoException();
                    }else{
                        procuraApagarEstacionamento();
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
                    double sum =0;
                    for (Estacionamento x: estacionamento) {
                        sum += x.getContratato().getValorContratante();
                    }
                    System.out.println(sum);
                    break;

                case 7:
                    System.out.println("Obrigado por usar o sistema :) ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida, escolha novamente !");
                    break;
            }
        }while(operacao !=7);
    }

    public static int menuPrincipal(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos ao Sistema de Estacionamento ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar Estacionamento   |");
        System.out.println("|   Opção 2 - Entrar em um estacionamento     |");
        System.out.println("|   Opção 3 - Apagar em um estacionamento     |");
        System.out.println("|   Opção 4 - Cadastrar Eventos         |");
        System.out.println("|   Opção 5 - Listar Estacionamentos    |");
        System.out.println("|   Opção 6 - Valor Total Recebido dos Estacionamentos    |");
        System.out.println("|   Opção 7 - Sair          |");
        return esc.nextInt();
    }

    public static int menuEstacionamento(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Menu de Opções do Estacionamento ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar Acesso   |");
        System.out.println("|   Opção 2 - Listar Acessos   |");
        System.out.println("|   Opção 3 - Pesquisar Acesso   |");
        System.out.println("|   Opção 4 - Alterar Acessos     |");
        System.out.println("|   Opção 5 - Apagar Acessos     |");
        System.out.println("|   Opção 6 - Pesquisar Evento    |");
        System.out.println("|   Opção 7 - Listar Eventos   |");
        System.out.println("|   Opção 8 - Adicionar Eventos   |");
        System.out.println("|   Opção 9 - Alterar Dados de Eventos     |");
        System.out.println("|   Opção 10 - Apagar Evento     |");
        System.out.println("|   Opção 11 - Alterar Dados Estacionamentos     |");
        System.out.println("|   Opção 12 - Cadastrar um Associado    |");
        System.out.println("|   Opção 13 - Verificar o valor total do Contratante   |");
        System.out.println("|   Opção 14 - Sair          |");
        return esc.nextInt();
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
        return esc.nextInt();
    }

    public static Estacionamento cadastroEstacionamento(Estacionamento tempEstacionamento, Contratante tempContrato) {

        String tmp = esc.nextLine();

        try {
            System.out.println("Qual o nome do contratante desse Estacionamento ?");
            String nomeContratante = esc.nextLine();

            System.out.println("Qual o valor retornará ao prestador do serviço ? ");
            String retornoPorcento = esc.nextLine();

            if (nomeContratante.isEmpty() || retornoPorcento.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }

            tempContrato = new Contratante(nomeContratante, Double.parseDouble(retornoPorcento), 0);

        } catch (DescricaoEmBrancoException e) {
            e.printStackTrace();
        }

        String qtdEstacionamento = null;
        String nomeEstacionamento1 = null;

        try {
            System.out.println("Qual o nome do estacionamento ?");
            nomeEstacionamento1 = esc.nextLine();

            System.out.println("Qual a capacidade do estacionamento ?");
            qtdEstacionamento = esc.nextLine();

            if (nomeEstacionamento1.isEmpty() || qtdEstacionamento.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }
        } catch (DescricaoEmBrancoException e) {
            e.printStackTrace();
        }

        LocalTime horaAbre1 = null;
        LocalTime horaFecha1 = null;
        Tempo tempAcessoTempo = null;
        Tempo tempAcessoFracao = null;

        try {
            System.out.println("Qual a horário que o mesmo abre ?");
            String horaAbre = esc.nextLine();

            System.out.println("Qual a horário que o mesmo fecha ?");
            String horaFecha = esc.nextLine();

            System.out.println("Qual o valor padrão da fração do estacionamento(em 15 minutos)");
            String valorFracao = esc.nextLine();

            System.out.println("Qual o valor padrão do desconto hora cheia do estacionamento: Ex.: 0,20 represesenta 20% ");
            String desconto = esc.nextLine();

            if (horaAbre.isEmpty() || horaFecha.isEmpty() || valorFracao.isEmpty() || desconto.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }

            horaAbre1 = LocalTime.parse(horaAbre);
            horaFecha1 = LocalTime.parse(horaFecha);
            tempAcessoFracao = new Tempo(valorFracao);

            tempAcessoTempo = new Tempo(Double.parseDouble(valorFracao), Double.parseDouble(desconto));
            Double.parseDouble(String.valueOf(valorFracao));

        } catch (DescricaoEmBrancoException e) {
            e.printStackTrace();
        }

        Diaria tempAcessoDiaria = null;
        Mensalista tempAcessoMensalista = null;
        DiariaNoturna tempAcessoDiariaNoturna = null;
        try {
            System.out.println("Qual o valor padrão da Diaria do estacionamento: ");
            String valorDiaria = esc.nextLine();

            System.out.println("Qual o percentual padrão da Diaria Noturna do estacionamento: ");
            String valorDiariaN = esc.nextLine();

            System.out.println("Qual o valor padrão do acesso dos Mensalistas do estacionamento");
            String valorMensal = esc.nextLine();

            if (valorDiaria.isEmpty() || valorDiariaN.isEmpty() || valorMensal.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }

            tempAcessoDiaria = new Diaria(Double.parseDouble(valorDiaria));
            tempAcessoDiariaNoturna = new DiariaNoturna(Double.parseDouble(valorDiariaN));
            valorMensal = String.valueOf(Double.parseDouble(valorMensal));
            tempAcessoMensalista = new Mensalista(valorMensal);

        } catch (DescricaoEmBrancoException e) {
            e.printStackTrace();
        }

        List<Evento> tempEvento = new ArrayList<>();

        List<Acesso> tempAcess = new ArrayList<>();

        List<Veiculo> tempVeiculo = new ArrayList<>();

        tempEstacionamento = new Estacionamento(nomeEstacionamento1, Integer.parseInt(qtdEstacionamento), horaAbre1, horaFecha1,
                tempContrato, tempAcessoDiaria, tempAcessoDiariaNoturna,
                tempAcessoMensalista, tempAcessoTempo,
                tempAcessoFracao,
                tempEvento,tempAcess,tempVeiculo);
        System.out.println("Estacionamento, cadastrado com sucesso!");
        return tempEstacionamento;
    }

    public static void procuraEstacionamento(){
        for (Estacionamento x: estacionamento) {
            System.out.println(x.getContratato().getNomeContratante() + " " + x.getNomeEstacionamento());
        }
    }

    public static void listaEvento(Estacionamento y){
        for (Evento x: y.getEventos()) {
            System.out.println(x.getNomeEvento() + " - " + x.getDataEvento() + " - " + x.getDataEvento());
        }
    }

    public static void procuraEvento(Estacionamento y){
        System.out.println("Digite o nome do Evento: ");
        String nomeProcura = esc.nextLine();

        for (Evento x: y.getEventos()) {
            if(nomeProcura.equalsIgnoreCase(x.getNomeEvento())){
                System.out.println("Evento Encontrado !");
                System.out.println(x.getNomeEvento() + " - " + x.getDataEvento() + " - " + x.getDataEvento());
            }
        }
    }

    public static void procuraApagarEvento(Estacionamento x, List<Evento> tempEvento) {
        System.out.println("Escreva o nome do evento que deseja encontrar ?");
        String nomeProcura = esc.nextLine();

        for (Evento y : x.getEventos()) {
            if (nomeProcura.equals(y.getNomeEvento())){
                tempEvento.remove(y);
                break;
            }
        }
    }

    public static void procuraApagarEstacionamento() {
        System.out.println("Escreva o nome do estacionamento que deseja entrar ?");
        String nomeProcura = esc.next();

        for (Estacionamento x : estacionamento) {
            if (nomeProcura.equals(x.getNomeEstacionamento())) {
                estacionamento.remove(x);
                break;
            }
        }
    }
    public static void procuraNomeEstacionamento() throws ValorAcessoInvalidoException {
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
                            System.out.println("Digite o numero e letra da placa: ");
                            String placaProcuraAcesso = esc.nextLine();

                            System.out.println("Digite a Data em que aconteceu o Acesso");
                            String dataProcuraAcesso = esc.nextLine();
                            LocalDate dataProcuraAcesso1 = LocalDate.parse(dataProcuraAcesso);

                            for (Acesso y: x.getAcessoEstacionamento()) {
                                if(placaProcuraAcesso.equalsIgnoreCase(y.getVeiculoCliente().getPlaca()) && dataProcuraAcesso1.equals(y.getDataInicial())){
                                    System.out.println("Acesso Encontrado !");
                                    System.out.println("Acesso: " + y.getVeiculoCliente().getPlaca() + " - " + y.getDataInicial() + " - " + y.getDataFinal() + " - " + y.getHoraEntrada() + " - " + y.getHoraSaida());
                                }
                            }
                            break;

                        case 4:
                            System.out.println("Qual a placa do Véiculo ,deseja encontrar os Acessos ?");
                            String placaPesquisa = esc.next();

                            for (Acesso y: x.getAcessoEstacionamento()) {
                                if (y.getVeiculoCliente().getPlaca().equals(placaPesquisa)) {
                                    System.out.println("Acesso: " + y.getVeiculoCliente().getPlaca() + " - " + y.getDataInicial() + " - " + y.getDataFinal() + " - " + y.getHoraEntrada() + " - " + y.getHoraSaida());
                                }
                            }

                        case 5:
                            System.out.println("Qual a placa do Véiculo ,deseja encontrar os Acessos e logo em seguida apagar ?");
                            placaPesquisa = esc.next();

                            for (Acesso y: x.getAcessoEstacionamento()) {
                                if (y.getVeiculoCliente().getPlaca().equals(placaPesquisa)) {
                                    System.out.println("Acesso :" + y.getVeiculoCliente().getPlaca() + " - " + y.getDataInicial() + " - " + y.getDataFinal() + " - " + y.getHoraEntrada() + " - " + y.getHoraSaida());
                                    String apagarEsse = "não";
                                    System.out.println("Deseja apagar esse Acesso ? sim/não");
                                    apagarEsse = esc.nextLine();
                                    if(Objects.equals(apagarEsse,"sim")){
                                        x.getAcessoEstacionamento().remove(y);
                                        break;
                                    }
                                }
                            }
                            break;

                        case 6:
                            procuraEvento(x);
                            break;

                        case 7:
                            listaEvento(x);
                            break;

                        case 8:
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

                        case 9:
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

                        case 10:
                            procuraApagarEvento(x,x.getEventos());
                            break;
                        case 11:
                            String desejo;

                            System.out.println("Deseja alterar todo o contrato ? S/N");
                            desejo = esc.next();

                            if(Objects.equals(desejo, "S")) {
                                System.out.println("Qual o novo nome do contratante desse Estacionamento ?");
                                String nomeContratante = esc.next();

                                System.out.println("Qual o novo valor retornará ao prestador do serviço ? ");
                                int retornoPorcento = esc.nextInt();

                                Contratante tempContrato = new Contratante(nomeContratante, retornoPorcento, 0);
                                x.setContratato(tempContrato);
                            }

                            System.out.println("Deseja alterar o nome do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(Objects.equals(desejo, "S")){
                                System.out.println("Qual o nome do estacionamento ?");
                                String nomeEstacionamento1 = esc.next();
                                x.setNomeEstacionamento(nomeEstacionamento1);
                            }

                            System.out.println("Deseja alterar a capacidade do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(Objects.equals(desejo, "S")) {
                                System.out.println("Qual a capacidade do estacionamento ?");
                                int qtdEstacionamento = esc.nextInt();
                                x.setCapacidade(qtdEstacionamento);
                            }

                            System.out.println("Deseja alterar o horário de abertura Estacionamento ? S/N");
                            desejo = esc.next();

                            if(Objects.equals(desejo, "S")) {
                                System.out.println("Qual a horário que o mesmo abre ?");
                                String horaAbre = esc.next();
                                x.setHoraAbertura(LocalTime.parse(horaAbre));
                            }

                            System.out.println("Deseja alterar o horário de fechamento do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(Objects.equals(desejo, "S")) {
                                System.out.println("Qual a horário que o mesmo fecha ?");
                                String horaFecha = esc.next();
                                x.setHoraFechamento(LocalTime.parse(horaFecha));
                            }
                            break;
                        case 12:

                            String repetePergunta1 = "não";

                            List<Veiculo> temp = new ArrayList<>(x.getListaAssociados());
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

                            }while(!repetePergunta1.equals("não"));

                            break;

                        case 13:
                            System.out.println(x.getContratato().getValorContratante());
                            break;
                        case 14:
                            System.out.println("Encerrando Estacionamento...");
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                }while(operacao != 14);

            }else{
                System.out.println("Estacionamento não encontrado !");
            }
        }
    }

    public static  Veiculo cadastroDeVeiculos() {

        Veiculo tempVeiculo = new Veiculo();

        String tmp = esc.nextLine();

        try {
            System.out.println("Qual a marca do Carro ?");
            String marcaCarro = esc.nextLine();

            System.out.println("Qual a placa do Carro ?");
            String placaCarro = esc.nextLine();

            System.out.println("Qual o modelo do veículo ?");
            String modeloCarro = esc.nextLine();

            if (placaCarro.isEmpty() || marcaCarro.isEmpty() || modeloCarro.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }
            tempVeiculo = new Veiculo(placaCarro, marcaCarro, modeloCarro);
            System.out.println(tempVeiculo);

        } catch (DescricaoEmBrancoException e) {
            e.printStackTrace();
        }

        return tempVeiculo;
    }

    public static Evento cadastrarEventos() throws DescricaoEmBrancoException{

        Evento tempEvento1 = new Evento();

        String tmp = esc.nextLine();

        try {

            System.out.println("Qual o nome do Evento ?");
            String nomeEventotemp = esc.nextLine();

            System.out.println("Qual a data do Evento ? \nEx: 0000-00-00");
            String dataEvento = esc.nextLine();

            System.out.println("Qual o preço do evento ?");
            String precoEvento = esc.nextLine();

            System.out.println("Qual a horário que o mesmo abre ?");
            String horaAbre2 = esc.nextLine();

            System.out.println("Qual a horário que o mesmo fecha ?");
            String horaFecha2 = esc.nextLine();

            if (nomeEventotemp.isEmpty() || dataEvento.isEmpty() || precoEvento.isEmpty() || horaFecha2.isEmpty()) {
                throw new DescricaoEmBrancoException();
            }

            tempEvento1 = new Evento(nomeEventotemp,Double.parseDouble(precoEvento),LocalDate.parse(dataEvento),LocalTime.parse(horaAbre2),LocalTime.parse(horaFecha2));
            System.out.println(tempEvento1);

        }catch(DescricaoEmBrancoException e){
            e.printStackTrace();
        }
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

    public static void controleAcesso(Estacionamento x, int operacao1) throws ValorAcessoInvalidoException {
        Acesso tempAcess = null;
        switch (operacao1) {
            case 1:
                List<Acesso> acessoTemporario = new ArrayList<>(x.getAcessoEstacionamento());
                double desconto = 0;
                LocalTime NOITE = LocalTime.of(18, 00);
                LocalTime NOITE2 = LocalTime.of(06, 00);

                String entrada = null;
                String saida = null;

                LocalDateTime date1 = null;
                DateTimeFormatter formatter = null;

                String tmp = esc.nextLine();

                try {
                    System.out.println("Digite a hora de entrada do veículo \n Escreva Ano-mes-diaThora:minutos");
                    entrada = esc.nextLine();

                    System.out.println("Digite a hora de saída do veículo \n Escreva Ano-mes-diaThora:minutos");
                    saida = esc.nextLine();

                    if (entrada.isEmpty() || saida.isEmpty()) {
                        throw new DescricaoEmBrancoException();
                    }

                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                } catch (DescricaoEmBrancoException e) {
                    e.printStackTrace();
                }

                date1 = LocalDateTime.parse(entrada);
                LocalDateTime date2 = LocalDateTime.parse(saida);

                date1.format(formatter);
                date2.format(formatter);

                Duration duracao = Duration.between(date1, date2);

                long horas = duracao.toHours();
                long minutos = duracao.toMinutes() % 60;

                if(horas <= 0 || minutos <= 0){
                    throw new ValorAcessoInvalidoException();
                }


                if (date1.toLocalTime().isBefore(x.getHoraAbertura()) || date1.toLocalTime().isAfter(x.getHoraFechamento())) {
                    System.out.println("O estacionamento está fechado, por isso não será possível realizar cadastro!");
                    break;
                }

                try {
                    System.out.println("Digite a placa do veículo ");
                    String tempPlaca = esc.nextLine();

                    System.out.println("Digite a modelo do veículo ");
                    String tempModelo = esc.nextLine();

                    System.out.println("Digite a marca do veículo ");
                    String tempMarca = esc.nextLine();


                    Veiculo tempVeiculo = new Veiculo(tempPlaca, tempMarca, tempModelo);
                    System.out.printf("%d:%2d Horas\n", horas, minutos);

                    if (tempPlaca.isEmpty() || tempModelo.isEmpty() || tempMarca.isEmpty()) {
                        throw new DescricaoEmBrancoException();
                    }
                } catch (DescricaoEmBrancoException e) {
                    e.printStackTrace();
                }
                Veiculo tempVeiculo = null;

                if (horas < 1) {
                    double valorMinuto = x.getDiariaTempo().calcularValorAcesso(minutos);
                    System.out.println("O valor Total: " + valorMinuto);
                    tempAcess = new Tempo(date1.toLocalTime(), date2.toLocalTime(), date1.toLocalDate(), date2.toLocalDate(), tempVeiculo, x.getDiariaTempo().getDesconto(), x.getDiariaTempo().getValorFracao());

                    double sum = x.getContratato().getValorContratante() + valorMinuto * x.getContratato().getRetornoContratante();
                    x.getContratato().setValorContratante(sum);


                } else if (horas >= 1 && horas <= 9) {

                    double valorHora = x.getDiariaTempo().calcularValorAcesso(horas, minutos);

                    System.out.printf("O valor Total (sem desconto): R$%.2f\n", valorHora);

                    desconto = 1.00 - x.getDiariaTempo().getDesconto();

                    double valorHora2 = valorHora * desconto;

                    System.out.printf("O valor Total (com desconto): R$%.2f\n", valorHora2);
                    tempAcess = new Tempo(date1.toLocalTime(), date2.toLocalTime(), date1.toLocalDate(), date2.toLocalDate(), tempVeiculo, x.getDiariaTempo().getDesconto(), x.getDiariaTempo().getValorFracao());

                    double sum = x.getContratato().getValorContratante() + valorHora2 * x.getContratato().getRetornoContratante();
                    x.getContratato().setValorContratante(sum);

                } else if (horas > 9) {
                    //Diaria Diurna
                    System.out.println("O tempo excedeu 9 horas e se tornou uma diaria");
                    double valorDiaria = x.getDiariaTempo().calcularValorAcesso(horas, minutos);

                    System.out.println(date1.toLocalTime());
                    if (date1.toLocalTime().isAfter(NOITE) || date1.toLocalTime().isBefore(NOITE2)) {
                        //Diaria Noturna
                        double valorDiariaN = x.getDiariaNoturna().calcularValorAcesso(valorDiaria);
                        System.out.printf("O valor Total da Diaria Noturna: R$%.2f\n", valorDiariaN);
                        tempAcess = new DiariaNoturna(date1.toLocalTime(), date2.toLocalTime(), date1.toLocalDate(), date2.toLocalDate(), tempVeiculo, x.getDiariaDiurna().getValorDiaria(), x.getDiariaNoturna().getPercentualDiaria());

                        double sum = x.getContratato().getValorContratante() + valorDiariaN * x.getContratato().getRetornoContratante();
                        x.getContratato().setValorContratante(sum);
                    } else {
                        System.out.printf("O valor Total da Diaria Diurna: R$%.2f\n", valorDiaria);
                        tempAcess = new Diaria(date1.toLocalTime(), date2.toLocalTime(), date1.toLocalDate(), date2.toLocalDate(), tempVeiculo, valorDiaria);
                        double sum = x.getContratato().getValorContratante() + valorDiaria * x.getContratato().getRetornoContratante();
                        x.getContratato().setValorContratante(sum);
                    }
                }

                acessoTemporario.add(tempAcess);

                x.setAcessoEstacionamento(acessoTemporario);

                break;

            case 2:
                System.out.println("Acesso por Mensalista: ");


                System.out.println("Qual a placa do veiculo associado ?");
                String tempPlaca1 = esc.next();

                boolean aparece = false;
                String tempPlaca = null;
                String tempModelo = null;
                String tempMarca = null;
                for (Veiculo y : x.getListaAssociados()) {
                    System.out.println(x.getListaAssociados());
                    if (y.getPlaca().equals(tempPlaca1)) {
                        aparece = true;
                        System.out.println("O veículo já está cadastrado");
                        System.out.println("o custo da mensalista esse mês é de : R$" + x.getMensalistaPreco().getValorMensalista());

                        List<Acesso> acessoTemporario1 = new ArrayList<>(x.getAcessoEstacionamento());
                        desconto = 0;

                        String tmp1 = esc.nextLine();
                        try {
                            System.out.println("Digite a hora de entrada do veículo \n Escreva Ano-mes-diaThora:minutos");
                            entrada = esc.next();

                            System.out.println("Digite a hora de saída do veículo \n Escreva Ano-mes-diaThora:minutos");
                            saida = esc.next();

                            if(entrada.isEmpty() || saida.isEmpty()){
                                throw new DescricaoEmBrancoException();
                            }

                            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


                            date1 = LocalDateTime.parse(entrada);
                            date2 = LocalDateTime.parse(saida);

                            date1.format(formatter);
                            date2.format(formatter);


                            duracao = Duration.between(date1, date2);

                            horas = duracao.toHours();
                            minutos = duracao.toMinutes() % 60;

                            if(horas <= 0 || minutos <=0){
                                throw new ValorAcessoInvalidoException();
                            }



                        if (date1.toLocalTime().isBefore(x.getHoraAbertura()) && date2.toLocalTime().isAfter(x.getHoraFechamento()) || date1.toLocalTime().isAfter(x.getHoraFechamento()) && date2.toLocalTime().isBefore(x.getHoraAbertura())) {
                            System.out.println("O estacionamento está fechado, por isso não será possível realizar cadastro!");
                            break;
                        }



                        double sum = x.getContratato().getValorContratante() + x.getMensalistaPreco().getValorMensalista() * x.getContratato().getRetornoContratante();
                        x.getContratato().setValorContratante(sum);

                        System.out.println("Digite a placa do veículo ");
                        tempPlaca = esc.next();

                        System.out.println("Digite a modelo do veículo ");
                        tempModelo = esc.next();

                        System.out.println("Digite a marca do veículo ");
                        tempMarca = esc.next();

                        tempVeiculo = new Veiculo(tempPlaca, tempMarca, tempModelo);
                        System.out.printf("%d:%2d Horas\n", horas, minutos);


                        tempAcess = new Mensalista(date1.toLocalTime(), date2.toLocalTime(), date1.toLocalDate(), date2.toLocalDate(), tempVeiculo, x.getMensalistaPreco().getValorMensalista());

                        acessoTemporario1.add(tempAcess);

                        x.setAcessoEstacionamento(acessoTemporario1);

                        }catch(DescricaoEmBrancoException e){
                            e.printStackTrace();
                        }
                    }

                }
                if (!aparece) {
                    System.out.println("O veículo não está na Lista de Associados");
                    String desejo = "não";

                    try{
                    System.out.println("Cadastrar Associado (sim/não) ?");
                    desejo = esc.next();

                    if (Objects.equals(desejo, "sim")) {
                        System.out.println("Digite a placa do veículo ");
                        tempPlaca = esc.next();

                        System.out.println("Digite a modelo do veículo ");
                        tempModelo = esc.next();

                        System.out.println("Digite a marca do veículo ");
                        tempMarca = esc.next();
                    }

                    if(tempPlaca.isEmpty() || tempModelo.isEmpty() || tempMarca.isEmpty()){
                        throw new DescricaoEmBrancoException();
                    }

                        Veiculo tempVeiculo1 = new Veiculo(tempPlaca, tempMarca, tempModelo);



                        List<Veiculo> listaTemporariaAssociados = new ArrayList<>(x.getListaAssociados());

                        listaTemporariaAssociados.add(tempVeiculo1);

                        x.setListaAssociados(listaTemporariaAssociados);
                        System.out.println(listaTemporariaAssociados);
                        System.out.println(x.getListaAssociados());

                    }catch(DescricaoEmBrancoException e){
                             e.printStackTrace();
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
