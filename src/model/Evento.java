package model;

public class Evento {

    private String nomeEvento;
    private double valorEvento;
    private String dataEvento;
    private String horaAberturaEvento;
    private String horaFechamentoEvento;

    public Evento() {
    }

    public Evento(String nomeEvento, double valorEvento, String dataEvento, String horaAberturaEvento, String horaFechamentoEvento) {
        this.nomeEvento = nomeEvento;
        this.valorEvento = valorEvento;
        this.dataEvento = dataEvento;
        this.horaAberturaEvento = horaAberturaEvento;
        this.horaFechamentoEvento = horaFechamentoEvento;
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

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoraAberturaEvento() {
        return horaAberturaEvento;
    }

    public void setHoraAberturaEvento(String horaAberturaEvento) {
        this.horaAberturaEvento = horaAberturaEvento;
    }

    public String getHoraFechamentoEvento() {
        return horaFechamentoEvento;
    }

    public void setHoraFechamentoEvento(String horaFechamentoEvento) {
        this.horaFechamentoEvento = horaFechamentoEvento;
    }
}
