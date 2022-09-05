package model;

public class Diaria extends Acesso {
    private double valorDiaria;

    public Diaria() {
    }

    public Diaria(String horaEntrada, String horaSaida, String dataInicial, String dataFinal, Veiculo veiculoCliente, double valorDiaria) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }


    // Verificar a correção
    @Override
    public double calculaValorAcesso() {
        return 0;

    }

    @Override
    public String toString() {
        return "Diaria{" +
                "valorDiaria=" + valorDiaria +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}
