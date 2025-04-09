package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.Habitacion;
import util.ConexionBD;

public class HabitacionDAO {

    private final String[] QUERIES = {
        "SELECT h.k_numeroHabitacion, h.k_tipo, h.k_hotel FROM Habitacion h, Reserva r WHERE k_tipo = ? AND "
        + "((h.k_numeroHabitacion=r.k_numeroHabitacion AND ((? < f_inicio AND ? < f_inicio) OR (? > f_fin AND ? > f_fin))) "
        + "OR h.k_numeroHabitacion NOT IN (SELECT k_numeroHabitacion FROM Reserva)) LIMIT 1;",
        "SELECT * FROM Habitacion WHERE k_tipo = ? limit 1;"

    };

    public Habitacion getHabitacionDisponible(String tipo, String f_inicio, String f_fin) throws Exception {
        boolean existe = false;
        Habitacion habitacion = new Habitacion(); //Instancia el objeto para retornar los datos de la habitación

        try {
            Connection connection = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = connection.prepareStatement(QUERIES[0]);

            preQuery.setString(1, tipo);
            preQuery.setDate(2, java.sql.Date.valueOf(f_inicio));
            preQuery.setDate(3, java.sql.Date.valueOf(f_fin));
            preQuery.setDate(4, java.sql.Date.valueOf(f_inicio));
            preQuery.setDate(5, java.sql.Date.valueOf(f_fin));
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                habitacion.setK_numeroHabitacion(data.getInt("k_numeroHabitacion"));
                habitacion.setK_tipo(data.getString("k_tipo"));
                habitacion.setK_hotel(data.getInt("k_hotel"));

                existe = true;
            }

            if (existe) {
                return habitacion;
            } else {
                preQuery = connection.prepareStatement(QUERIES[1]);
                preQuery.setString(1, tipo);
                data = preQuery.executeQuery();

                while (data.next()) {
                    habitacion.setK_numeroHabitacion(data.getInt("k_numeroHabitacion"));
                    habitacion.setK_tipo(data.getString("k_tipo"));
                    habitacion.setK_hotel(data.getInt("k_hotel"));
                }

                return habitacion;
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }
}
