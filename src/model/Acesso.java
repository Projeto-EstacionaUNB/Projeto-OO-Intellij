package model;

public abstract class Acesso {
    protected String horaEntrada;
    protected String horaSaida;
    protected String dataInicial;
    protected String dataFinal;

    protected Veiculo veiculoCliente;

    public Acesso() {
    }

    public Acesso(String horaEntrada, String horaSaida, String dataInicial, String dataFinal, Veiculo veiculoCliente) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.veiculoCliente = veiculoCliente;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Veiculo getVeiculoCliente() {
        return veiculoCliente;
    }

    public void setVeiculoCliente(Veiculo veiculoCliente) {
        this.veiculoCliente = veiculoCliente;
    }

    public double calculaValorAcesso(){
        return 0;
    }

    public void removerAcesso(){

    }

    public void pesquisarAcesso(){

    }

    public void atualizarAcesso(){

    }

    @Override
    public String toString() {
        return "Acesso{" +
                "horaEntrada='" + horaEntrada + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", veiculoCliente=" + veiculoCliente +
                '}';
    }

}
