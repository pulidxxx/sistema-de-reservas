package negocio;

public class Cuenta_ProductoServicio {

    private int q_cantidad;
    private String f_consumo;
    private int k_numeroCuenta;
    private int k_producto;

    public int getQ_cantidad() {
        return q_cantidad;
    }

    public String getF_consumo() {
        return f_consumo;
    }

    public int getK_numeroCuenta() {
        return k_numeroCuenta;
    }

    public int getK_producto() {
        return k_producto;
    }

    public void setQ_cantidad(int q_cantidad) {
        this.q_cantidad = q_cantidad;
    }

    public void setF_consumo(String f_consumo) {
        this.f_consumo = f_consumo;
    }

    public void setK_numeroCuenta(int k_numeroCuenta) {
        this.k_numeroCuenta = k_numeroCuenta;
    }

    public void setK_producto(int k_producto) {
        this.k_producto = k_producto;
    }


}
