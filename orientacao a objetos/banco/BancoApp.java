package banco;
import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do titular da Conta 1: ");
        Conta conta1 = new Conta(scanner.nextLine(), 1001);
        System.out.print("Digite o nome do titular da conta 2: ");
        Conta conta2 = new Conta(scanner.nextLine(), 1002);

        int opcao;
        do {
            System.out.println("\n===== MENU BANCÁRIO =====");
            System.out.println("1 - Depositar na Conta 1");
            System.out.println("2 - Sacar da Conta 1");
            System.out.println("3 - Transferir da Conta 1 para Conta 2");
            System.out.println("4 - Ver Extrato da Conta 1");
            System.out.println("5 - Ver Extrato da Conta 2");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: R$ ");
                    double dep = scanner.nextDouble();
                    conta1.depositar(dep);
                    break;
                case 2:
                    System.out.print("Valor do saque: R$ ");
                    double saque = scanner.nextDouble();
                    conta1.sacar(saque);
                    break;
                case 3:
                    System.out.print("Valor da transferencia: R$ ");
                    double transf = scanner.nextDouble();
                    conta1.transferir(conta2, transf);
                    break;
                case 4:
                    conta1.mostrarExtrato();
                    break;
                case 5:
                    conta2.mostrarExtrato();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
