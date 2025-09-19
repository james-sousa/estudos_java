import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CriarArquivo {
    private static Formatter saida;
    public static void main(String[] args) {
        abrirArquivo();
        adicionarDados();
        fecharArquivo();
    }

    public static void abrirArquivo(){
        try {
            saida = new Formatter("arquivo.txt");
        } catch (SecurityException securityException){
            System.err.println("Não é possivel escrever no arquivo. Finalizando..");
            System.exit(1);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao abrir o arquivo. Finalizando.");
            System.exit(1); // Finalizar o programa
        }
    }

    public static void adicionarDados(){
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s%n","Entre com o código do produto e nome do item para cadastro:");
        System.out.printf("%s%n","Para salvar os dados inseridos pressione Ctrl+Z:");
        while (entrada.hasNext()) { // iterar até que seja encontrado o marcador de fim-de-arquivo
            try {
            // Gravar novo registro no arquivo; não verifica se entrada é válida.
            saida.format("%d %s %n", entrada.nextInt(),entrada.next());
            }
            catch (FormatterClosedException formatterClosedException) {
            System.err.println("Erro ao escrever no arquivo. Finalizando.");
            break;
            }
            catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida. Tente novamente.");
            entrada.nextLine(); // Descartar a entrada para que o usuário possa tentar de novo
            }
            System.out.print("Entre com o próximo código e item:\n");
        }
        entrada.close();
    }

    public static void fecharArquivo(){
        if (saida != null) {
            saida.close();
        }
    }
}
