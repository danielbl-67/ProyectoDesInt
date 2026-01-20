/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectodi;

/**
 *
 * @author Daniel Burdallo
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


public class ReporteClientes {
    
    
    public static void generarReporte(Connection con) {
    try {
        // 1. Ruta del archivo compilado (.jasper)
        String path = "reportes/reporte1.jasper";
        
        // 2. Parámetros 
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("", "");

        // 3. Llenar el reporte con los datos de la conexión
        JasperPrint jprint = JasperFillManager.fillReport(path, parametros, con);

        // 4. Mostrar el reporte en una ventana
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        view.setVisible(true);

    } catch (JRException e) {
        System.err.println("Error al generar reporte: " + e.getMessage());
    }
    }
}

