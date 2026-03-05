import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class atualizar_dados {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teste_banco";
        String username = "";
        String password = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(
                "UPDATE usuarios " + "SET email = ?" + " WHERE id = ?"
            );
            stmt.setString(1, "novo_email@example.com");
            stmt.setInt(2, 1);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
