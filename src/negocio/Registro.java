package negocio;

public class Registro {

    private int k_numeroRegistro;
    private String f_entrada;
    private String f_salida;
    private String k_tipoDocumento;
    private int k_numeroDocumento;
    private int k_reserva;

    public int getK_numeroRegistro() {
        return k_numeroRegistro;
    }

    public String getF_entrada() {
        return f_entrada;
    }

    public String getF_salida() {
        return f_salida;
    }

    public String getK_tipoDocumento() {
        return k_tipoDocumento;
    }

    public int getK_numeroDocumento() {
        return k_numeroDocumento;
    }

    public int getK_reserva() {
        return k_reserva;
    }

    public void setK_numeroRegistro(int k_numeroRegistro) {
        this.k_numeroRegistro = k_numeroRegistro;
    }

    public void setF_entrada(String f_entrada) {
        this.f_entrada = f_entrada;
    }

    public void setF_salida(String f_salida) {
        this.f_salida = f_salida;
    }

    public void setK_tipoDocumento(String k_tipoDocumento) {
        this.k_tipoDocumento = k_tipoDocumento;
    }

    public void setK_numeroDocumento(int k_numeroDocumento) {
        this.k_numeroDocumento = k_numeroDocumento;
    }

    public void setK_reserva(int k_reserva) {
        this.k_reserva = k_reserva;
    }

}
