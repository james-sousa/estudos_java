package banco;
import java.time.LocalDateTime;

public class Operacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Operacao(String tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }
    public String toString(){
        return "[" + dataHora + "] " + tipo + ": R$ " + valor;
    }
}
