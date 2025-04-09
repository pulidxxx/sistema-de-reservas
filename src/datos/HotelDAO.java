
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.Hotel;
import util.ConexionBD;

/**
 * Clase que encapsula el acceso a la Base de Datos para la tabla Hotel
 */

public class HotelDAO {
    private final String[] QUERIES = {
        "SELECT * FROM Hotel WHERE k_hotel = ?;",
        "UPDATE Hotel SET q_diasDescuento=?, t_descuento=?, t_aforo=?, q_capacidad=? WHERE k_hotel = ?;"
    };
    
    public Hotel getHotel(Integer idHotel) throws Exception {
        boolean existe = false;
        Hotel hotel = new Hotel(); //Instancia el objeto para retornar los datos de la reserva
        
        try {
            Connection conexion = ConexionBD.getInstancia().tomarConexion();
            PreparedStatement preQuery = conexion.prepareStatement(QUERIES[0]);
            
            preQuery.setInt(1, idHotel);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                hotel.setK_hotel(data.getInt("k_hotel"));
                hotel.setQ_diasDescuento(data.getInt("q_diasDescuento"));
                hotel.setT_descuento(data.getInt("t_descuento"));
                hotel.setT_aforo(data.getInt("t_aforo"));
                hotel.setQ_capacidad(data.getInt("q_capacidad"));
                
                existe = true;
            }
            
            if (existe) return hotel;
            else return null;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ConexionBD.getInstancia().liberarConexion();
        }
    }
    
    public void actualizarHotel(Hotel hotel) throws Exception {
        if (getHotel(hotel.getK_hotel()) != null) {
            try {
                Connection conexion = ConexionBD.getInstancia().tomarConexion();
                PreparedStatement preQuery = conexion.prepareStatement(QUERIES[1]);

                preQuery.setInt(1, hotel.getQ_diasDescuento());
                preQuery.setInt(2, hotel.getT_descuento());
                preQuery.setInt(3, hotel.getT_aforo());
                preQuery.setInt(4, hotel.getQ_apacidad());
                preQuery.setInt(5, hotel.getK_hotel());

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
            throw new Exception("Hotel no encontrado");
        }
    }
}
