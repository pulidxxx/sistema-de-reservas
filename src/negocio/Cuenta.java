package negocio;

public class Cuenta {
    private int k_numeroCuenta;
    private String i_estado;
    private int v_valorConsumo;
    private int k_reserva;

    public int getK_numeroCuenta() {
        return k_numeroCuenta;
    }

    public String getI_estado() {
        return i_estado;
    }

    public int getV_valorConsumo() {
        return v_valorConsumo;
    }

    public int getK_reserva() {
        return k_reserva;
    }

    public void setK_numeroCuenta(int k_numeroCuenta) {
        this.k_numeroCuenta = k_numeroCuenta;
    }

    public void setI_estado(String i_estado) {
        this.i_estado = i_estado;
    }

    public void setV_valorConsumo(int v_valorConsumo) {
        this.v_valorConsumo = v_valorConsumo;
    }

    public void setK_reserva(int k_reserva) {
        this.k_reserva = k_reserva;
    }

    
}
