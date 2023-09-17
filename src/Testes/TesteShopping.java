package Testes;

import models.*;

import java.util.Scanner;

public class TesteShopping {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Teste da classe Loja!");

        System.out.print("Digite o nome do Shopping: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o nome da do Shopping: ");
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

        Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        System.out.println("Digite quantas lojas existem no shopping: ");
        int qntLojas = scanner.nextInt();
        scanner.nextLine();


        Shopping shopping = new Shopping(nome, enderecoLoja, qntLojas);

        shopping.setLojas(criadorDeLojas(qntLojas));
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

    public static Loja[] criadorDeLojas(int quantidade){
        Loja[] lojas = new Loja[quantidade];

        for (int i = 0; i < quantidade; i++){
            lojas[i] = criaLoja();
        }

        return lojas;
    }

    public static Loja criaLoja(){
        Loja loja = null;
        System.out.print("Selecione o tipo de loja a ser criado: ");
        System.out.print("1 - Alimentação");
        System.out.print("2 - Informática");
        System.out.print("3 - Vestuário");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome da Loja: ");
        String nomeLoja = scanner.nextLine();

        System.out.print("Digite a quantidade de funcionários da Loja: ");
        int qntFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o salário base dos funcionários da Loja: ");
        double salarioBase = scanner.nextDouble();

        if (opcao == 1){
            Endereco endereco = criaEnderecoLoja();

            System.out.println("Digite a data de CRIAÇÃO da Loja de Alimentação: ");
            Data data = criaData();

            System.out.print("Digite quantos produtos a loja tem em estoque: ");
            int qntProdutos = scanner.nextInt();

            System.out.println("Digite a data do ALVARÁ da Loja de Alimentação: ");
            Data dataAlvara = criaData();

            loja = new Alimentacao(nomeLoja, qntFuncionarios, salarioBase, endereco, data, qntProdutos, dataAlvara);
            criaTodosProdutos(loja);
        } else if (opcao == 2) {
            Endereco endereco = criaEnderecoLoja();

            System.out.println("Digite a data de CRIAÇÃO da Loja de Informática: ");
            Data data = criaData();

            System.out.print("Digite quantos produtos a loja tem em estoque: ");
            int qntProdutos = scanner.nextInt();

            System.out.println("Digite o valor do seguro que a Loja de Informática paga mensalmente: ");
            double seguro = scanner.nextDouble();

            loja = new Informatica(nomeLoja, qntFuncionarios, salarioBase, endereco, data, qntProdutos, seguro);
            criaTodosProdutos(loja);
        } else if (opcao == 3) {
            Endereco endereco = criaEnderecoLoja();

            System.out.println("Digite a data de CRIAÇÃO da Loja de Informática: ");
            Data data = criaData();

            System.out.print("Digite quantos produtos a loja tem em estoque: ");
            int qntProdutos = scanner.nextInt();

            System.out.println("Digite se a loja vende produtos importados (s/n): ");
            String produtosImportados = scanner.nextLine();

            boolean result = false;

            if (produtosImportados.equalsIgnoreCase("s")){result = true;}

            loja = new Vestuario(nomeLoja, qntFuncionarios, salarioBase, endereco, data, qntProdutos, result);
            criaTodosProdutos(loja);
        }else {
            System.out.println("Opção não reconhecida pelo programa");
        }

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
