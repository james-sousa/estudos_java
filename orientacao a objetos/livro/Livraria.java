public class Livraria {
    private Livro livro;
    private double preco;
    private int estoque;


    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getEstoque(){
        return this.estoque;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public Livraria(String titulo, String autor, int ano, double preco, int estoque){
        this.livro = new Livro();
        this.livro.setTitulo(titulo);
        this.livro.setAutor(autor);
        this.livro.setInt(ano);
        


        this.preco = setPreco(preco);
        this.estoque = setEstoque(estoque);

    }
    public void exibirInfoVenda(){
        livro.exibirInfo();
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + estoque + " Unidades");
    }
}
