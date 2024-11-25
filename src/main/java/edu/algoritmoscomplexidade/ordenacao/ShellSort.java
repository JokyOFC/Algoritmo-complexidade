package edu.algoritmoscomplexidade.ordenacao;

public class ShellSort {

    public static int[] shellSort(int[] array) {

        int n = array.length;

        for(int intervalo = n/2; intervalo > 0; intervalo/=2) {
            for(int i = intervalo; i < n; i++) {
                int temp = array[i];

                int j;
                for(j = i; j >= intervalo && array[j - intervalo] > temp; j -= intervalo) {
                    array[j] = array[j - intervalo];
                }

                array[j] = temp;
            }
        }

        return array;

    }

}
