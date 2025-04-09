package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import negocio.Huesped;
import negocio.Registro;
import util.ConexionBD;

/**
 *
 * @author Darkmoon
 */
public class RegistroDAO {

    private final String[] QUERIES = {
        "INSERT INTO huesped (o_direccion, o_telefono, f_nacimiento, k_tipodocumento, k_numerodocumento) VALUES(?,?,?,?,?);",
        "DELETE FROM huesped WHERE k_numerodocumento = ?"
    };

    public void checkIn(Huesped huesped) throws Exception {
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[0]);

            preQuery.setString(1, huesped.getO_direccion());
            preQuery.setInt(2, huesped.getO_telefono());
            preQuery.setDate(3, java.sql.Date.valueOf(huesped.getF_nacimiento()));
            preQuery.setString(4, huesped.getK_tipoDocumento());
            preQuery.setLong(5, huesped.getK_numeroDocumento());

            preQuery.executeUpdate();
            preQuery.close();
            ConexionBD.getInstancia().commit();

        } catch (Exception e) {
            ConexionBD.getInstancia().rollback();
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }

}
