package model;

import java.util.List;

public class Estacionamento {
    private String nomeEstacionamento;
    private int capacidade;
    private String horaAbertura;
    private String horaFechamento;

    private Contratante contratato;

    private List<Evento> eventos;

    private List<Acesso> acessoEstacionamento;

    public Estacionamento() {
    }

    public Estacionamento(String nomeEstacionamento, int capacidade, String horaAbertura, String horaFechamento, Contratante contratato, List<Evento> eventos, List<Acesso> acessoEstacionamento) {
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

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
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
