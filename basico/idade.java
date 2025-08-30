import java.util.Scanner;

class idade {
    
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        
        System.out.println("Idade esse ano: ");
        System.out.println(idade);
        System.out.println("\n");

        int idadeAnoQueVem;
        idadeAnoQueVem = idade + 1;
        System.out.println("idade ano que vem: ");
        System.out.println(idadeAnoQueVem);

        if (idadeAnoQueVem < 18){
            System.out.println( nome + " Você ainda eh menor de idade");
        } else{
            System.out.println(nome + " Você já é maior de idade!");
        }
        scanner.close();
    }
}


