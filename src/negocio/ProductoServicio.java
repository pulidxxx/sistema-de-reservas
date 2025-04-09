package negocio;

public class ProductoServicio {

    private int k_producto;
    private String n_producto;
    private int v_precioUnitario;
    private String i_tipo;

    public int getK_producto() {
        return k_producto;
    }

    public String getN_producto() {
        return n_producto;
    }

    public int getV_precioUnitario() {
        return v_precioUnitario;
    }

    public String getI_tipo() {
        return i_tipo;
    }

    public void setK_producto(int k_producto) {
        this.k_producto = k_producto;
    }

    public void setN_producto(String n_producto) {
        this.n_producto = n_producto;
    }

    public void setV_precioUnitario(int v_precioUnitario) {
        this.v_precioUnitario = v_precioUnitario;
    }

    public void setI_tipo(String i_tipo) {
        this.i_tipo = i_tipo;
    }
}
