package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiariaNoturna extends Diaria{
    private double percentualDiaria;

    public DiariaNoturna() {
    }

    public DiariaNoturna(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorDiaria, double percentualDiaria) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente, valorDiaria);
        this.percentualDiaria = percentualDiaria;
    }

    public DiariaNoturna(double valorDiariaN) {
        this.percentualDiaria = percentualDiaria;
    }

    public double getPercentualDiaria() {
        return percentualDiaria;
    }

    public void setPercentualDiaria(int percentualDiaria) {
        this.percentualDiaria = percentualDiaria;
    }

    // Verificar a correção
    public double calcularValorAcesso(double valorDiaria) {
        return (1.00 - percentualDiaria)* valorDiaria;
    }

    @Override
    public String toString() {
        return "DiariaNoturna{" +
                "percentualDiaria=" + percentualDiaria +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }

}
