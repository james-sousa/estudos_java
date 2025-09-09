import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dia = 0;
        String diaSemana;
        System.out.println("Entre com o código do dia da semana:");
        dia = entrada.nextInt();
        entrada.close();
        switch (dia) {
        case 1:
            diaSemana = DiasSemana.DOMINGO.toString();
            break;
        case 2:
            diaSemana = DiasSemana.SEGUNDA.toString();
            break;
        case 3:
            diaSemana = DiasSemana.TERÇA.toString();
            break;
        case 4:
            diaSemana = DiasSemana.QUARTA.toString();
            break;
        case 5:
            diaSemana = DiasSemana.QUINTA.toString();
            break;
        case 6:
            diaSemana = DiasSemana.SEXTA.toString();
            break;
        case 7:
            diaSemana = DiasSemana.SÁBADO.toString();
            break;
        default:
            diaSemana = "Dia inválido";
        }
        System.out.println("O dia da semana escolhido foi: " + diaSemana);
    }
}
