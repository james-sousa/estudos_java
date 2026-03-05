import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class inserir_dados {
    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/teste_banco?";
            String username = "";
            String password = "";
            PreparedStatement pstmt = null;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                
                pstmt  = connection.prepareStatement( "INSERT INTO usuarios " 
                    + "(nome, email)"
                    + "VALUES" 
                    + "(?, ?)");

                pstmt.setString(1, "Fernando Silva");
                pstmt.setString(2, "fernando.silva@example.com");
                pstmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
                finally {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }
}
