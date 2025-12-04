package pe.edu.pucp.transitsoft.model;

public class PropietarioDTO {
    private Integer id;
    private Integer dni;
    private String nombres;
    private String apellidos;
    private String direccion;

    public PropietarioDTO() {
        this.id = null;
        this.dni = null;
        this.nombres = null;
        this.apellidos = null;
        this.direccion = null;
    }

    public PropietarioDTO(Integer id, Integer dni, String nombres, String apellidos, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
