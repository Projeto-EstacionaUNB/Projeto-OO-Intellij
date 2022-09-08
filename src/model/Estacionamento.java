package model;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Estacionamento {
    private String nomeEstacionamento;
    private int capacidade;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    private Contratante contratato;

    private Diaria diariaDiurna;
    private DiariaNoturna diariaNoturna;
    private Mensalista mensalistaPreco;
    private Tempo diariaTempo;
    private Tempo diariaFracao;

    private List<Evento> eventos;

    private List<Acesso> acessoEstacionamento;

    private List<Veiculo> listaAssociados;



    public Estacionamento() {
    }

    public Estacionamento(String nomeEstacionamento, int capacidade, LocalTime horaAbertura, LocalTime horaFechamento, Contratante contratato, Diaria diariaDiurna, DiariaNoturna diariaNoturna, Mensalista mensalistaPreco, Tempo diariaTempo, Tempo diariaFracao, List<Evento> eventos, List<Acesso> acessoEstacionamento, List<Veiculo> listaAssociados) {
        this.nomeEstacionamento = nomeEstacionamento;
        this.capacidade = capacidade;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.contratato = contratato;
        this.diariaDiurna = diariaDiurna;
        this.diariaNoturna = diariaNoturna;
        this.mensalistaPreco = mensalistaPreco;
        this.diariaTempo = diariaTempo;
        this.diariaFracao = diariaFracao;
        this.eventos = eventos;
        this.acessoEstacionamento = acessoEstacionamento;
        this.listaAssociados = listaAssociados;
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

    public List<Veiculo> getListaAssociados() {
        return listaAssociados;
    }

    public void setListaAssociados(List<Veiculo> listaAssociados) {
        this.listaAssociados = listaAssociados;
    }


    public Diaria getDiariaDiurna() {
        return diariaDiurna;
    }

    public void setDiariaDiurna(Diaria diariaDiurna) {
        this.diariaDiurna = diariaDiurna;
    }

    public DiariaNoturna getDiariaNoturna() {
        return diariaNoturna;
    }

    public void setDiariaNoturna(DiariaNoturna diariaNoturna) {
        this.diariaNoturna = diariaNoturna;
    }

    public Mensalista getMensalistaPreco() {
        return mensalistaPreco;
    }

    public void setMensalistaPreco(Mensalista mensalistaPreco) {
        this.mensalistaPreco = mensalistaPreco;
    }

    public Tempo getDiariaTempo() {
        return diariaTempo;
    }

    public void setDiariaTempo(Tempo diariaTempo) {
        this.diariaTempo = diariaTempo;
    }

    public Tempo getDiariaFracao() {
        return diariaFracao;
    }

    public void setDiariaFracao(Tempo diariaFracao) {
        this.diariaFracao = diariaFracao;
    }

    public boolean pesquisarEstacionamento(String nomePesquisa){
        return nomePesquisa.equals(nomeEstacionamento);
    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "nomeEstacionamento='" + nomeEstacionamento + '\'' +
                ", capacidade=" + capacidade +
                ", horaAbertura=" + horaAbertura +
                ", horaFechamento=" + horaFechamento +
                ", contratato=" + contratato +
                ", diariaDiurna=" + diariaDiurna +
                ", diariaNoturna=" + diariaNoturna +
                ", mensalistaPreco=" + mensalistaPreco +
                ", diariaTempo=" + diariaTempo +
                ", diariaFracao=" + diariaFracao +
                ", eventos=" + eventos +
                ", acessoEstacionamento=" + acessoEstacionamento +
                ", listaAssociados=" + listaAssociados +
                '}';
    }
}
