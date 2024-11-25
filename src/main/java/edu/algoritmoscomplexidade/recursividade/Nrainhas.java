package edu.algoritmoscomplexidade.recursividade;

public class Nrainhas {
    
    private int tamanho;
    private int[] tabuleiro;
    
    public Nrainhas(int tamanho) {
        this.tamanho = tamanho;
        tabuleiro = new int[tamanho];
    }

    public void resolver() {
        if(posicionarRainhas(0)) {
            imprimeTabuleiro();
        } else {
            System.out.println("Não há solução para " + tamanho + " rainhas.");
        }
    }

    private boolean posicionarRainhas(int linha) {
        if(linha == tamanho)
             return true;

        for(int coluna = 0; coluna < tamanho; coluna++) {

            if(verificaPosicaoSegura(linha, coluna)){
                tabuleiro[linha] = coluna;
                if(posicionarRainhas(linha + 1))
                    return true;

                tabuleiro[linha] = -1;
            }
        }

        return false;
    }

    private boolean verificaPosicaoSegura(int linha, int coluna) {

        for( int i = 0; i < linha; i++) {

            int colunaPosicionada = tabuleiro[i];
            if(colunaPosicionada == coluna || colunaPosicionada - i == coluna - linha || colunaPosicionada + i == coluna + linha) {
                return false;
            }

        }
        return true;
    }

    private void imprimeTabuleiro() {
        for(int linha = 0; linha < tamanho; linha++) {
            for(int coluna = 0; coluna < tamanho; coluna++) {
                if(tabuleiro[linha] == coluna) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
}
