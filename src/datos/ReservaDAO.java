package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import negocio.Reserva;
import util.ConexionBD;

/**
 * Clase que encapsula el acceso a la Base de Datos para la tabla categoria
 */
public class ReservaDAO {

    private final String[] QUERIES = {
        "INSERT INTO Reserva (f_inicio, f_fin, f_reserva, q_nochesReservadas, q_numeroPersonas, "
        + "v_precioEstadia, i_estado, k_numeroHabitacion, k_tipoDocumento, k_numeroDocumento) VALUES (?,?,?,?,?,?,?,?,?,?);",
        "SELECT * FROM Reserva WHERE k_reserva = ?;",
        "UPDATE Reserva SET i_estado=? WHERE k_reserva = ?;",
        "SELECT * FROM Reserva WHERE (f_inicio BETWEEN ? AND ?) OR (f_fin BETWEEN ? AND ?);",
        "SELECT k_reserva FROM reserva WHERE i_estado = 'pendiente' AND k_numerodocumento = ?"
        + " AND k_tipodocumento = ?",
        "SELECT concat(n_primerNombre, ' ', n_segundoNombre, ' ', n_primerApellido, ' ', n_segundoApellido)"
            + " FROM persona WHERE UPPER(concat(n_primerNombre, ' ', n_segundoNombre, ' ', n_primerApellido, ' ', n_segundoApellido))"
            + " LIKE UPPER(CONCAT('%', ?,'%'));"
    };

    public void agregarReserva(Reserva reserva) throws Exception {
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[0]);

            preQuery.setDate(1, java.sql.Date.valueOf(reserva.getF_inicio()));
            preQuery.setDate(2, java.sql.Date.valueOf(reserva.getF_fin()));
            preQuery.setTimestamp(3, java.sql.Timestamp.valueOf(reserva.getF_reserva()));
            preQuery.setInt(4, reserva.getQ_nochesReservadas());
            preQuery.setInt(5, reserva.getQ_numeroPersonas());
            preQuery.setDouble(6, reserva.getV_precioEstadia());
            preQuery.setString(7, reserva.getI_estado());
            preQuery.setInt(8, reserva.getK_numeroHabitacion());
            preQuery.setString(9, reserva.getK_tipoDocumento());
            preQuery.setLong(10, reserva.getK_numeroDocumento());

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

    public Reserva getReserva(Integer idReserva) throws Exception {
        boolean existe = false;
        Reserva reserva = new Reserva(); //Instancia el objeto para retornar los datos de la reserva

        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[1]);

            preQuery.setInt(1, idReserva);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                reserva.setK_reserva(data.getInt("k_reserva"));
                reserva.setF_inicio(new SimpleDateFormat("dd-MM-yyyy").format(data.getDate("f_inicio")));
                reserva.setF_fin(new SimpleDateFormat("dd-MM-yyyy").format(data.getDate("f_fin")));
                reserva.setF_reserva(new SimpleDateFormat("dd-MM-yyyy").format(data.getDate("f_reserva")));
                reserva.setQ_nochesReservadas(data.getInt("q_nochesReservadas"));
                reserva.setQ_numeroPersonas(data.getInt("q_numeroPersonas"));
                reserva.setV_precioEstadia(data.getDouble("v_precioEstadia"));
                reserva.setI_estado(data.getString("i_estado"));
                reserva.setK_numeroHabitacion(data.getInt("k_numeroHabitacion"));
                reserva.setK_tipoDocumento(data.getString("k_tipoDocumento"));
                reserva.setK_numeroDocumento(data.getLong("k_numeroDocumento"));

                existe = true;
            }

            if (existe) {
                return reserva;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }

    public void cambiarEstadoReserva(Reserva reserva) throws Exception {
        if (getReserva(reserva.getK_reserva()) != null) {
            try {
                Connection conexion = ConexionBD.getInstancia().tomarConexion();
                PreparedStatement preQuery = conexion.prepareStatement(QUERIES[2]);

                preQuery.setString(1, reserva.getI_estado());
                preQuery.setInt(2, reserva.getK_reserva());

                preQuery.executeUpdate();
                preQuery.close();
                ConexionBD.getInstancia().commit();

            } catch (Exception e) {
                ConexionBD.getInstancia().rollback();
                throw new Exception(e);
            } finally {
                ConexionBD.getInstancia().liberarConexion();
            }
        } else {
            throw new Exception("Reserva no existente");
        }
    }

    public int getTotalPersonas(String f_inicio, String f_fin) throws Exception {
        int contador = 0;

        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[3]);

            preQuery.setDate(1, java.sql.Date.valueOf(f_inicio));
            preQuery.setDate(2, java.sql.Date.valueOf(f_fin));
            preQuery.setDate(3, java.sql.Date.valueOf(f_inicio));
            preQuery.setDate(4, java.sql.Date.valueOf(f_fin));
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                contador += data.getInt("q_numeroPersonas");
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }

        return contador;
    }

    public void cancelarReserva(int k_reserva) throws Exception {
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[2]);

            preQuery.setString(1, "cancelada");
            preQuery.setInt(2, k_reserva);
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

    public String[] buscarReservas(Long k_numerodocumento, String k_tipodocumento) throws Exception {
        boolean existe = false;
        ArrayList<Integer> reservas = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[4]);

            preQuery.setLong(1, k_numerodocumento);
            preQuery.setString(2, k_tipodocumento);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                reservas.add(data.getInt("k_reserva"));
                existe = true;
            }

            if (existe) {
                String[] array = new String[reservas.size()];

                for (int i = 0; i < reservas.size(); i++) {
                    array[i] = reservas.get(i).toString();
                }

                return array;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }

    public String[] obtenerCoincidencias(String coincidencia) throws Exception {
        boolean existe = false;
        ArrayList<String> nombres = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[5]);

            preQuery.setString(1, coincidencia);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                nombres.add(data.getString("concat"));
                existe = true;
            }

            if (existe) {
                String[] array = new String[nombres.size()];

                for (int i = 0; i < nombres.size(); i++) {
                    array[i] = nombres.get(i);
                }

                return array;
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
