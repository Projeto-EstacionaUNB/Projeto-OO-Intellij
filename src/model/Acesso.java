package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Acesso {
    protected LocalTime horaEntrada;
    protected LocalTime horaSaida;
    protected LocalDate dataInicial;
    protected LocalDate dataFinal;

    protected Veiculo veiculoCliente;


    public Acesso() {
    }

    public Acesso(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.veiculoCliente = veiculoCliente;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Veiculo getVeiculoCliente() {
        return veiculoCliente;
    }

    public void setVeiculoCliente(Veiculo veiculoCliente) {
        this.veiculoCliente = veiculoCliente;
    }

    public double calculaValorAcesso(){
        return 0;
    }

    public void removerAcesso(){

    }

    public void pesquisarAcesso(){

    }

    public void atualizarAcesso(){

    }

    @Override
    public String toString() {
        return "Acesso{" +
                "horaEntrada=" + horaEntrada +
                ", horaSaida=" + horaSaida +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}
