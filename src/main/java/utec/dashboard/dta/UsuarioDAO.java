package utec.dashboard.dta;

import utec.dashboard.bd.Conexion;
import utec.dashboard.dto.UsuarioDTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UsuarioDAO {
    Connection conexion = Conexion.getConexion();
    CallableStatement runSp = null;

    public UsuarioDTO logearUsuarios(String usuario, String clave) {
        try {
            runSp = conexion.prepareCall("{CALL spValidarUsuario(?, ?)}");
            runSp.setString(1, usuario);
            runSp.setString(2, clave);
            ResultSet datos = runSp.executeQuery();
            if (datos.next()) {
                UsuarioDTO user = new UsuarioDTO(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getInt(6)
                );
                datos.close();
                return user;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible ejecutar el spValidarUsuario.");
        }
    }
}
