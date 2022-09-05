package model;

public class Tempo extends Acesso {
    private double valorFracao;
    private int desconto;

    public Tempo() {
    }

    public Tempo(String horaEntrada, String horaSaida, String dataInicial, String dataFinal, Veiculo veiculoCliente, double valorFracao, int desconto) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorFracao = valorFracao;
        this.desconto = desconto;
    }

    public double getValorFracao() {
        return valorFracao;
    }

    public void setValorFracao(double valorFracao) {
        this.valorFracao = valorFracao;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    // Alterar para o calculo certo, passar a atividade para o Danilo ou o Paulo
    public double calculaValorAcesso(String horaEntrada, String horaSaida, String dataInicial, String dataFinal, Veiculo veiculoCliente, double valorFracao, int desconto) {
        return 0;
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
