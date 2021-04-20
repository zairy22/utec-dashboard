package utec.dashboard.dto;

public class Usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String codigoEmpleado;
    private int tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Usuario(int id, String nombre, String usuario, String codigoEmpleado, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.codigoEmpleado = codigoEmpleado;
        this.tipo = tipo;
    }
}
