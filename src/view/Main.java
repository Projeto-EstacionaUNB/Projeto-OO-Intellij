package view;

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

        int operacao = escanear.nextInt();

        switch (operacao){

            case 1:

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
        escanear.close();
    }

}