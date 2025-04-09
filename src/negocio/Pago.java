package negocio;

public class Pago {

    private int k_pago;
    private String f_pago;
    private String n_formapago;
    private int v_totalPagado;
    private int k_numeroCuenta;

    public int getK_pago() {
        return k_pago;
    }

    public String getF_pago() {
        return f_pago;
    }

    public String getN_formapago() {
        return n_formapago;
    }

    public int getV_totalPagado() {
        return v_totalPagado;
    }

    public int getK_numeroCuenta() {
        return k_numeroCuenta;
    }

    public void setK_pago(int k_pago) {
        this.k_pago = k_pago;
    }

    public void setF_pago(String f_pago) {
        this.f_pago = f_pago;
    }

    public void setN_formapago(String n_formapago) {
        this.n_formapago = n_formapago;
    }

    public void setV_totalPagado(int v_totalPagado) {
        this.v_totalPagado = v_totalPagado;
    }

    public void setK_numeroCuenta(int k_numeroCuenta) {
        this.k_numeroCuenta = k_numeroCuenta;
    }

}
