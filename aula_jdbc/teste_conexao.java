import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teste_conexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teste_banco";
        String username = "";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão bem-sucedida!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}