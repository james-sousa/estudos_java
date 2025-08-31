import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_dados {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:meubanco.db"; // arquivo do banco (será criado se não existir)

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão estabelecida com SQLite!");

                // Criar tabela
                try (Statement stmt = conn.createStatement()) {
                    String sqlCreate = "CREATE TABLE IF NOT EXISTS alunos (" +
                                       "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                       "nome TEXT NOT NULL," +
                                       "idade INTEGER," +
                                       "media REAL)";
                    stmt.execute(sqlCreate);
                    System.out.println("Tabela 'alunos' criada (ou já existia).");

                    
                    stmt.execute("INSERT INTO alunos(nome, idade, media) VALUES ('João', 20, 9.89)");
                    stmt.execute("INSERT INTO alunos(nome, idade, media) VALUES ('Maria', 22, 8.90)");
                    stmt.execute("INSERT INTO alunos(nome, idade, media) VALUES ('Pedro', 19, 7.80)");
                    System.out.println("Dados inseridos com sucesso!");

                    // Consultar dados
                    ResultSet rs = stmt.executeQuery("SELECT * FROM alunos");
                    System.out.println("\nLista de alunos:");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        int idade = rs.getInt("idade");
                        double media = rs.getDouble("media");
                        System.out.println(id + " - " + nome + " (" + idade + " anos) Media: " + media);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar/inserir no banco: " + e.getMessage());
        }
    }
}
