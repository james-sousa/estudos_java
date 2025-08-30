package cadastro;

public class Pessoa {
    String nome;
    int idade;
    String telefone; 

    public Pessoa(String nome, int idade, String telefone){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public void exibirDados(){
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Telefone: " + telefone);
    }
}
