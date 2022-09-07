package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiariaNoturna extends Diaria{
    private int percentualDiaria;

    public DiariaNoturna() {
    }

    public DiariaNoturna(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorDiaria, int percentualDiaria) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente, valorDiaria);
        this.percentualDiaria = percentualDiaria;
    }

    public int getPercentualDiaria() {
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
