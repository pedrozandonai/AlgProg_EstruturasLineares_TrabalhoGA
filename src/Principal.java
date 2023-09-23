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
                    lojas.add(criaLoja());
                    break;
                case 3:
                    produtos.add(criaProduto());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    if (!produtos.isEmpty()) {
                        if (lerInt("Você deseja verificar algum produto ja criado? 1-sim ") == 1) {
                            int op = 1 - lerInt("Qual produto você deseja conferir? opções de 1 até " + produtos.size());
                            System.out.println(produtos.get(op).estaVencido(new Data(dia, mes, ano))
                                    ? (produtos.get(op).getNome() + " está vencido") : (produtos.get(op).getNome() + " não está vencido"));
                        }else {
                            if (lerInt("Deseja criar um produto ? 1 - sim") == 1){
                                produtos.add(criaProduto());
                            }
                        }
                        break;
                    }
                    if (lerInt("Nenhum produto encontrado :( \nDeseja criar um produto ?  1 - sim") == 1){
                        produtos.add(criaProduto());
                        System.out.println(produtos.get(0).estaVencido(new Data(dia, mes, ano))
                                ?(produtos.get(0).getNome()+" está vencido"):(produtos.get(0).getNome()+" não está vencido"));
                    }
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;

            }
        }
    }
}