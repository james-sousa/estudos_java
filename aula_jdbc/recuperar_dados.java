import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class recuperar_dados {
    
    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/teste_banco";
            String username = "";
            String password = "";
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                stmt = connection.createStatement();
                String sql = "SELECT id, nome, email FROM usuarios";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    
}
