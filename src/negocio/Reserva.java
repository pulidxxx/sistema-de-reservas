package negocio;

/**
 * Clase que encapsula los datos de la reserva.
 */

public class Reserva {
    private int k_reserva;
    private String f_inicio;
    private String f_fin;
    private String f_reserva;
    private int q_nochesReservadas;
    private int q_numeroPersonas;
    private double v_precioEstadia;
    private String i_estado;
    private int k_numeroHabitacion;
    private String k_tipoDocumento;
    private Long k_numeroDocumento;

    public int getK_reserva() {
        return k_reserva;
    }

    public void setK_reserva(int idReserva) {
        this.k_reserva = idReserva;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public String getF_fin() {
        return f_fin;
    }

    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    public String getF_reserva() {
        return f_reserva;
    }

    public void setF_reserva(String f_reserva) {
        this.f_reserva = f_reserva;
    }

    public int getQ_nochesReservadas() {
        return q_nochesReservadas;
    }

    public void setQ_nochesReservadas(int q_nochesReservadas) {
        this.q_nochesReservadas = q_nochesReservadas;
    }

    public int getQ_numeroPersonas() {
        return q_numeroPersonas;
    }

    public void setQ_numeroPersonas(int q_numeroPersonas) {
        this.q_numeroPersonas = q_numeroPersonas;
    }

    public double getV_precioEstadia() {
        return v_precioEstadia;
    }

    public void setV_precioEstadia(double v_precioEstadia) {
        this.v_precioEstadia = v_precioEstadia;
    }

    public String getI_estado() {
        return i_estado;
    }

    public void setI_estado(String i_estado) {
        this.i_estado = i_estado;
    }

    public int getK_numeroHabitacion() {
        return k_numeroHabitacion;
    }

    public void setK_numeroHabitacion(int k_numeroHabitacion) {
        this.k_numeroHabitacion = k_numeroHabitacion;
    }

    public String getK_tipoDocumento() {
        return k_tipoDocumento;
    }

    public void setK_tipoDocumento(String k_tipoDocumento) {
        this.k_tipoDocumento = k_tipoDocumento;
    }

    public Long getK_numeroDocumento() {
        return k_numeroDocumento;
    }

    public void setK_numeroDocumento(Long k_numeroDocumento) {
        this.k_numeroDocumento = k_numeroDocumento;
    }
}
