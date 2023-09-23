package models;

import java.util.Calendar;

public class Produto {
    private String nome;
    private double preco;
    private Data dataDeValidade;

    public Produto(String nome, double preco, Data dataDeValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataDeValidade = dataDeValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Data dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        return  "\nNome do Produto: " + nome +
                "\nPreço do Produto: " + preco +
                "\nData de Validade do Produto: " + dataDeValidade;
    }

    // Verifica se o produto está vencido ou não com base na data atual fornecida como parâmetro
    public boolean estaVencido(Data dataAtual) {
        Calendar dataValidade = Calendar.getInstance();
        dataValidade.set(dataDeValidade.getAno(), dataDeValidade.getMes() - 1, dataDeValidade.getDia());

        Calendar dataAtualCalendar = Calendar.getInstance();
        dataAtualCalendar.set(dataAtual.getAno(), dataAtual.getMes() - 1, dataAtual.getDia());

        return dataValidade.before(dataAtualCalendar);
    }
}
