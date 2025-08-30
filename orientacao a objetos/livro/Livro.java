public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getAno(){
        return this.ano;
    }

    public void setInt(int ano){
        this.ano = ano;
    }

    

    public void exibirInfo(){
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de publicação: " + getAno());
    }
    
}
