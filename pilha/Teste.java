public class Teste {
    public static void main(String[] args) {
        Pilha stack = new Pilha(10);

        Client lucas = new Client();
        Client david = new Client();

        david.setName("David");
        david.setWallet(10000.0);

        lucas.setName("Lucas");
        lucas.setWallet(100000.0);

        stack.addInarray(lucas);
        stack.addInarray(david);

        System.out.println(stack.toStringInArray());
        System.out.println("Tamanho: " + stack.sizeInArray());

        stack.removeInArray();

        System.out.println("Após remover:\n" + stack.toStringInArray());
    }
}
