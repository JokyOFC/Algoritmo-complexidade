package edu.algoritmoscomplexidade.arvorebinaria;

class NoAVL {
    int valor, altura;
    NoAVL esquerdo, direito;

    NoAVL(int valor) {
        this.valor = valor;
        altura = 1;
    }
}

public class ArvoreBinariaAVL {

    NoAVL raiz;

    // Obter a altura de um nó
    int altura(NoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    // Função auxiliar para obter o valor máximo de dois inteiros
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Rotação à direita
    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerdo;
        NoAVL T2 = x.direito;

        // Executa rotação
        x.direito = y;
        y.esquerdo = T2;

        // Atualiza alturas
        y.altura = max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = max(altura(x.esquerdo), altura(x.direito)) + 1;

        // Retorna nova raiz
        return x;
    }

    // Rotação à esquerda
    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL T2 = y.esquerdo;

        // Executa rotação
        y.esquerdo = x;
        x.direito = T2;

        // Atualiza alturas
        x.altura = max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = max(altura(y.esquerdo), altura(y.direito)) + 1;

        // Retorna nova raiz
        return y;
    }

    // Obter o fator de balanceamento de um nó
    public int getBalance(NoAVL N) {
        if (N == null)
            return 0;
        return altura(N.esquerdo) - altura(N.direito);
    }

    // Inserir um nó na árvore AVL
    public NoAVL inserir(NoAVL no, int valor) {

        // Inserir como uma árvore binária de busca comum
        if (no == null)
            return (new NoAVL(valor));

        if (valor < no.valor)
            no.esquerdo = inserir(no.esquerdo, valor);
        else if (valor > no.valor)
            no.direito = inserir(no.direito, valor);
        else
            return no;

        // Atualiza a altura deste ancestral
        no.altura = 1 + max(altura(no.esquerdo), altura(no.direito));

        // Obtém o fator de balanceamento
        int balance = getBalance(no);

        // Caso 1 - Rotação à direita
        if (balance > 1 && valor < no.esquerdo.valor)
            return rotacaoDireita(no);

        // Caso 2 - Rotação à esquerda
        if (balance < -1 && valor > no.direito.valor)
            return rotacaoEsquerda(no);

        // Caso 3 - Rotação dupla à direita
        if (balance > 1 && valor > no.esquerdo.valor) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        // Caso 4 - Rotação dupla à esquerda
        if (balance < -1 && valor < no.direito.valor) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Travessia em ordem
    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }


    public static void main(String[] args) {
        ArvoreBinariaAVL arvore = new ArvoreBinariaAVL();

        arvore.raiz = arvore.inserir(arvore.raiz, 10);
        arvore.raiz = arvore.inserir(arvore.raiz, 20);
        arvore.raiz = arvore.inserir(arvore.raiz, 30);
        arvore.raiz = arvore.inserir(arvore.raiz, 40);
        arvore.raiz = arvore.inserir(arvore.raiz, 50);
        arvore.raiz = arvore.inserir(arvore.raiz, 25);

        System.out.println("Travessia em ordem da árvore AVL:");
        arvore.emOrdem(arvore.raiz);

    }
}

