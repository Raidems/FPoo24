/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cruduser204;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class CRUDUser204 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conex = ConexionMySQL.conectar();
        if (conex != null) {
            JOptionPane.showMessageDialog(null,"✅ Conexión establecida correctamente.", "Conectado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "❌ No se pudo conectar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
