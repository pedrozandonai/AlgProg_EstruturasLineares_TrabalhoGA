import models.Data;
import models.Loja;
import models.Produto;
import models.Shopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public static void Menu(){
        Date atual = new Date();
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
                    break;
                case 2:
                    break;
                case 3:
                    produtos.add(criaProduto());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    if (!produtos.isEmpty()){
                        if (lerInt("Você deseja verificar algum produto ja criado? 1-sim ") == 1){
                            int op = 1-lerInt("Qual produto você deseja conferir? opções de 1 até " + produtos.size());
                            System.out.println(produtos.get(op).estaVencido(new Data(atual.getDate(), atual.getMonth(), atual.getYear()))
                            ?(produtos.get(op).getNome()+" está vencido"):(produtos.get(op).getNome()+"não está vencido"));
                        }
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