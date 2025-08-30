package cadastro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[100];
        int totalCadastrados = 0;

        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    if (totalCadastrados < pessoas.length) {
                        System.out.print("Nome: ");
                        String nome = entrada.nextLine();
                        System.out.print("Idade: ");
                        int idade = entrada.nextInt();
                        entrada.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = entrada.nextLine();
                        pessoas[totalCadastrados] = new Pessoa(nome, idade, telefone);
                        totalCadastrados++;
                        System.out.println("Pessoa cadastrada com sucesso!");
                        
                    }else {
                        System.out.println("Limite de cadastro atigido!");
                    }
                    break;
                case 2:
                    if (totalCadastrados == 0) {
                        System.out.println("Nenhuma pessoa cadastrada.");

                    }else {
                        System.out.println("\n--- Lista de Pessoas ---");
                        for (int i = 0; i < totalCadastrados; i++){
                            pessoas[i].exibirDados();

                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (opcao != 3);
        entrada.close();
    }

}
