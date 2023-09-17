package models;

import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja lojas[];

    public Shopping(String nome, Endereco endereco, int quantidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidade];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "Shopping: " +
                "\nNome: " + nome +
                "\nEndereco: " + endereco +
                "\nLojas=" + Arrays.toString(lojas);
    }

    public boolean insereLoja(Loja loja){
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] == null){
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nome){
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] != null && lojas[i].getNome().equals(nome)){
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int quantidade = 0;

        for (int i = 0; i < lojas.length; i++) {
            Loja loja = lojas[i];

            if (loja instanceof Vestuario && tipoLoja.equalsIgnoreCase("Vestuário")) {
                quantidade++;
            } else if (loja instanceof Informatica && tipoLoja.equalsIgnoreCase("Informática")) {
                quantidade++;
            } else if (loja instanceof Alimentacao && tipoLoja.equalsIgnoreCase("Alimentação")) {
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return -1;
        } else {
            return quantidade;
        }
    }

    public Loja lojaSeguroMaisCaro(){
        Loja lojaMaisCara = null;
        double valorMaisAlto = 0.0;

        for (int i = 0; i < lojas.length; i++){
            Loja loja = lojas[i];

            if (loja instanceof Informatica){
                Informatica lojaInformatica = (Informatica) loja;
                double valorSeguro = lojaInformatica.getSeguroEletronicos();

                if (valorSeguro > valorMaisAlto) {
                    valorMaisAlto = valorSeguro;
                    lojaMaisCara = loja;
                }
            }
        }

        return lojaMaisCara;
    }

}
