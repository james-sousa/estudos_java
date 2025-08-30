import java.util.Scanner;

class Vetor {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        int[] vetor = new int[4];
        int i;

        for (i=0; i < 4; i++){
            System.out.print("Informe sua nota: ");
            vetor[i] = scanner.nextInt();
        }
        System.out.print(nome + " suas notas são: ");
        System.out.print("\n");
        for (i=0; i < 4; i++){
            System.out.printf(" Nota[ %d ] = %d \n", i+1,vetor[i]);
        }
        scanner.close();
    }
    
}