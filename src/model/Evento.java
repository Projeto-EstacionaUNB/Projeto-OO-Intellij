package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

    private String nomeEvento;
    private double valorEvento;
    private LocalDate dataEvento;
    private LocalTime horaAberturaEvento;
    private LocalTime horaFechamentoEvento;

    public Evento(String nomeEventotemp, String precoEvento, LocalDate parse, LocalTime horaAberturaEvento, LocalTime horaFechamentoEvento) {
    }

    public Evento(String nomeEvento, double valorEvento, LocalDate dataEvento, LocalTime horaAberturaEvento, LocalTime horaFechamentoEvento) {
        this.nomeEvento = nomeEvento;
        this.valorEvento = valorEvento;
        this.dataEvento = dataEvento;
        this.horaAberturaEvento = horaAberturaEvento;
        this.horaFechamentoEvento = horaFechamentoEvento;
    }

    public Evento() {

    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public double getValorEvento() {
        return valorEvento;
    }

    public void setValorEvento(double valorEvento) {
        this.valorEvento = valorEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalTime getHoraAberturaEvento() {
        return horaAberturaEvento;
    }

    public void setHoraAberturaEvento(LocalTime horaAberturaEvento) {
        this.horaAberturaEvento = horaAberturaEvento;
    }

    public LocalTime getHoraFechamentoEvento() {
        return horaFechamentoEvento;
    }

    public void setHoraFechamentoEvento(LocalTime horaFechamentoEvento) {
        this.horaFechamentoEvento = horaFechamentoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nomeEvento='" + nomeEvento + '\'' +
                ", valorEvento=" + valorEvento +
                ", dataEvento=" + dataEvento +
                ", horaAberturaEvento=" + horaAberturaEvento +
                ", horaFechamentoEvento=" + horaFechamentoEvento +
                '}';
    }
}
