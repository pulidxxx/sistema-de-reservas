package negocio;

public class Huesped {

    private String o_direccion;
    private int o_telefono;
    private String f_nacimiento;
    private String k_tipoDocumento;
    private Long k_numeroDocumento;

    public String getO_direccion() {
        return o_direccion;
    }

    public int getO_telefono() {
        return o_telefono;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public String getK_tipoDocumento() {
        return k_tipoDocumento;
    }

    public Long getK_numeroDocumento() {
        return k_numeroDocumento;
    }

    public void setO_direccion(String o_direccion) {
        this.o_direccion = o_direccion;
    }

    public void setO_telefono(int o_telefono) {
        this.o_telefono = o_telefono;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public void setK_tipoDocumento(String k_tipoDocumento) {
        this.k_tipoDocumento = k_tipoDocumento;
    }

    public void setK_numeroDocumento(Long k_numeroDocumento) {
        this.k_numeroDocumento = k_numeroDocumento;
    }

}
