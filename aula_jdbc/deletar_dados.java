import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class deletar_dados {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teste_banco";
        String username = "";
        String password = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt.setInt(1, 2);
            int linhasAfetadas = stmt.executeUpdate();
            

            if (linhasAfetadas > 0) {
                System.out.println("Usuário com ID foi deletado.");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
                
            }
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
