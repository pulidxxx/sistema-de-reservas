
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.Tipo;
import util.ConexionBD;

/**
 * Clase que encapsula el acceso a la Base de Datos para la tabla Tipo
 */

public class TipoDAO {
    private final String[] QUERIES = {
        "SELECT * FROM Tipo WHERE k_tipo = ?;"
    };
    
    public Tipo getTipo(String idTipo) throws Exception {
        boolean existe = false;
        Tipo tipo = new Tipo(); //Instancia el objeto para retornar los datos del Tipo de la habitación
        
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[0]);
            
            preQuery.setString(1, idTipo);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                tipo.setK_tipo(data.getString("k_tipo"));
                tipo.setV_precioNoche(data.getDouble("v_precioNoche"));
                
                existe = true;
            }
            
            if (existe) return tipo;
            else return null;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }
}
