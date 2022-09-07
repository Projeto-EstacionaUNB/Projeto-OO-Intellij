package model;

import java.time.LocalTime;
import java.util.List;

public class Estacionamento {
    private String nomeEstacionamento;
    private int capacidade;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    private Contratante contratato;

    private List<Evento> eventos;

    private List<Acesso> acessoEstacionamento;

    public Estacionamento() {
    }

    public Estacionamento(String nomeEstacionamento, int capacidade, LocalTime horaAbertura, LocalTime horaFechamento, Contratante contratato, List<Evento> eventos, List<Acesso> acessoEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
        this.capacidade = capacidade;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.contratato = contratato;
        this.eventos = eventos;
        this.acessoEstacionamento = acessoEstacionamento;
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Contratante getContratato() {
        return contratato;
    }

    public void setContratato(Contratante contratato) {
        this.contratato = contratato;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Acesso> getAcessoEstacionamento() {
        return acessoEstacionamento;
    }

    public void setAcessoEstacionamento(List<Acesso> acessoEstacionamento) {
        this.acessoEstacionamento = acessoEstacionamento;
    }


    public void pesquisarEstacionamento(){

    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "nomeEstacionamento='" + nomeEstacionamento + '\'' +
                ", capacidade=" + capacidade +
                ", horaAbertura='" + horaAbertura + '\'' +
                ", horaFechamento='" + horaFechamento + '\'' +
                ", contratato=" + contratato +
                ", eventos=" + eventos +
                ", acessoEstacionamento=" + acessoEstacionamento +
                '}';
    }
}
