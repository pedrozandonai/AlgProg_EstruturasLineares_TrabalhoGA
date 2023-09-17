package models;

public class Alimentacao extends Loja{
    // indica a data que a loja de alimentação recebeu o alvará de funcionamento.
    private Data dataAlvara;

    public Alimentacao(String nome, int qntFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int quantidade, Data dataAlvara) {
        super(nome, qntFuncionarios, salarioBaseFuncionario, endereco, data, quantidade);
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Alvara da Loja de Alimentação: " + dataAlvara;
    }

    @Override
    public String getTipoLoja() {
        return "Alimentação";
    }
}
