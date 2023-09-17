package models;

import java.util.Arrays;

public abstract class Loja {
    private String nome;
    private int qntFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data data;
    private Produto estoqueProdutos[];
    public abstract String getTipoLoja();

    public Loja(String nome, int qntFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int quantidade) {
        this.nome = nome;
        this.qntFuncionarios = qntFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.data = data;
        this.estoqueProdutos = new Produto[quantidade];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntFuncionarios() {
        return qntFuncionarios;
    }

    public void setQntFuncionarios(int qntFuncionarios) {
        this.qntFuncionarios = qntFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    @Override
    public String toString() {
        return "Loja: " +
                "\nNome da Loja: " + nome +
                "\nQuantidade de Funcionários: " + qntFuncionarios +
                "\nSalário Base dos funcionários: " +"R$ " +salarioBaseFuncionario +
                "\nEndereço da Loja: " + endereco +
                "\nData de fundação da Loja: " + data +
                "\nQuantidade de produtos em estoque: " + estoqueProdutos.length +
                "\n Produtos em Estoque: " + Arrays.toString(getEstoqueProdutos());
    }

    // Retorna o quanto a loja gasta com o salèario de todos os seus funcionãrios
    public double totalGastosFuncionario(){
        return qntFuncionarios * salarioBaseFuncionario;
    }

    /*
     Retorna "P" caso a loja possua menos de 10 funcionarios
     Retorna "M" caso a loja possua entre 10 (inclusive) e 30 (inclusive)
     Retorna "P" caso a loja possua mais do que 31 funcionarios (inclusive)
     */
    public char tamanhoDaLoja(){
        if (qntFuncionarios < 10){
            return 'P';
        } else if (qntFuncionarios >= 31) {
            return 'G';
        } else {
            return 'M';
        }
    }

    //imprime a informação de todos os produtos da loja.
    public void imprimeProdutos(){
        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] != null){
                System.out.println(estoqueProdutos[i].toString());
            }
        }
    }

    //O método deve retornar verdadeiro caso o produto seja inserido no estoque ou falso caso não seja (no caso de não haver espaço).
    public boolean insereProduto(Produto produto){
        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] == null){
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    //O método retorna verdadeiro caso o produto tenha sido removido e falso caso contrário (caso não haja o produto solicitado no estoque).
    public boolean removeProduto(String nome){
        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nome)){
                estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }

}
