package Testes;

import models.*;

import java.util.Scanner;

public class InformaticaTeste {
    public static void main(String[] args) {
        teste();
    }

    public static void teste(){
        System.out.println("Teste da classe Informatica!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da Loja de Informatica: ");
        String nomeLoja = scanner.nextLine();

        System.out.print("Digite a quantidade de funcionários da Loja de Informatica: ");
        int qntFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o salário base dos funcionários da Loja de Informatica: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Digite o valor do seguro dos aparelhos eletronicos da loja: ");
        double seguroEletronicos = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome da rua da Loja de Informatica: ");
        String nomeRua = scanner.nextLine();

        System.out.print("Digite o nome da cidade da Loja de Informatica: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado da Loja de Informatica: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país da Loja de Informatica: ");
        String pais = scanner.nextLine();

        System.out.print("Digite o cep da Loja de Informatica: ");
        String cep = scanner.nextLine();

        System.out.print("Digite o número da Loja de Informatica: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento da Loja de Informatica: ");
        String complemento = scanner.nextLine();

        Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        System.out.print("Digite o dia da fundação da Loja de Informatica: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o mês da fundação da Loja de Informatica: ");
        int mes = scanner.nextInt();

        System.out.print("Digite o ano da fundação da Loja de Informatica: ");
        int ano = scanner.nextInt();

        Data fundacaoLoja = new Data(dia, mes, ano);

        System.out.print("Digite a quantidade de itens que deseja ter em estoque");
        int estoqueQnt = scanner.nextInt();
        scanner.nextLine();

        Loja loja = new Informatica(nomeLoja, qntFuncionarios, salarioBase, enderecoLoja, fundacaoLoja, estoqueQnt,seguroEletronicos) {
        };

        System.out.println("Testando método \"insereProduto\":");
        System.out.println("Digite os itens que deseja adicionar no estoque: ");
        for (int i = 0; i < loja.getEstoqueProdutos().length; i++){
            System.out.println("Produto " + (i+1));

            System.out.print("Nome do Produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Preço do Produto: ");
            double precoProduto = scanner.nextDouble();

            System.out.print("Digite o dia da validade do Produto: ");
            int diaValidade = scanner.nextInt();

            System.out.print("Digite o mês da validade do Produto: ");
            int mesValidade = scanner.nextInt();

            System.out.print("Digite o ano da validade do Produto: ");
            int anoValidade = scanner.nextInt();
            scanner.nextLine();

            Data dataValidadeProduto = new Data(diaValidade, mesValidade, anoValidade);

            Produto produto = new Produto(nomeProduto, precoProduto, dataValidadeProduto);
            System.out.println(loja.insereProduto(produto));
        }

        System.out.println("Testando método \"removeProduto\":");
        System.out.print("Digite o nome do produto que deseja remover: ");
        String produtoARemover = scanner.nextLine();
        System.out.println(loja.removeProduto(produtoARemover));

        System.out.println("Testando método \"totalGastosFuncionarios\":");
        System.out.println(loja.totalGastosFuncionario());

        System.out.println("Testando método \"tamanhoDaLoja\"");
        System.out.println(loja.tamanhoDaLoja());

        System.out.println("Informações da Loja de vestuario: ");
        System.out.println(loja);
    }
}
