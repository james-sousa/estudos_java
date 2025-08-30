package introducaotestes;
import java.util.Scanner;

import introducaoclasses.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudante[] aluno = new Estudante[2];
        for (int i = 0; i < aluno.length; i++){
            aluno[i] = new Estudante();
            System.out.print("Digite o nome do aluno: ");

            aluno[i].nome = scanner.nextLine();

            System.out.print("Digite a matricula: ");
            aluno[i].matricula = scanner.nextLine();

            System.out.print("Digite a idade: ");
            aluno[i].idade = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < aluno[i].notas.length; j++){
                System.out.print("Digite as notas: ");
                aluno[i].notas[j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }

        for (int i = 0; i < aluno.length; i++){
            System.out.printf("Nome: %s%n", aluno[i].nome);
            System.out.printf("Matricula: %s%n", aluno[i].matricula);
            System.out.printf("Idade: %d%n", aluno[i].idade);
            for (int j = 0; j < aluno[i].notas.length; j++)
              System.out.printf("Notas: %d: %.2f%n", j+ 1, aluno[i].notas[j]);
        }
       
    }
}
