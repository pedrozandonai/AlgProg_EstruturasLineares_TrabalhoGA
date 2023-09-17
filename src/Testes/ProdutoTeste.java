package Testes;

import models.Data;
import models.Produto;

import java.util.Scanner;

public class ProdutoTeste {
    public static void main(String[] args) {
        System.out.println("Teste da classe Produto!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        Double precoProduto = scanner.nextDouble();
        System.out.print("Digite o dia do vencimento do produto: ");
        int diaValidade = scanner.nextInt();
        System.out.print("Digite o mês do vencimento do produto: ");
        int mesValidade = scanner.nextInt();
        System.out.print("Digite o ano de vencimento do produto: ");
        int anoValidade = scanner.nextInt();
        Data dataValidadeProduto = new Data(diaValidade, mesValidade, anoValidade);

        System.out.println("Criando produto...");

        Produto produto = new Produto(nomeProduto, precoProduto, dataValidadeProduto);

        System.out.println("Produto criado! Executando método \"estaVendido\"...");
        System.out.println("1 - Inserir data de vencimento teste");
        System.out.println("2 - Deixar o programa escolher");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 1){
            System.out.print("Digite o dia: ");
            int diaTeste = scanner.nextInt();
            System.out.print("Digite o mês: ");
            int mesTeste = scanner.nextInt();
            System.out.print("Digite o ano: ");
            int anoTeste = scanner.nextInt();
            Data dataTeste = new Data(diaTeste, mesTeste, anoTeste);
            System.out.println("Executando teste...");
            produto.estaVencido(dataTeste);

            System.out.println("Informações de produto: ");
            System.out.println(produto);
        }else {
            Data dataVencida = new Data(31, 12, 01);
            System.out.println("Executando teste com data vencida: " + dataVencida);
            System.out.println(produto.estaVencido(dataVencida));
            Data dataNaValidade = new Data(31, 12, 10000);
            System.out.println("Executando teste com data no Prazo: " + dataNaValidade);
            System.out.println(produto.estaVencido(dataNaValidade));
            System.out.println("Informações de produto: ");
            System.out.println(produto);
        }

    }
}
