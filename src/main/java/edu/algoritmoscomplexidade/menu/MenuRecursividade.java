package edu.algoritmoscomplexidade.menu;
import edu.algoritmoscomplexidade.recursividade.BuscaBinaria;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuRecursividade {

    private Scanner scanner;

    public MenuRecursividade(Scanner scanner) {

        this.scanner = scanner;

    }

    public void exibir() {

        int opcao;

        do{

            System.out.println("== Recursividade ==");
            System.out.println("1. Busca Binária");
            System.out.println("2. Nrainhas");
            System.out.println("0. Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuBuscaBinaria();
                    break;
                case 2:
                    System.out.println("Em construção.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        }while(true);

    }

    private void menuBuscaBinaria() {

        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite números inteiros em ordem crescente. Digite 'pronto' para finalizar o processo: ");

        while(true) {

            System.out.println("Digite um número ou 'pronto' para finalizar: ");
            String input = scanner.next();

            if(input.equalsIgnoreCase("pronto")) {
                break;
            }

            try {
                int numero = Integer.parseInt(input);
                numeros.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! tente novamente.");
            }

        }

        int[] array = numeros.stream().mapToInt(i -> i).toArray();

        System.out.println("Digite o número que deseja buscar: ");
        int valor = scanner.nextInt();

        BuscaBinaria.buscaBinaria(array, 0, array.length - 1, valor, 1);

    }

}
