package model;

import java.util.List;

public class Estacionamento {
    private int capacidade;
    private String horaAbertura;
    private String horaFechamento;

    private Contratante contratato;

    private List<Acesso> acessoEstacionamento;

    public Estacionamento() {
    }

    public Estacionamento(int capacidade, String horaAbertura, String horaFechamento, Contratante contratato, List<Acesso> acessoEstacionamento) {
        this.capacidade = capacidade;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.contratato = contratato;
        this.acessoEstacionamento = acessoEstacionamento;
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
                "capacidade=" + capacidade +
                ", horaAbertura='" + horaAbertura + '\'' +
                ", horaFechamento='" + horaFechamento + '\'' +
                ", contratato=" + contratato +
                '}';
    }
}
