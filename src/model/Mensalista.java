package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Mensalista extends Acesso{
    private double valorMensalista;
    private List<String> acessosMensais;

    public Mensalista() {
    }

    public Mensalista(LocalTime horaEntrada, LocalTime horaSaida, LocalDate dataInicial, LocalDate dataFinal, Veiculo veiculoCliente, double valorMensalista, List<String> acessosMensais) {
        super(horaEntrada, horaSaida, dataInicial, dataFinal, veiculoCliente);
        this.valorMensalista = valorMensalista;
        this.acessosMensais = acessosMensais;
    }

    public double getValorMensalista() {
        return valorMensalista;
    }

    public void setValorMensalista(double valorMensalista) {
        this.valorMensalista = valorMensalista;
    }

    public List<String> getAcessosMensais() {
        return acessosMensais;
    }

    public void setAcessosMensais(List<String> acessosMensais) {
        this.acessosMensais = acessosMensais;
    }


    // Verificar Correção

    @Override
    public double calculaValorAcesso() {
        return 0;
    }

    @Override
    public String toString() {
        return "Mensalista{" +
                "valorMensalista=" + valorMensalista +
                ", acessosMensais=" + acessosMensais +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }
}