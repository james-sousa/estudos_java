package banco;

public class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private Operacao[] extrato;
    private int indiceExtrato;

    public Conta(String titular, int numero){
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0.0;
        this.extrato = new Operacao[100];
        this.indiceExtrato = 0;
    }

    public void depositar(double valor){
        if (valor > 0 ) {
            saldo += valor;
            registrarOperacao("Depósito", valor);
        }else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            registrarOperacao("Saque", valor);
        }else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void transferir(Conta destino, double valor){
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            destino.saldo = valor;
            this.registrarOperacao("Transferência para conta " + destino.numero, valor);
            destino.registrarOperacao("Transferência recebida da conta " + this.numero, valor);
        }else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    private void registrarOperacao(String tipo, double valor){
        if (indiceExtrato < extrato.length) {
            extrato[indiceExtrato] = new Operacao(tipo, valor);
            indiceExtrato++;
        }else {
            System.out.println("Limite de extrato atingido.");
        }
    }
    
    public void mostrarExtrato(){
        System.out.println("Extrato da conta " + numero + " - " + titular);
        for (int i = 0; i < indiceExtrato; i++){
            System.out.println(extrato[i]);
        }
        System.out.printf("Saldo atual: R$ %.2f\n" + saldo);
    }

    public int getNumero(){
        return numero;
    }

    public String getTitular(){
        return titular;
    }
    
    public double getSaldo(){
        return saldo;
    }
}

