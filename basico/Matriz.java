import java.util.Scanner;

class Matriz {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o numero de linhas: ");
        int l = scanner.nextInt();
        System.out.print("Digite o numero de colunas: ");
        int c = scanner.nextInt();
        double [][] matriz = new double[l][c];
        double soma = 0.0;
        int i,j;

        for (i=0; i < l; i++){
            for (j=0; j < c; j++){
                System.out.print("Informe sua nota: ");
                matriz[i][j] = scanner.nextDouble();
                soma += matriz[i][j];
            }
            
        }
        System.out.print(" suas notas são: ");
        System.out.print("\n");
        for (i=0; i < l; i++){
            for (j=0; j < c; j++){
                System.out.printf(" Nota[ %d ] [ %d ] = %.2f\n", i+1, j+1,matriz[i][j]);
            }
        }

        int total = l * c;
        double media = soma / total;
        System.out.printf("\nSoma total das notas: %.2f\n", soma);
        System.out.printf("\nMedia das notas: %.2f\n", media);
        scanner.close();
        
    }
    
}