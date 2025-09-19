import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;


public class LerArquivo {
    private static Scanner entrada;
    public static void main(String[] args) {
        abrirArquivo();
        lerDados();
        fecharArquivo();
    }

    public static void abrirArquivo() {
        try {
        entrada = new Scanner(Paths.get("arquivo.txt")); // Abrir o arquivo, salvo em C:\Java\
        }
        catch (IOException erroES) {
        System.err.println("Erro ao abrir o arquivo. Finalizando.");
        System.exit(1); // terminar o programa
        }
    }

    public static void lerDados() {
        System.out.printf("%-10s%-15s%n","Código","Produto");
        try {
        while (entrada.hasNext()) { // enquanto houver dados para ler, mostrar os registros
            System.out.printf("%-10d%-12s%n",entrada.nextInt(),entrada.next());
        }
        }
        catch (NoSuchElementException erroElemento) {
        System.err.println("Arquivo com problemas. Finalizando.");
        entrada.nextLine(); // Descartar a entrada para que o usuário possa tentar de novo
        }
        catch (IllegalStateException erroEstado) {
        System.err.println("Erro ao ler o arquivo. Finalizando.");
        }
    }

    public static void fecharArquivo() {
    if (entrada != null)
        entrada.close();
    }

}
