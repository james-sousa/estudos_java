
class No {
    int valor;
    No esq;
    No dir;
    public No(int valor){
        this.valor = valor;
        esq = null;
        dir = null;
    }
}


class ArvoreBinaria{
    No raiz;
    
    public ArvoreBinaria(){
        raiz = null;
    }

    No inserir(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }
        if (valor < raiz.valor) {
            raiz.esq = inserir(raiz.esq, valor);
        }else if (valor > raiz.valor) {
            raiz.dir = inserir(raiz.dir, valor);
        }

        return raiz;
    }

    boolean busca(No raiz, int valor){
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        if (valor < raiz.valor) {
            return busca(raiz.esq, valor);
        }else {
            return busca(raiz.dir, valor);
        }

    }

    public boolean busca(int valor){
        return busca(valor);
    }

    void inOrdem(No no){
        if (no != null) {
            inOrdem(no.esq);
            System.out.print(no.valor + " ");
            inOrdem(no.dir);
        }
    }
}


public class AroveInt {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arvore.inserir(arvore, v);
        }
        System.out.print("Arvore binaria: ");
        arvore.inOrdem(arvore.raiz);


    }
}


