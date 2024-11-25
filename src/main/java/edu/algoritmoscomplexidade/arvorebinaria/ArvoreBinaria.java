package edu.algoritmoscomplexidade.arvorebinaria;

class No {
    int valor;
    No esquerdo, direito;

    public No(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class ArvoreBinaria {

    public No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Inserir nó na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    public No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        if (valor < raiz.valor)
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        else if (valor > raiz.valor)
            raiz.direito = inserirRecursivo(raiz.direito, valor);
        return raiz;
    }

    // Travessia em ordem (in-order)
    public void emOrdem() {
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    public void emOrdemRecursivo(No raiz) {
        if (raiz != null) {
            emOrdemRecursivo(raiz.esquerdo);
            System.out.print(raiz.valor + " ");
            emOrdemRecursivo(raiz.direito);
        }
    }

    // Travessia pré-ordem (pre-order)
    public void preOrdem() {
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    public void preOrdemRecursivo(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRecursivo(raiz.esquerdo);
            preOrdemRecursivo(raiz.direito);
        }
    }

    // Travessia pós-ordem (post-order)
    public void posOrdem() {
        posOrdemRecursivo(raiz);
        System.out.println();
    }

    public void posOrdemRecursivo(No raiz) {
        if (raiz != null) {
            posOrdemRecursivo(raiz.esquerdo);
            posOrdemRecursivo(raiz.direito);
            System.out.print(raiz.valor + " ");
        }
    }

    // DSW - Transformar árvore em uma lista encadeada (spine)
    private int criarEspinha(No raiz) {
        int contagemNos = 0;
        No atual = raiz, anterior = null;

        while (atual != null) {
            if (atual.esquerdo != null) {
                No filhoEsquerdo = atual.esquerdo;
                atual.esquerdo = filhoEsquerdo.direito;
                filhoEsquerdo.direito = atual;

                if (anterior != null) {
                    anterior.direito = filhoEsquerdo;
                } else {
                    this.raiz = filhoEsquerdo;
                }
                atual = filhoEsquerdo;
            } else {
                anterior = atual;
                atual = atual.direito;
                contagemNos++;
            }
        }

        return contagemNos;
    }

    // DSW - Rebalancear árvore com rotações
    private void realizarRotacoes(No raiz, int quantidade) {
        No atual = raiz;

        for (int i = 0; i < quantidade; i++) {
            No filho = atual.direito;
            atual.direito = filho.direito;
            filho.direito = atual;

            if (i == 0) {
                this.raiz = filho;
            }
            atual = atual.direito;
        }
    }

    // Metodo principal para balancear a árvore
    public void balancear() {
        if (raiz == null) {
            return;
        }

        int contagemNos = criarEspinha(raiz);

        // Calcular rotações iniciais
        int rotacoes = contagemNos + 1 - (1 << (int) (Math.log(contagemNos + 1) / Math.log(2)));

        realizarRotacoes(raiz, rotacoes);

        // Rotações subsequentes
        while (rotacoes > 1) {
            rotacoes /= 2;
            realizarRotacoes(raiz, rotacoes);
        }
    }
}
