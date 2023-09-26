import models.*;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Menu();
    }
    public static int lerInt(String texto){
        int x;
        Scanner ler = new Scanner(System.in);
        System.out.println(texto);
        try {
            x = ler.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Erro, tente digitar um número");
            x = lerInt("Digite um valor valido");
        }
        return x;
    }
    public static double lerDouble(String texto){
        double x;
        Scanner ler = new Scanner(System.in);
        System.out.println(texto);
        try{
            x = ler.nextDouble();
        }catch (InputMismatchException e){
            x = lerDouble("Erro, digite um número válido");
        }
        return x;
    }
    public static String lerString(String texto){
        System.out.println(texto);
        Scanner ler = new Scanner(System.in);
        return ler.next();
    }
    public static Produto criaProduto(){
        return new Produto(lerString("Digite o nome do Produto:"),
                                lerDouble("Digite o valor do Produto:"),
                                new Data(lerInt("Digite o dia da Validade:"),
                                         lerInt("Digite o mês da Validade:"),
                                         lerInt("Digite o ano da Validade:")));
    }
    public static Loja criaLoja(){
        int dia = lerInt("Diga o dia da fundação da loja:");
        int mes = lerInt("Diga o mes(em numero) que foi fundada a loja:");
        int ano = lerInt("Diga o ano em que foi fundada a loja:");

        Endereco onde = new Endereco(
                lerString("Diga a rua da loja:"),
                lerString("Diga a cidade da loja:"),
                lerString("Diga o estado da loja:"),
                lerString("Diga o País da loja:"),
                lerString("Diga o CEP da loja:"),
                lerString("Diga o número da loja:"),
                lerString("Diga o complemento da loja:"));

        int op = 0;
        while (op<1 || op > 3){
            op = lerInt("""
                    Escolha o tipo de loja que deseja criar:
                    1 - Alimentação
                    2 - Informática
                    3 - Vestuário
                    """);
        }
        return switch (op) {
            case 1 -> new Alimentacao(
                    lerString("Diga o nome da loja:"),
                    lerInt("Diga a quantidade de funcionários:"),
                    lerDouble("Diga a base salarial dos funcionários:"),
                    onde,
                    new Data(dia, mes, ano),
                    lerInt("Diga a quantidade de espaço no estoque: "),
                    new Data(
                            lerInt("Diga o dia que recebeu o alvará:"),
                            lerInt("Diga o mes que recebeu o alvará:"),
                            lerInt("Diga o ano que recebeu o alvará:")));
            case 2 -> new Informatica(
                    lerString("Diga o nome da loja:"),
                    lerInt("Diga a quantidade de funcionários:"),
                    lerDouble("Diga a base salarial dos funcionários:"),
                    onde,
                    new Data(dia, mes, ano),
                    lerInt("Diga a quantidade de espaço no estoque: "),
                    lerDouble("Diga o valor do seguro de eletrônicos: ")
            );
            case 3 -> new Vestuario(
                    lerString("Diga o nome da loja:"),
                    lerInt("Diga a quantidade de funcionários:"),
                    lerDouble("Diga a base salarial dos funcionários:"),
                    onde,
                    new Data(dia, mes, ano),
                    lerInt("Diga a quantidade de espaço no estoque: "),
                    lerString("Os produtos são importados ?").equalsIgnoreCase("sim")
            );
            default -> null;
        };
    }
    public static Shopping criaShopping(){
        String nome = lerString("Diga o nome do Shopping: ");

        int lojas = lerInt("Diga a quantidade de lojas: ");

        Endereco onde = new Endereco(
                lerString("Diga a rua do Shopping:"),
                lerString("Diga a cidade da Shopping:"),
                lerString("Diga o estado da Shopping:"),
                lerString("Diga o País da Shopping:"),
                lerString("Diga o CEP da Shopping:"),
                lerString("Diga o número da Shopping:"),
                lerString("Diga o complemento da Shopping:"));

        return new Shopping(nome, onde, lojas);
    }
    public static void Menu(){
        Calendar atual = Calendar.getInstance();
        int dia = atual.get(Calendar.DAY_OF_MONTH);
        int mes = 1+atual.get(Calendar.MONTH);
        int ano = atual.get(Calendar.YEAR);
        Data hoje = new Data(dia,mes,ano);

        System.out.println(dia);
        System.out.println(mes);
        System.out.println(ano);

        int select = 777;

        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Loja> lojas = new ArrayList<>();
        ArrayList<Shopping> shoppings = new ArrayList<>();


        while (select != 0){
            System.out.println("""
                    ------------------------------ Menu ------------------------------
                    O que você deseja fazer?
                    
                    1 - criar Shopping
                    2 - criar uma Loja
                    3 - criar Produtos para a Loja
                    4 - remover um Produto
                    5 - remover uma Loja
                    6 - verificar vencimento de Produto
                    7 - imprimir quantidade de Lojas por tipo
                    8 - imprimir Loja com seguro mais caro
                    9 - imprimir dados de uma Loja específica informada pelo usuário
                    incluindo Produtos
                    10 - imprimir dados do Shopping
                    11 - imprimir os gastos com salário de uma Loja específica informada
                    pelo usuário
                    0 - sair
                    
                    """);
            select = lerInt("Digite o número da operação que deseja realizar: ");

            while (select < 0 || select > 11){
                select = lerInt("Digite o número da operação que deseja realizar: ");
                if (select < 0 || select > 11)
                    System.out.println("Digite um valor valido!");
            }
            switch (select){
                case 1:
                    shoppings.add(criaShopping());
                    break;
                case 2:
                    if (!shoppings.isEmpty()){
                        int op = 1-lerInt("Para qual shopping deseja criar essa loja? opções 1 até " + shoppings.size());
                        while (op<0 || op>shoppings.size()){
                            System.out.println("Opção invalida tente de novo");
                            op = 1-lerInt("Para qual shopping deseja criar essa loja? opções 1 até " + shoppings.size());
                        }
                        Loja loja = criaLoja();
                        shoppings.get(op).insereLoja(loja);
                        lojas.add(loja);
                        System.out.println("Loja criada e adicionada no shopping e na lista de lojas");
                    }else {
                        System.out.println("Não ha shoppings para criar lojas :(");
                    }
                    break;
                case 3:
                    if (!shoppings.isEmpty()){
                        int op = 1-lerInt("Para qual shopping deseja selecionar a loja? opções 1 até " + shoppings.size());
                        while (op<0 || op>shoppings.size()){
                            System.out.println("Opção invalida tente de novo");
                            op = 1-lerInt("Para qual shopping deseja selecionar a loja? opções 1 até " + shoppings.size());
                        }
                        int loja = 1-lerInt("Selecione a loja que deseja criar o produto: opções de 1 até " + shoppings.get(op).getLojas().length);
                        while (loja<0 || loja>shoppings.get(op).getLojas().length){
                            System.out.println("Opção invalida tente de novo");
                            loja = 1-lerInt("Selecione a loja que deseja criar o produto: opções de 1 até " + shoppings.get(op).getLojas().length);
                        }
                        Produto produto = criaProduto();
                        shoppings.get(op).getLojas()[loja].insereProduto(produto);
                        produtos.add(produto);
                    }else {
                        System.out.println("Não ha shoppings para criar produtos :(");
                    }
                    break;
                case 4:
                    int sel = lerInt("""
                            Você deseja remover o Produto de onde?
                            1 - De uma loja em um shopping
                            2 - De uma loja criada
                            3 - De uma lista de Produtos
                            """);
                    while (sel < 1 || sel > 3) {
                        sel = lerInt("""
                            Opção invalida, por favor digite uma das 3 opções
                                                        
                            Você deseja remover o Produto de onde?
                            1 - De uma loja em um shopping
                            2 - De uma loja criada
                            3 - De uma lista de Produtos
                            """);
                    }

                    switch (sel){
                        case 1:
                            if (!shoppings.isEmpty()){
                                int x = 1-lerInt("Selecione o Shopping - Opções: 1 até " + shoppings.size());
                                while (x < 0  || x > shoppings.size()){
                                    x = 1-lerInt("Opção invalida, Selecione o Shopping - Opções: 1 até " + shoppings.size());
                                }
                                //Deus me ajuda
                                int y = 1-lerInt("Selecione uma loja - Opções: 1 até " + shoppings.get(x).getLojas().length);
                                while (y<0 || y>shoppings.get(x).getLojas().length){
                                    y = 1-lerInt("Opção invalida, Por favor selecione uma loja - Opções: 1 até " + shoppings.get(x).getLojas().length);
                                }
                                boolean fez = shoppings.get(x).getLojas()[y].removeProduto(lerString("Diga o nome do produto que quer remover: "));
                                System.out.println(fez?"Produto removido":"Produto não encontrado");
                            }else {
                                System.out.println("Não tem shoppings :( ");
                            }
                            break;
                        case 2:
                            if (!lojas.isEmpty()){
                                int x = 1-lerInt("Selecione uma Loja - Opções: 1 até " + lojas.size());
                                while (x<0 || x> lojas.size()){
                                    x = 1-lerInt("Opção invalida, por favor selecione uma Loja - Opções: 1 até " + lojas.size());
                                }
                                boolean fez = lojas.get(x).removeProduto(lerString("Diga o nome do produto que deseja remover: "));
                                System.out.println(fez?"Produto removido":"Produto não encontrado");
                            } else {
                                System.out.println("Não tem lojas :( ");
                            }
                            break;
                        case 3:
                            if (!produtos.isEmpty()){
                                produtos.remove(1-lerInt("Selecione o produto que deseja remover da lista - Opções: 1 até " + produtos.size()));
                                System.out.println("Produto removido da lista");
                            } else {
                                System.out.println("Não tem produtos na lista :( ");
                            }
                            break;

                    }

                    break;
                case 5:
                    if (shoppings.isEmpty()){
                        System.out.println("Tá vazio");
                    }else {
                        int x = 1-lerInt("Diga de qual shopping que deseja remover a loja: opções 1 até " + shoppings.size());
                        while (x > shoppings.size()|| x<0){
                            x = 1-lerInt("nenhum shopping selecionado, por favor, Diga de qual shopping que deseja remover a loja: opções 1 até " + shoppings.size());
                        }
                        if (shoppings.get(x).removeLoja(lerString("Diga o nome da loja que deseja remover: "))){
                            System.out.println("Loja removida");
                        }else {
                            System.out.println("Loja não encontrada");
                        }
                    }
                    break;
                case 6:
                    int escolha = lerInt("""
                            De onde você deseja verificar o produto?
                            
                            1 - De uma loja em um shopping
                            2 - De uma loja em uma lista de lojas
                            3 - De uma lista de produtos
                            """);
                    while (escolha<1||escolha>3){
                        System.out.println("Opção invalida por favor digite novamente ");
                        escolha = lerInt("""
                            De onde você deseja verificar o produto?
                            
                            1 - De uma loja em um shopping
                            2 - De uma loja em uma lista de lojas
                            3 - De uma lista de produtos
                            """);
                    }
                    switch (escolha){
                        case 1:
                            if (!shoppings.isEmpty()) {
                                int op = 1 - lerInt("Qual shopping? opções de 1 até " + shoppings.size());
                                while (op<0||op> shoppings.size()) {
                                    System.out.println("Opção invalida, por favor escolha uma das opções existentes");
                                    op = 1-lerInt("Qual shopping? opções de 1 até " + shoppings.size());
                                }
                                int loja = 1-lerInt("Escolha a loja que deseja verificar o produto: opções de 1 até " + shoppings.get(op).getLojas().length);
                                while (loja<0||loja>shoppings.get(op).getLojas().length){
                                    System.out.println("Opção invalida selecione novamente!");
                                    loja = 1-lerInt("Escolha a loja que deseja verificar o produto: opções de 1 até " + shoppings.get(op).getLojas().length);
                                }
                                int produto = 1-lerInt("Qual produto deseja verificar: opções de 1 até " + shoppings.get(op).getLojas()[loja].getEstoqueProdutos().length);
                                while (produto<0 || produto> shoppings.get(op).getLojas()[loja].getEstoqueProdutos().length){
                                    System.out.println("Opção invalida por favor selecione de novo");
                                    produto = 1-lerInt("Qual produto deseja verificar: opções de 1 até " + shoppings.get(op).getLojas()[loja].getEstoqueProdutos().length);
                                }
                                boolean isVencido = shoppings.get(op).getLojas()[loja].getEstoqueProdutos()[produto].estaVencido(hoje);
                                System.out.println(  isVencido ? (shoppings.get(op).getLojas()[loja].getEstoqueProdutos()[produto].getNome() + " está vencido") :
                                                                 (shoppings.get(op).getLojas()[loja].getEstoqueProdutos()[produto].getNome() + "não está vencido"));
                            }else {
                                System.out.println("Sem shoppings");
                            }
                            break;
                        case 2:
                            if (!lojas.isEmpty()){
                                int op = 1-lerInt("De qual loja deseja verificar o produto: opções de 1 até " + lojas.size());
                                while (op<0||op>lojas.size()){
                                    System.out.println("Opção invalida, tente de novo");
                                    op = 1-lerInt("De qual loja deseja verificar o produto: opções de 1 até " + lojas.size());
                                }
                                int produto = 1-lerInt("Qual produto deseja verificar: opções de 1 até " + lojas.get(op).getEstoqueProdutos().length);
                                while (produto<0|| produto>lojas.get(op).getEstoqueProdutos().length){
                                    System.out.println("Opção invalida, tente de novo");
                                    produto = 1-lerInt("Qual produto deseja verificar: opções de 1 até " + lojas.get(op).getEstoqueProdutos().length);
                                }
                                boolean isVencido = lojas.get(op).getEstoqueProdutos()[produto].estaVencido(hoje);
                                System.out.println(isVencido?lojas.get(op).getEstoqueProdutos()[produto].getNome() + " está vencido" :
                                                             lojas.get(op).getEstoqueProdutos()[produto].getNome() + "não está vencido");
                            } else {
                                System.out.println("Sem lojas");
                            }
                            break;
                        case 3:
                            if (!produtos.isEmpty()) {
                                int op = 1 - lerInt("Qual produto você deseja conferir? opções de 1 até " + produtos.size());
                                while (op<0||op>produtos.size()){
                                    System.out.println("Opção invalida tente de novo");
                                    op = 1 - lerInt("Qual produto você deseja conferir? opções de 1 até " + produtos.size());
                                }
                                System.out.println(produtos.get(op).estaVencido(hoje)
                                        ? (produtos.get(op).getNome() + " está vencido") : (produtos.get(op).getNome() + " não está vencido"));
                            } else {
                                System.out.println("Lista vazia, crie um produto primeiro");
                            }
                        break;
                    }
                    break;
                case 7:
                    if (shoppings.isEmpty()){
                        System.out.println("Não ha lojas no shopping");
                    }else {
                    int x = lerInt("Diga qual shopping, opções de 1 até " + shoppings.size());
                    while (x > shoppings.size()|| x<0){
                        x = 1-lerInt("Nenhum shopping selecionado, por favor, Diga de qual shopping, opções 1 até " + shoppings.size());
                    }
                    System.out.println(shoppings.get(x).quantidadeLojasPorTipo(lerString("Diga o tipo de loja: ")));}
                    break;
                case 8:
                    if (shoppings.isEmpty()){
                        System.out.println("Não ha lojas no shopping");
                    }else {
                    int y = lerInt("Diga qual shopping, opções de 1 até " + shoppings.size());
                    while (y > shoppings.size()|| y<0){
                        y = 1-lerInt("Nenhum shopping selecionado, por favor, Diga de qual shopping, opções 1 até " + shoppings.size());
                    }
                    System.out.println(shoppings.get(y).lojaSeguroMaisCaro());}
                    break;
                case 9:
                    if (shoppings.isEmpty()){
                        System.out.println("Não ha lojas no shopping");
                    }else {
                    int z = lerInt("Diga qual shopping, opções de 1 até " + shoppings.size());
                    while (z > shoppings.size()|| z<0){
                        z = 1-lerInt("Nenhum shopping selecionado, por favor, Diga de qual shopping, opções 1 até " + shoppings.size());
                    }
                    int loja = lerInt("Diga qual loja deseja imprimir opções de 1 até " + shoppings.get(z).getLojas().length);
                    while (loja<0 || loja>shoppings.get(z).getLojas().length){
                        loja = lerInt("Seleciona uma loja por favor: opções de 1 até " + shoppings.get(z).getLojas().length);
                    }
                    System.out.println(shoppings.get(z).getLojas()[loja].toString());}
                    break;
                case 10:
                    if (shoppings.isEmpty()){
                        System.out.println("Não ha shopping");
                    }else {
                    int a = lerInt("Diga qual shopping, opções de 1 até " + shoppings.size());
                    while (a > shoppings.size()|| a<0){
                        a = 1-lerInt("Nenhum shopping selecionado, por favor, Diga de qual shopping, opções 1 até " + shoppings.size());
                    }
                    System.out.println(shoppings.get(a).toString());}
                    break;
                case 11:
                    if (shoppings.isEmpty()){
                        System.out.println("Não ha lojas no shopping");
                    }else {
                    int b = lerInt("Diga qual shopping, opções de 1 até " + shoppings.size());
                    while (b > shoppings.size()|| b<0){
                        b = 1-lerInt("Nenhum shopping selecionado, por favor, Diga de qual shopping, opções 1 até " + shoppings.size());
                    }
                    int loja1 = lerInt("Diga qual loja deseja imprimir opções de 1 até " + shoppings.get(b).getLojas().length);
                    while (loja1<0 || loja1>shoppings.get(b).getLojas().length){
                        loja1 = lerInt("Seleciona uma loja por favor: opções de 1 até " + shoppings.get(b).getLojas().length);
                    }
                    System.out.println(shoppings.get(b).getLojas()[loja1].totalGastosFuncionario());}
                    break;

            }
        }
    }
}