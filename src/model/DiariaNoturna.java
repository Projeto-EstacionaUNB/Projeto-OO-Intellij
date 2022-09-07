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

    public double getPercentualDiaria() {
        return percentualDiaria;
    }

    public void setPercentualDiaria(int percentualDiaria) {
        this.percentualDiaria = percentualDiaria;
    }

    // Verificar a correção
    @Override
    public double calculaValorAcesso() {
        return 0;
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
