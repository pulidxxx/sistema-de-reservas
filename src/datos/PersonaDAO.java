package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import negocio.Persona;
import util.ConexionBD;

/**
 *
 * @author ssant
 */
public class PersonaDAO {

    private final String[] QUERIES = {
        "INSERT INTO Persona (k_tipoDocumento, k_numeroDocumento, n_primernombre, n_segundonombre, n_primerapellido, n_segundoapellido) VALUES (?,?,?,?,?,?);",
        "SELECT * FROM Persona WHERE k_numeroDocumento = ? AND k_tipoDocumento = ? ",
        "SELECT k_tipodocumento, k_numerodocumento FROM persona WHERE "
        + "CONCAT(n_primerNombre, ' ', n_segundoNombre, ' ', n_primerApellido, ' ', n_segundoApellido) = ?;"
    };

    public void agregarPersona(Persona persona) throws Exception {
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            try ( PreparedStatement preQuery = conexion.prepareStatement(QUERIES[0])) {
                preQuery.setString(1, persona.getK_tipoDocumento());
                preQuery.setLong(2, persona.getK_numeroDocumento());
                preQuery.setString(3, persona.getN_primerNombre());
                preQuery.setString(4, persona.getN_segundoNombre());
                preQuery.setString(5, persona.getN_primerApellido());
                preQuery.setString(6, persona.getN_segundoApellido());

                preQuery.executeUpdate();
            }
            ConexionBD.getInstancia().commit();

        } catch (Exception e) {
            ConexionBD.getInstancia().rollback();
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }

    public Persona consultarPersona(Long numeroDocumento, String tipoDocumento) throws Exception {
        boolean existe = false;
        Persona persona = new Persona(); //Instancia el objeto para retornar los datos de la persona

        try {
            Connection connection = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = connection.prepareStatement(QUERIES[1]);

            preQuery.setLong(1, numeroDocumento);
            preQuery.setString(2, tipoDocumento);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                persona.setK_tipoDocumento(data.getString("k_tipoDocumento"));
                persona.setK_numeroDocumento(data.getLong("k_numeroDocumento"));
                persona.setN_primerNombre(data.getString("n_primernombre"));
                persona.setN_segundoNombre(data.getString("n_segundonombre"));
                persona.setN_primerApellido(data.getString("n_primerapellido"));
                persona.setN_segundoApellido(data.getString("n_segundoapellido"));

                existe = true;
            }

            if (existe) {
                return persona;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }

    public Persona obtenerPersona(String nombre) throws Exception {
        boolean existe = false;
        Persona persona = new Persona();
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[2]);

            preQuery.setString(1, nombre);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                persona.setK_tipoDocumento(data.getString("k_tipodocumento"));
                persona.setK_numeroDocumento(data.getLong("k_numerodocumento"));
                existe = true;
            }

            if (existe) {
                return persona;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }
}
