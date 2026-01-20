package proyectodi;

// 1. IMPORT CORRECTO (Crucial para que Jasper lo reconozca)
import java.sql.Connection; 
import java.io.IOException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Daniel Burdallo
 */
public class Main {
    
    public static void main(String[] args) {

        // 2. Obtener la conexión (Usa el nombre exacto de tu método: getConexion)
        Connection cn = ConexionBD.getConexion(); 
        
        if (cn != null) {
            try {
                System.out.println("Conexión establecida. Generando reporte...");

                // 3. Rutas de los archivos .jrxml
                // Asegúrate de que estos archivos existan en esa carpeta exacta
                String path1 = "src/reportes/reporte1.jrxml";

                // 4. Compilar los reportes
                JasperReport reporte1 = JasperCompileManager.compileReport(path1);

                // 5. Llenar y mostrar el PRIMER reporte
                JasperPrint jprint1 = JasperFillManager.fillReport(reporte1, null, cn);
                JasperViewer viewer1 = new JasperViewer(jprint1, false);
                viewer1.setTitle("Primer Reporte - General");
                viewer1.setVisible(true);
                
                System.out.println("Ambos reportes se han abierto con éxito.");

            } catch (Exception e) {
                System.out.println("Error al generar el reporte: " + e.getMessage());
                e.printStackTrace(); 
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}