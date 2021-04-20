package utec.dashboard.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;


public class Conexion {
    private static Connection conexion = null;

    public static Connection getConexion() {

        try {
            if (conexion == null) {
                ResourceBundle configConexion = ResourceBundle.getBundle("jdbc");

                Runtime.getRuntime().addShutdownHook(new CerrarConexion());
                conexion = DriverManager.getConnection(
                        configConexion.getString("url"),
                        configConexion.getString("user"),
                        configConexion.getString("password")
                );
            }
            return conexion;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible establecer la conexion con la base de datos.");
        }
    }

    static class CerrarConexion extends Thread {
        public void run() {
            try {
                Connection miConexion = Conexion.getConexion();
                miConexion.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }

    private Conexion() {

    }
}


