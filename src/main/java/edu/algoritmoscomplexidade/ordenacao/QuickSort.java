package edu.algoritmoscomplexidade.ordenacao;

public class QuickSort {

    public static void quickSort(int[] array, int menor, int maior) {

        if(menor < maior){

            int pivoIndex = particao(array, menor, maior);

            quickSort(array, menor, pivoIndex - 1);
            quickSort(array, pivoIndex + 1, maior);

        }

    }

    public static int particao(int[] array, int menor, int maior) {
        int pivo = array[maior];
        int i = (menor - 1);

        for(int j = menor; j < maior; j++) {
            if(array[j] <= pivo) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[maior];
        array[maior] = temp;

        return i + 1;
    }

}
