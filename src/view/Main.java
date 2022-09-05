package view;

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
        Scanner escanear = new Scanner(System.in);
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
                        perguntaRepete = escanear.next();

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
        }while(operacao !=5);
        escanear.close();
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
        System.out.println("|   Opção 4 - Alterar Dados Estacionamentos     |");
        System.out.println("|   Opção 5 - Sair          |");
        int opcao = esc.nextInt();
        return opcao;
    }

    public static int menuAcesso(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Menu de Opções de Acesso ---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma ação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Acesso por 15 Minutos   |");
        System.out.println("|   Opção 2 - Acesso por Hora Cheia   |");
        System.out.println("|   Opção 3 - Acesso Mensalista   |");
        System.out.println("|   Opção 4 - Acesso Diária     |");
        System.out.println("|   Opção 5 - Acesso Diária Noturna     |");
        System.out.println("|   Opção 6 - Sair          |");
        int opcao = esc.nextInt();
        return opcao;
    }

    public static Estacionamento cadastroEstacionamento(Estacionamento tempEstacionamento, Contratante tempContrato){
        System.out.println("Qual o nome do contratante desse Estacionamento ?");
        String nomeContratante = esc.next();

        System.out.println("Qual o valor retornará ao prestador do serviço ? ");
        int retornoPorcento = esc.nextInt();

        tempContrato = new Contratante(nomeContratante,retornoPorcento,0);

        System.out.println("Qual o nome do estacionamento ?");
        String nomeEstacionamento1 = esc.next();

        System.out.println("Qual a capacidade do estacionamento ?");
        int qtdEstacionamento = esc.nextInt();

        System.out.println("Qual a horário que o mesmo abre ?");
        String horaAbre = esc.next();

        System.out.println("Qual a horário que o mesmo fecha ?");
        String horaFecha = esc.next();

        List<Evento> tempEvento = new ArrayList<>();

        List<Acesso> tempAcess = new ArrayList<>();

        tempEstacionamento = new Estacionamento(nomeEstacionamento1,qtdEstacionamento, horaAbre,horaFecha, tempContrato,tempEvento,tempAcess);

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
                            // Cadastro de Acesso (Responsável.: Paulo e Danilo) // Cada um por sua respectiva parte
                            int operacao1 = menuAcesso();

                            controleAcesso(x, operacao1);
                            break;

                        case 2:
                            procuraAcesso(x.getAcessoEstacionamento());
                            break;
                        case 3:
                            // Adicionar Evento
                            break;

                        case 4:
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
                                x.setHoraAbertura(horaAbre);
                            }

                            System.out.println("Deseja alterar o horário de fechamento do Estacionamento ? S/N");
                            desejo = esc.next();

                            if(desejo=="S") {
                                System.out.println("Qual a horário que o mesmo fecha ?");
                                String horaFecha = esc.next();
                                x.setHoraFechamento(horaFecha);
                            }
                            break;

                        case 5:
                            System.out.println("Encerrando Estacionamento...");
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                }while(operacao != 5);

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

        Evento tempEvento1 = new Evento(nomeEventotemp,precoEvento,dataEvento,horaAbre2,horaFecha2);

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
        Acesso tempAcess;
        switch (operacao1){
            case 1:
                System.out.println("Acesso por 15 Minutos: ");
                  tempAcess = new Tempo();
                break;

            case 2:
                System.out.println("Acesso por hora cheia: ");
                tempAcess = new Tempo();
                break;

            case 3:
                System.out.println("Acesso por Diária: ");
                tempAcess = new Diaria();
               break;

            case 4:
                System.out.println("Acesso por Diária Noturna: ");
                tempAcess = new DiariaNoturna();
                break;

            case 5:
                System.out.println("Acesso por Mensalista: ");
                tempAcess = new Mensalista();
                break;

            case 6:
                System.out.println("Cancelando cadastro...");
                break;

            default:
                System.out.println("Opção inválida, escolha novamente !");
                break;
        }
    }


}