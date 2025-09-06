import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Biblioteca {
    private String url = "jdbc:sqlite:biblioteca.db";

    public Biblioteca() {
        
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null) {
                System.out.println("Conexão estabelecida!");

                try (Statement tab = conn.createStatement()){
                    String sqlCreat =   "CREATE TABLE IF NOT EXISTS livros(" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                        "titulo TEXT NOT NULL," +
                                        "autor TEXT NOT NULL,"+
                                        "paginas INTEGER)";
                    tab.execute(sqlCreat);
                    System.out.println("Tabela criada!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: "+ e.getMessage());

        }
    }

    public void inserirLivro(String titulo, String autor, int paginas){
        String sqlInsert = "INSERT INTO livros(titulo, autor, paginas) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement tabps = conn.prepareStatement(sqlInsert)){
            tabps.setString(1, titulo);
            tabps.setString(2, autor);
            tabps.setInt(3, paginas);
            tabps.executeUpdate();
            System.out.println("livro inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir livro: "+e.getMessage());
        }
    }

    public void listarLivros(){
        String sqlSelect = "SELECT * FROM livros";
        try (Connection conn = DriverManager.getConnection(url);
            Statement tabs = conn.createStatement();
            ResultSet rs = tabs.executeQuery(sqlSelect)){
            System.out.println("\nLivros cadastrados");
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int paginas = rs.getInt("paginas");
                System.out.println(id + " - " + titulo + " - " + autor + " - " + paginas);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    public void buscarPortitulo(String titulo){
        String sql = "SELECT * FROM livros WHERE titulo LIKE ?";
        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement tabs = conn.prepareStatement(sql)){
            tabs.setString(1, "%" + titulo + "%");
            ResultSet rs = tabs.executeQuery();
            boolean acho = false;
            while (rs.next()) {
                acho = true;
                System.out.printf("%d - %s - %s - %d páginas%n", rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("paginas"));
            }
            if (!acho) {
                System.out.println("Nenhum livro encontrado com esse titulo.");
            }
        } catch (SQLException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    public void excluirLivro(int id){
        String sql = "DELETE FROM livros WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement tabs = conn.prepareStatement(sql)){
            tabs.setInt(1, id);
            int linhas = tabs.executeUpdate();
            if (linhas > 0) {
                System.out.println("Livro excluido com sucesso!");
            }else {
                System.out.println("Nenhum livro encontrado com esse ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }

    public void atualizarLivro(int id, String novoTitulo, String novoAutor, int novasPaginas) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, paginas = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoTitulo);
            pstmt.setString(2, novoAutor);
            pstmt.setInt(3, novasPaginas);
            pstmt.setInt(4, id);

            int linhas = pstmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Livro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com esse ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

}