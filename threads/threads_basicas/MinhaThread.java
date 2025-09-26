public class MinhaThread extends Thread{
    private String nome;
    private int tempo;

    public MinhaThread(String nome, int tempo){
        this.tempo = tempo;
        this.nome = nome;
        start();
    }

    public void run(){
        try {
            for (int i=0; i < 6; i++){
                System.out.println(nome + " Contador " + i);
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " Terminou o temnpo de execução");
    }
}
