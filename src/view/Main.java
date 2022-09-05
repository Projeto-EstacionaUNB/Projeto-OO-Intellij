package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;


public class Main {

    static List<Estacionamento> estacionamento;
    public static void main(String[] args) {
        operacoes();
    }

    public static void operacoes() {
        Scanner escanear = new Scanner(System.in);
        int operacao=0;
        do{

            System.out.println("------------------------------------------------------");
            System.out.println("-------------Bem vindos ao Sistema de Estacionamento ---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione uma ação que deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - Cadastrar Estacionamento   |");
            System.out.println("|   Opção 2 - Entrar em um estacioanamento     |");
            System.out.println("|   Opção 3 - Cadastrar Eventos         |");
            System.out.println("|   Opção 4 - Listar Estacionamentos    |");
            System.out.println("|   Opção 5 - Sair          |");

            operacao = escanear.nextInt();

            Estacionamento tempEstacionamento;
            Contratante tempContrato;

            switch (operacao){
                case 1:
                    System.out.println("Qual o nome do contratante desse Estacionamento ?");
                    String nomeContratante = escanear.next();

                    System.out.println("Qual o valor retornará ao prestador do serviço ? ");
                    int retornoPorcento = escanear.nextInt();

                    tempContrato = new Contratante(nomeContratante,retornoPorcento,0);

                    System.out.println("Qual a capacidade do estacionamento ?");
                    int qtdEstacionamento = escanear.nextInt();

                    System.out.println("Qual a horário que o mesmo abre ?");
                    String horaAbre = escanear.next();

                    System.out.println("Qual a horário que o mesmo fecha ?");
                    String horaFecha = escanear.next();

                    List<Acesso> tempAcess = new ArrayList<>();

                    tempEstacionamento = new Estacionamento(qtdEstacionamento, horaAbre,horaFecha, tempContrato,tempAcess);
                    if(!tempEstacionamento.equals(null)){
                        System.out.println("Cadastrado com sucesso!");
                        System.out.println(tempEstacionamento.toString());
                    }
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Obrigado por usar o sistema :) ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
                    operacoes();
                    break;
            }
        }while(operacao !=5);
        escanear.close();
    }

}