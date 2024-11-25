package edu.algoritmoscomplexidade.menu;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;


    public MenuPrincipal() {

        scanner = new Scanner(System.in);

    }

    public void exibir() {

        String opcao;

        do {

            System.out.println("== Algoritimos e Complexidade ==");
            System.out.println("1. Recursividade");
            System.out.println("2. Ordenacao");
            System.out.println("3. Arvore Binaria");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    MenuRecursividade menuRecursividade = new MenuRecursividade(scanner);
                    menuRecursividade.exibir();
                    break;
                case "2":
                    MenuOrdenacao menuOrdenacao = new MenuOrdenacao(scanner);
                    menuOrdenacao.exibir();
                    break;
                case "3":
                    MenuArvore menuArvore = new MenuArvore(scanner);
                    menuArvore.exibir();
                    break;
                case "0":
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opcao inválida! Tente novamente.");
                    break;
            }

        }while(!opcao.equals("0"));

    }

}
