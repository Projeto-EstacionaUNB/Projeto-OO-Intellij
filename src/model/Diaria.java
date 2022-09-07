package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Diaria extends Acesso {
    private double valorDiaria;

    public Diaria() {
    }


    public Diaria(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorDiaria) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorDiaria = valorDiaria;
    }

    public Diaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }


    // Verificar a correção
    @Override
    public double calcularValorAcesso() {
        return 0;

    }

    @Override
    public String toString() {
        return "Diaria{" +
                "valorDiaria=" + valorDiaria +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}
