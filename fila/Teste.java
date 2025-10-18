public class Teste {
    public static void main(String[] args) {
        Fila queue = new Fila(10);

        Client lucas = new Client();
        Client david = new Client();

        david.setName("David");
        david.setWallet(90000.0);

        lucas.setName("Lucas");
        lucas.setWallet(100000.0);

        queue.addClientInArray(lucas);
        queue.addClientInArray(david);

        System.out.println(queue.toStringInArray());
        System.out.println("Tamanho: " + queue.sizeQueueInArray());

        queue.removeClientInArray();

        System.out.println("Após remover:\n" + queue.toStringInArray());
    }
}
