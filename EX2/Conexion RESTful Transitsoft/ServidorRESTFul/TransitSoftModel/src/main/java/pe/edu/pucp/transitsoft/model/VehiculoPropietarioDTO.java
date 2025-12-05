package pe.edu.pucp.transitsoft.model;

public class VehiculoPropietarioDTO {
    private Integer id;
    private Integer id_vehiculo;
    private Integer id_propietario;

    public VehiculoPropietarioDTO() {
        this.id = null;
        this.id_vehiculo = null;
        this.id_propietario = null;
    }

    public VehiculoPropietarioDTO(Integer id, Integer id_vehiculo, Integer id_propietario) {
        this.id = id;
        this.id_vehiculo = id_vehiculo;
        this.id_propietario = id_propietario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Integer getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Integer id_propietario) {
        this.id_propietario = id_propietario;
    }
}
