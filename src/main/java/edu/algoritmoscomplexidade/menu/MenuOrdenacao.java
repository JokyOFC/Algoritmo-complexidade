package edu.algoritmoscomplexidade.menu;

import edu.algoritmoscomplexidade.ordenacao.MergeSort;
import edu.algoritmoscomplexidade.ordenacao.QuickSort;
import edu.algoritmoscomplexidade.ordenacao.ShellSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOrdenacao {

    private Scanner scanner;

    public MenuOrdenacao(Scanner scanner) {

        this.scanner = scanner;

    }

    public void exibir() {

        int opcao;

        do{

            System.out.println("== Recursividade ==");
            System.out.println("1. MergeSort");
            System.out.println("2. QuickSort");
            System.out.println("3. ShellSort");
            System.out.println("0. Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuMergeSort();
                    break;
                case 2:
                    menuQuickSort();
                    break;
                case 3:
                    menuShellSort();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        }while(true);

    }

    private void menuMergeSort() {

        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite números inteiros. Digite 'pronto' para finalizar o processo: ");

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

        MergeSort.mergeSort(array, 0, array.length - 1);
        System.out.println("Numeros ordenados: ");
        MergeSort.printArray(array);

    }

    private void menuQuickSort() {

        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite números inteiros. Digite 'pronto' para finalizar o processo: ");

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

        QuickSort.quickSort(array, 0, array.length - 1);

        for (int numero : array) {
            System.out.print(numero + " ");
        }

        System.out.print("\n");
    }

    private void menuShellSort() {

        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite números inteiros. Digite 'pronto' para finalizar o processo: ");

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

        ShellSort.shellSort(array);

        for (int numero : array) {
            System.out.print(numero + " ");
        }

        System.out.print("\n");

    }

}
