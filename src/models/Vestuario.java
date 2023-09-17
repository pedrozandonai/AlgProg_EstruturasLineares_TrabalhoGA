package models;

public class Vestuario extends Loja{
    // indica se a loja de vestuário vende roupas importadas ou não.
    private boolean produtosImportados;

    public Vestuario(String nome, int qntFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int quantidade, boolean produtosImportados) {
        super(nome, qntFuncionarios, salarioBaseFuncionario, endereco, data, quantidade);
        this.produtosImportados = produtosImportados;
    }

    public boolean isProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Produtos Importados: " + produtosImportados;
    }

    @Override
    public String getTipoLoja() {
        return "Vestuário";
    }
}
