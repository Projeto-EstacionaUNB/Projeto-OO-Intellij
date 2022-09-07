package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mensalista extends Acesso{
    private double valorMensalista;

    public Mensalista() {
    }

    public Mensalista(double valorMensalista) {
        this.valorMensalista = valorMensalista;
    }

    public Mensalista(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorMensalista) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorMensalista = valorMensalista;
    }

    public double getValorMensalista() {
        return valorMensalista;
    }

    public void setValorMensalista(double valorMensalista) {
        this.valorMensalista = valorMensalista;
    }

    // Verificar Correção

    @Override
    public double calcularValorAcesso() {
        return 0;
    }

    @Override
    public String toString() {
        return "Mensalista{" +
                "valorMensalista=" + valorMensalista +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}