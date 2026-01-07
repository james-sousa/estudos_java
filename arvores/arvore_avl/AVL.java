class No {
    int chave;
    No esquerda, direita;
    int altura;

    No(int d) {
        chave = d;
        altura = 1;
    }
}

public class AVL {
    private No raiz;

    private int altura(No N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private No direitaRotacao(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No esquerdaRotacao(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private int getBalance(No N) {
        if (N == null)
            return 0;
        return altura(N.esquerda) - altura(N.direita);
    }

    public No inserir(No node, int chave) {
        if (node == null)
            return (new No(chave));

        if (chave < node.chave)
            node.esquerda = inserir(node.esquerda, chave);
        else if (chave > node.chave)
            node.direita = inserir(node.direita, chave);
        else
            return node;

        node.altura = 1 + max(altura(node.esquerda), altura(node.direita));

        int balance = getBalance(node);

        if (balance > 1 && chave < node.esquerda.chave)
            return direitaRotacao(node);

        if (balance < -1 && chave > node.direita.chave)
            return esquerdaRotacao(node);

        if (balance > 1 && chave > node.esquerda.chave) {
            node.esquerda = esquerdaRotacao(node.esquerda);
            return direitaRotacao(node);
        }

        if (balance < -1 && chave < node.direita.chave) {
            node.direita = direitaRotacao(node.direita);
            return esquerdaRotacao(node);
        }
        return node;
    }
    public void preOrder(No node) {
        if (node != null) {
            System.out.print(node.chave + " ");
            preOrder(node.esquerda);
            preOrder(node.direita);
        }
    }

    private No minValueNo(No node) {
        No current = node;

        while (current.esquerda != null)
            current = current.esquerda;

        return current;
    }


    public No removerNo(No root, int chave) {
        if (root == null)
            return root;

        if (chave < root.chave)
            root.esquerda = removerNo(root.esquerda, chave);
        else if (chave > root.chave)
            root.direita = removerNo(root.direita, chave);
        else {
            if ((root.esquerda == null) || (root.direita == null)) {
                No temp = null;
                if (temp == root.esquerda)
                    temp = root.direita;
                else
                    temp = root.esquerda;

                if (temp == null) {
                    root = null;
                } else
                    root = temp;
            } else {
                No temp = minValueNo(root.direita);
                root.chave = temp.chave;
                root.direita = removerNo(root.direita, temp.chave);
            }
        }

        if (root == null)
            return root;

        root.altura = 1 + max(altura(root.esquerda), altura(root.direita));

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.esquerda) >= 0)
            return direitaRotacao(root);

        if (balance > 1 && getBalance(root.esquerda) < 0) {
            root.esquerda = esquerdaRotacao(root.esquerda);
            return direitaRotacao(root);
        }

        if (balance < -1 && getBalance(root.direita) <= 0)
            return esquerdaRotacao(root);

        if (balance < -1 && getBalance(root.direita) > 0) {
            root.direita = direitaRotacao(root.direita);
            return esquerdaRotacao(root);
        }

        return root;
    }

    public static void main(String[] args) {
        AVL arvore = new AVL();

        arvore.raiz = arvore.inserir(arvore.raiz, 10);
        arvore.raiz = arvore.inserir(arvore.raiz, 20);
        arvore.raiz = arvore.inserir(arvore.raiz, 30);
        arvore.raiz = arvore.inserir(arvore.raiz, 40);
        arvore.raiz = arvore.inserir(arvore.raiz, 50);
        arvore.raiz = arvore.inserir(arvore.raiz, 25);
        System.out.println("Preorder traversal da árvore AVL é:");
        arvore.preOrder(arvore.raiz);
        arvore.raiz = arvore.removerNo(arvore.raiz, 40);
        System.out.println("Preorder traversal da árvore AVL é:");
        arvore.preOrder(arvore.raiz);
    }

}

