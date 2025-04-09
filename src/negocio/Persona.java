package negocio;

public class Persona {

    private String k_tipoDocumento;
    private Long k_numeroDocumento;
    private String n_primerNombre;
    private String n_segundoNombre;
    private String n_primerApellido;
    private String n_segundoApellido;

    public String getK_tipoDocumento() {
        return k_tipoDocumento;
    }

    public Long getK_numeroDocumento() {
        return k_numeroDocumento;
    }

    public String getN_primerNombre() {
        return n_primerNombre;
    }

    public String getN_segundoNombre() {
        return n_segundoNombre;
    }

    public String getN_primerApellido() {
        return n_primerApellido;
    }

    public String getN_segundoApellido() {
        return n_segundoApellido;
    }

    public void setK_tipoDocumento(String k_tipoDocumento) {
        this.k_tipoDocumento = k_tipoDocumento;
    }

    public void setK_numeroDocumento(Long k_numeroDocumento) {
        this.k_numeroDocumento = k_numeroDocumento;
    }

    public void setN_primerNombre(String n_primerNombre) {
        this.n_primerNombre = n_primerNombre;
    }

    public void setN_segundoNombre(String n_segundoNombre) {
        this.n_segundoNombre = n_segundoNombre;
    }

    public void setN_primerApellido(String n_primerApellido) {
        this.n_primerApellido = n_primerApellido;
    }

    public void setN_segundoApellido(String n_segundoApellido) {
        this.n_segundoApellido = n_segundoApellido;
    }

}
