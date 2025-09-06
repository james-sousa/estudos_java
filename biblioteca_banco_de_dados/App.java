import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca bib = new Biblioteca();
        int opcao;
        do {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1 - Inserir livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Excluir livro por ID");
            System.out.println("5 - Atualizar livro por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Páginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();
                    bib.inserirLivro(titulo, autor, paginas);
                }
                case 2 -> bib.listarLivros();
                case 3 -> {
                    System.out.print("Digite parte do título: ");
                    String busca = sc.nextLine();
                    bib.buscarPortitulo(busca);
                }
                case 4 -> {
                    System.out.print("Digite o ID do livro para excluir: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    bib.excluirLivro(id);
                }
                case 5 -> {
                    System.out.print("Digite o ID do livro a atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Novo autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Nova quantidade de páginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();

                    bib.atualizarLivro(id, titulo, autor, paginas);
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    
    }
}
