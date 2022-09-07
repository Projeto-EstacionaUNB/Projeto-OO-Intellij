package model;

public class Diaria extends Acesso {
    private double valorDiaria;

    public Diaria() {
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
