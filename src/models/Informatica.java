package models;

public class Informatica extends Loja{
    //representa um seguro que lojas que vendem aparelhos eletrônicos devem pagar mensalmente.
    private double seguroEletronicos;

    public Informatica(String nome, int qntFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int quantidade, double seguroEletronicos) {
        super(nome, qntFuncionarios, salarioBaseFuncionario, endereco, data, quantidade);
        this.seguroEletronicos = seguroEletronicos;
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Seguro dos Eletrônicos: " + seguroEletronicos;
    }

    @Override
    public String getTipoLoja() {
        return "Informática";
    }
}
