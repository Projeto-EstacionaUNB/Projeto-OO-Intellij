package model;

public class DiariaNoturna extends Diaria{
    private int percentualDiaria;

    public DiariaNoturna() {
    }

    public DiariaNoturna(String horaEntrada, String horaSaida, String dataInicial, String dataFinal, Veiculo veiculoCliente, double valorDiaria, int percentualDiaria) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente, valorDiaria);
        this.percentualDiaria = percentualDiaria;
    }

    public int getPercentualDiaria() {
        return percentualDiaria;
    }

    public void setPercentualDiaria(int percentualDiaria) {
        this.percentualDiaria = percentualDiaria;
    }

    // Verificar a correção
    @Override
    public double calculaValorAcesso() {
        return 0;
    }

    @Override
    public String toString() {
        return "DiariaNoturna{" +
                "percentualDiaria=" + percentualDiaria +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }

}
