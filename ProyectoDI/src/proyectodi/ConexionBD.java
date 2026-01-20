package proyectodi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/proyectodibd";
    private static final String USER = "root";
    private static final String PASS = "root";

    // Método para obtener la conexión
    public static Connection getConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }

    // Método para probar la conexión con SELECT 1
    
    public static void probarConexion() {
       String sql = "SELECT * FROM clientes";

        try (Connection conn = getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Prueba correcta. Resultado: " + rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println("Error en la prueba: " + e.getMessage());
        }
    }

    // Método main para ejecutar la prueba
    public static void main(String[] args) {
        probarConexion();
    }
}
