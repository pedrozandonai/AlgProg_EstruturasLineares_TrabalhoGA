import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Menu();

    }

    public static void Menu(){
        Scanner ler = new Scanner(System.in);
        int select = 777;

        do {
            System.out.println("------------------------------ Menu ------------------------------");
            System.out.println("O que você deseja fazer? ");
            System.out.println( "1 - criar Shopping " +
                                "2 - criar uma Loja\n" +
                                "3 - criar Produtos para a Loja\n" +
                                "4 - remover um Produto\n" +
                                "5 - remover uma Loja\n" +
                                "6 - verificar vencimento de Produto\n" +
                                "7 - imprimir quantidade de Lojas por tipo\n" +
                                "8 - imprimir Loja com seguro mais caro\n" +
                                "9 - imprimir dados de uma Loja específica informada pelo usuário\n" +
                                "incluindo Produtos\n" +
                                "10 - imprimir dados do Shopping\n" +
                                "11 - imprimir os gastos com salário de uma Loja específica informada\n" +
                                "pelo usuário\n" +
                                "0 - sair\n");


            while (select > 11 || select < 0){
                try {
                    System.out.println("Digite a operação que deseja realizar: ");
                    select = ler.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Entrada invalida!");
                    select = -1;
                }
            }

        }while (select!=0);
    }
}