package utec.dashboard.dta;

import utec.dashboard.bd.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Usuario {
    Connection conexion = Conexion.getConexion();
    CallableStatement runSp = null;

    public String logearUsuarios(String usuario, String clave) {
        try {
            String out = "";
            runSp = conexion.prepareCall("{CALL spValidarUsuario(?, ?)}");
            runSp.setString(1, usuario);
            runSp.setString(2, clave);
            ResultSet datos = runSp.executeQuery();
            while (datos.next()) {
                out = datos.getString(2) + " " + datos.getString(5);
            }
            datos.close();
            return out;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el spValidarUsuario.");
        }
    }
}
