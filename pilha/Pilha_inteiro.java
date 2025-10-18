public class Pilha_inteiro{
    private int[] elementos;
    private int topo;
    private int capacidade;

    public Pilha_inteiro(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    public void push(int valor) {
        if (topo == capacidade - 1) {
            System.out.println("A pilha está cheia!");
            return;
        }
        elementos[++topo] = valor;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia");
            return -1;
        }
        return elementos[topo];
    }

    

    public void mostrar() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++){
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pilha_inteiro p = new Pilha_inteiro(5);
        p.push(10);
        p.push(20);
        p.push(30);
        p.mostrar();

        System.out.println("Topo: " + p.peek());
        System.out.println("Removendo: " + p.pop());
        p.mostrar();
    }
}