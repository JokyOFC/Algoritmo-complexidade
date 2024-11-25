package edu.algoritmoscomplexidade.menu;

import edu.algoritmoscomplexidade.arvorebinaria.ArvoreBinaria;
import edu.algoritmoscomplexidade.arvorebinaria.ArvoreBinariaAVL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuArvore {

    private Scanner scanner;


    public MenuArvore(Scanner scanner) {

        this.scanner = scanner;

    }

    public void exibir() {

        int opcao;

        do{

            System.out.println("== Recursividade ==");
            System.out.println("1. Arvore Binaria");
            System.out.println("2. Arvore AVL");
            System.out.println("0. Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuArvoreBinaria();
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

    private void menuArvoreBinaria() {

        ArvoreBinaria arvore = new ArvoreBinaria();

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

        for(int numero : array) {
            arvore.inserir(numero);
        }

        System.out.println("Travessia em ordem (in-order) antes do balanceamento:");
        arvore.emOrdem();

        System.out.println("Travessia pré-ordem (pre-order) antes do balanceamento:");
        arvore.preOrdem();

        System.out.println("Travessia pós-ordem (post-order) antes do balanceamento:");
        arvore.posOrdem();

        // Balancear a árvore
        arvore.balancear();

        System.out.println("\nTravessia em ordem (in-order) após o balanceamento:");
        arvore.emOrdem();

        System.out.println("Travessia pré-ordem (pre-order) após o balanceamento:");
        arvore.preOrdem();

        System.out.println("Travessia pós-ordem (post-order) após o balanceamento:");
        arvore.posOrdem();

        System.out.print("\n");

    }

}
