package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Tempo extends Acesso {
    private double valorFracao;
    private double desconto;

    public Tempo() {
    }

    public Tempo(double valorFracao) {
    }

    public Tempo(double valorFracao, double desconto) {
        this.valorFracao = valorFracao;
        this.desconto = desconto;
    }

    public Tempo(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorFracao, double desconto) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorFracao = valorFracao;
        this.desconto = desconto;
    }

    public Tempo(double valorFracao, String desconto) {
    }

    public Tempo(String valorFracao) {
    }


    public double getValorFracao() {
        return valorFracao;
    }

    public void setValorFracao(double valorFracao) {
        this.valorFracao = valorFracao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }


    public double calcularValorAcesso(long minutos) {
        return Math.ceil(minutos / 15) * valorFracao;
    }

    public double calcularValorAcesso(long horas, long minutos) {
        return Math.ceil((horas * 60) / 15) * valorFracao + Math.ceil(minutos / 15) * valorFracao;
    }

    @Override
    public String toString() {
        return "Tempo{" +
                "valorFracao=" + valorFracao +
                ", desconto=" + desconto +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}
