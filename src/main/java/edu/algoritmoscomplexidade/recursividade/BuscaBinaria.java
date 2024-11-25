package edu.algoritmoscomplexidade.recursividade;

public class BuscaBinaria {

    public static int buscaBinaria(int[] array, int esquerda, int direita, int valor, int etapa) {

        System.out.println("Etapa "+ etapa + ":");
        imprimeArray(array,esquerda,direita, esquerda + (direita - esquerda)/2);

        if(esquerda > direita){
            System.out.println("Elemento não encontrado no array.");
            return -1;
        }

        int meio = esquerda + (direita - esquerda) / 2;

        if(array[meio] == valor){
            System.out.println("Elemento encontrado no índice: " + meio);
            return meio;
        }

        if(array[meio] < valor){
            return buscaBinaria(array, meio + 1, direita, valor, etapa +1);
        } else {
            return buscaBinaria(array, esquerda,meio - 1, valor, etapa + 1);
        }

    }

    public static void imprimeArray(int[] array, int esquerda, int direita, int meio) {
        for(int i = 0; i < array.length; i++){
            if(i < esquerda || i > direita){
                System.out.print(" ");
            } else if(i == meio){
                System.out.printf("[%2d] ", array[i]);
            } else {
                System.out.printf(" %2d  ", array[i]);
            }
        }
        System.out.println();
    }

}
