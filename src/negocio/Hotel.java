package negocio;

public class Hotel {
    private int k_hotel;
    private int q_diasDescuento;
    private int t_descuento;
    private int t_aforo;
    private int q_capacidad;

    public int getK_hotel() {
        return k_hotel;
    }

    public int getQ_diasDescuento() {
        return q_diasDescuento;
    }

    public int getT_descuento() {
        return t_descuento;
    }

    public int getT_aforo() {
        return t_aforo;
    }

    public void setK_hotel(int k_hotel) {
        this.k_hotel = k_hotel;
    }

    public void setQ_diasDescuento(int q_diasDescuento) {
        this.q_diasDescuento = q_diasDescuento;
    }

    public void setT_descuento(int t_descuento) {
        this.t_descuento = t_descuento;
    }

    public void setT_aforo(int t_aforo) {
        this.t_aforo = t_aforo;
    }

    public int getQ_apacidad() {
        return q_capacidad;
    }

    public void setQ_capacidad(int capacidad) {
        this.q_capacidad = capacidad;
    }
}
