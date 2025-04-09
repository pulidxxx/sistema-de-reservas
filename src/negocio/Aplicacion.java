package negocio;

import datos.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Clase controladora de la aplicación
 */
public class Aplicacion {

    private ReservaDAO reservaDAO;
    private Reserva reserva;
    private HabitacionDAO habitacionDAO;
    private Hotel hotel;
    private HotelDAO hotelDAO;
    private TipoDAO tipoDAO;
    private RegistroDAO registroDAO;
    private PersonaDAO personaDAO;
    private Huesped huesped;
    Persona persona;

    public Aplicacion() {
        reservaDAO = new ReservaDAO();
        habitacionDAO = new HabitacionDAO();
        personaDAO = new PersonaDAO();
        registroDAO = new RegistroDAO();
        hotelDAO = new HotelDAO();
        tipoDAO = new TipoDAO();
    }

    public void agregarReserva(String fInicio, String fFin, int noches, int numPersonas,
            double precioEstadia, int numHabitacion, String tipoDoc, Long k_numDoc) throws Exception {
        reserva = new Reserva();
        reserva.setF_inicio(fInicio);
        reserva.setF_fin(fFin);
        reserva.setF_reserva(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        reserva.setQ_nochesReservadas(noches);
        reserva.setQ_numeroPersonas(numPersonas);
        reserva.setV_precioEstadia(precioEstadia);
        reserva.setI_estado("pendiente");
        reserva.setK_numeroHabitacion(numHabitacion);
        reserva.setK_tipoDocumento(tipoDoc);
        reserva.setK_numeroDocumento(k_numDoc);

        reservaDAO.agregarReserva(reserva);
    }

    public Reserva getReserva(int id) throws Exception {
        return reservaDAO.getReserva(id);
    }

    public void cambiarEstadoReserva(int id, String estado) throws Exception {
        reserva = new Reserva();
        reserva.setK_reserva(id);
        reserva.setI_estado(estado);

        reservaDAO.cambiarEstadoReserva(reserva);
    }

    public void cancelarReserva(int k_reserva) throws Exception {
        reservaDAO.cancelarReserva(k_reserva);
    }

    public String[] buscarReservas(Long k_numerodocumento, String k_tipodocumento) throws Exception {
        return reservaDAO.buscarReservas(k_numerodocumento, k_tipodocumento);
    }

    public String[] buscarNombres(String coincidencia) throws Exception {
        return reservaDAO.obtenerCoincidencias(coincidencia);
    }

    public Habitacion getHabitacionDisponible(String tipo, String f_inicio, String f_fin) throws Exception {
        return habitacionDAO.getHabitacionDisponible(tipo, f_inicio, f_fin);
    }

    public Hotel getHotel(int id) throws Exception {
        return hotelDAO.getHotel(id);
    }

    public Tipo getTipo(String id) throws Exception {
        return tipoDAO.getTipo(id);
    }

    public int getTotalPersonas(String f_inicio, String f_fin) throws Exception {
        return reservaDAO.getTotalPersonas(f_inicio, f_fin);
    }

    public void agregarPersona(String k_tipoDoc, Long k_numDoc, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido) throws Exception {
        persona = new Persona();
        persona.setK_tipoDocumento(k_tipoDoc);
        persona.setK_numeroDocumento(k_numDoc);
        persona.setN_primerNombre(primerNombre);
        persona.setN_segundoNombre(segundoNombre);
        persona.setN_primerApellido(primerApellido);
        persona.setN_segundoApellido(segundoApellido);

        personaDAO.agregarPersona(persona);
    }

    public Persona getPersona(Long id, String tipoDocumento) throws Exception {
        return personaDAO.consultarPersona(id, tipoDocumento);
    }

    public void agregarHuesped(String o_direccion, int o_telefono, String f_nacimiento, String k_tipoDocumento, Long k_numeroDocumento) throws Exception {

        huesped = new Huesped();

        huesped.setO_direccion(o_direccion);
        huesped.setO_telefono(o_telefono);
        huesped.setF_nacimiento(f_nacimiento);
        huesped.setK_tipoDocumento(k_tipoDocumento);
        huesped.setK_numeroDocumento(k_numeroDocumento);

        registroDAO.checkIn(huesped);
    }

    public void actualizarHotel(int id, int diasDescuento, int descuento, int aforo, int capacidad) throws Exception {
        hotel = new Hotel();
        hotel.setK_hotel(id);
        hotel.setQ_diasDescuento(diasDescuento);
        hotel.setT_descuento(descuento);
        hotel.setT_aforo(aforo);
        hotel.setQ_capacidad(capacidad);

        hotelDAO.actualizarHotel(hotel);
    }

    public Persona obtenerPersona(String nombre) throws Exception {
        return personaDAO.obtenerPersona(nombre);
    }

}
