package Testes;

import models.Data;
import models.Endereco;
import models.Loja;
import models.Produto;

import java.util.Scanner;

public class LojaTeste {
    public static void main(String[] args) {
        System.out.println("Teste da classe Loja!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da Loja: ");
        String nomeLoja = scanner.nextLine();

        System.out.print("Digite a quantidade de funcionários da Loja: ");
        int qntFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o salário base dos funcionários da Loja: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Digite o nome da rua da Loja: ");
        String nomeRua = scanner.nextLine();

        System.out.print("Digite o nome da cidade da Loja: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado da Loja: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país da Loja: ");
        String pais = scanner.nextLine();

        System.out.print("Digite o cep da Loja: ");
        String cep = scanner.nextLine();

        System.out.print("Digite o número da Loja: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento da Loja: ");
        String complemento = scanner.nextLine();

        Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        System.out.print("Digite o dia da fundação da Loja: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o mês da fundação da Loja: ");
        int mes = scanner.nextInt();

        System.out.print("Digite o ano da fundação da Loja: ");
        int ano = scanner.nextInt();

        Data fundacaoLoja = new Data(dia, mes, ano);

        System.out.print("Digite a quantidade de itens que deseja ter em estoque: ");
        int estoqueQnt = scanner.nextInt();
        scanner.nextLine();

        Loja loja = new Loja(nomeLoja, qntFuncionarios, salarioBase, enderecoLoja, fundacaoLoja, estoqueQnt) {
            @Override
            public String getTipoLoja() {
                return "Loja";
            }
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

        System.out.println("Testando método \"imprimeProdutos\":");
        loja.imprimeProdutos();

        System.out.println("Testando método \"totalGastosFuncionarios\":");
        System.out.println(loja.totalGastosFuncionario());

        System.out.println("Testando método \"tamanhoDaLoja\"");
        System.out.println(loja.tamanhoDaLoja());

        System.out.println("Informações da Loja: ");
        System.out.println(loja);
    }
}
