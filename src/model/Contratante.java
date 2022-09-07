package model;

public class Contratante {
    private String nomeContratante;
    private double retornoContratante;
    private double valorContratante;

    public Contratante() {
    }

    public Contratante(String nomeContratante, double retornoContratante, double valorContratante) {
        this.nomeContratante = nomeContratante;
        this.retornoContratante = retornoContratante;
        this.valorContratante = valorContratante;
    }

    public String getNomeContratante() {
        return nomeContratante;
    }

    public void setNomeContratante(String nomeContratante) {
        this.nomeContratante = nomeContratante;
    }

    public double getRetornoContratante() {
        return retornoContratante;
    }

    public void setRetornoContratante(int retornoContratante) {
        this.retornoContratante = retornoContratante;
    }

    public double getValorContratante() {
        return valorContratante;
    }

    public void setValorContratante(double valorContratante) {
        this.valorContratante = valorContratante;
    }

    public double calcularValorContrato(int retornoContratante, double valorContratante){
        return retornoContratante * valorContratante;
    }

    @Override
    public String toString() {
        return "Contratante{" +
                "nomeContratante='" + nomeContratante + '\'' +
                ", retornoContratante=" + retornoContratante +
                ", valorContratante=" + valorContratante +
                '}';
    }
}
