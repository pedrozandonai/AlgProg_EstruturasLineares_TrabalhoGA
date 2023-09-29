package Testes;

import models.*;

import java.util.Scanner;

public class ShoppingTeste {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Teste da classe Shopping!");

        System.out.print("Digite o nome do Shopping: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o nome da rua do Shopping: ");
        String nomeRua = scanner.nextLine();

        System.out.print("Digite o nome da cidade do Shopping: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado do Shopping: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país do Shopping: ");
        String pais = scanner.nextLine();

        System.out.print("Digite o cep do Shopping: ");
        String cep = scanner.nextLine();

        System.out.print("Digite o número do Shopping: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento do Shopping: ");
        String complemento = scanner.nextLine();

        Endereco enderecoShopping = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        System.out.print("Digite quantas lojas existem no shopping: ");
        int qntLojas = scanner.nextInt();
        scanner.nextLine();


        Shopping shopping = new Shopping(nome, enderecoShopping, qntLojas);

        shopping.setLojas(criadorDeLojas(qntLojas, enderecoShopping));

        System.out.println("Crie outra loja a ser adicionada no shopping");
        shopping.insereLoja(criaLoja(enderecoShopping));
        System.out.println(shopping.lojaSeguroMaisCaro());

        System.out.print("Digite o nome da loja que deseja remover do shopping: ");
        String nomeLojaRemover = scanner.nextLine();
        System.out.println(shopping.removeLoja(nomeLojaRemover));

        System.out.print("Digite o tipo da loja que deseja saber a quantidade que existe no shopping: ");
        String lojaPorTipo = scanner.nextLine();
        shopping.quantidadeLojasPorTipo(lojaPorTipo);

        System.out.println(shopping);
    }

    public static Endereco criaEnderecoLoja(){
        System.out.print("Digite o nome da rua da Loja: ");
        String nomeRua = scanner.nextLine();
        nomeRua = scanner.nextLine();

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

        return new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);
    }

    public static Produto criaProdutoLoja(){
        scanner.nextLine();

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

        return new Produto(nomeProduto, precoProduto, dataValidadeProduto);
    }

    public static Produto[] criaTodosProdutos(Loja loja){
        int quantidade = loja.getEstoqueProdutos().length;

        Produto[] produtos = new Produto[quantidade];

        for (int i = 0; i < quantidade; i++){
            produtos[i] = criaProdutoLoja();
        }

        loja.setEstoqueProdutos(produtos);

        return produtos;
    }

    public static Loja[] criadorDeLojas(int quantidade, Endereco enderecoShopping){
        Loja[] lojas = new Loja[quantidade];

        for (int i = 0; i < quantidade; i++){
            lojas[i] = criaLoja(enderecoShopping);
        }

        return lojas;
    }

    public static Loja criaLoja(Endereco enderecoShopping){
        Loja loja = null;
        System.out.println("Selecione o tipo de loja a ser criado: ");
        System.out.println("1 - Alimentação");
        System.out.println("2 - Informática");
        System.out.println("3 - Vestuário");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome da Loja: ");
        String nomeLoja = scanner.nextLine();

        System.out.print("Digite a quantidade de funcionários da Loja: ");
        int qntFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o salário base dos funcionários da Loja: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Digite quantos produtos a loja tem em estoque: ");
        int qntProdutos = scanner.nextInt();

        if (opcao == 1){
            System.out.println("Digite a data de CRIAÇÃO da Loja de Alimentação: ");
            Data data = criaData();

            System.out.println("Digite a data do ALVARÁ da Loja de Alimentação: ");
            Data dataAlvara = criaData();

            loja = new Alimentacao(nomeLoja, qntFuncionarios, salarioBase, enderecoShopping, data, qntProdutos, dataAlvara);
        } else if (opcao == 2) {
            System.out.println("Digite a data de CRIAÇÃO da Loja de Informática: ");
            Data data = criaData();

            System.out.println("Digite o valor do seguro que a Loja de Informática paga mensalmente: ");
            double seguro = scanner.nextDouble();

            loja = new Informatica(nomeLoja, qntFuncionarios, salarioBase, enderecoShopping, data, qntProdutos, seguro);
        } else if (opcao == 3) {
            System.out.println("Digite a data de CRIAÇÃO da Loja de Informática: ");
            Data data = criaData();

            System.out.println("Digite se a loja vende produtos importados (s/n): ");
            String produtosImportados = scanner.nextLine();

            boolean result = false;

            if (produtosImportados.equalsIgnoreCase("s")){result = true;}

            loja = new Vestuario(nomeLoja, qntFuncionarios, salarioBase, enderecoShopping, data, qntProdutos, result);
        }else {
            System.out.println("Opção não reconhecida pelo programa");
        }

        Produto[] produtos = criaTodosProdutos(loja);

        return loja;
    }

    public static Data criaData(){
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();

        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();

        return new Data(dia, mes, ano);
    }
}
