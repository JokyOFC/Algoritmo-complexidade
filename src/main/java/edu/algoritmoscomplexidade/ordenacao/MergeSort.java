package edu.algoritmoscomplexidade.ordenacao;

public class MergeSort {

    public static void mergeSort(int[] array, int esquerda, int direita) {

        if(esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);

            merge(array, esquerda, meio, direita);

        }

    }

    public static void merge(int[] array, int esquerda, int meio, int direita) {

        int n1 = meio - esquerda+1;
        int n2 = direita - meio;

        int[] arrayEsquerdo = new int[n1];
        int[] arrayDireita = new int[n2];

        for(int i = 0; i < n1; i++)
            arrayEsquerdo[i] = array[i+esquerda];
        for(int j = 0; j < n2; j++)
            arrayDireita[j] = array[j+meio+1];

        int i = 0, j = 0;
        int k = esquerda;

        while(i < n1 && j < n2) {
            if(arrayEsquerdo[i] < arrayDireita[j]) {
                array[k] = arrayEsquerdo[i];
                i++;
            } else {
                array[k] = arrayDireita[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            array[k] = arrayEsquerdo[i];
            i++;
            k++;
        }

        while(j < n2){
            array[k] = arrayDireita[j];
            j++;
            k++;
        }

    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
