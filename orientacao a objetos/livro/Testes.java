import java.util.Scanner;



public class Testes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o nome do titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = sc.nextLine();
        System.out.print("Digite o ano da publicação: ");
        int ano = sc.nextInt();
        System.out.print("Digite o preço do livro: ");
        double preco = sc.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int estoque = sc.nextInt();
        Livraria livro = new Livraria(titulo,autor,ano,preco,estoque);
        livro.exibirInfoVenda();

    }
}
