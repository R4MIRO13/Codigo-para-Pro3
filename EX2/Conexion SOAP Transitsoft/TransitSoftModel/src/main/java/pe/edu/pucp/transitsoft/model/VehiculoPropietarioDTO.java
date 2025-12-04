package pe.edu.pucp.transitsoft.model;

public class VehiculoPropietarioDTO {
    private Integer id;
    private VehiculoDTO vehiculo;
    private PropietarioDTO propietario;

    public VehiculoPropietarioDTO() {
        this.id = null;
        this.vehiculo = null;
        this.propietario = null;
    }

    public VehiculoPropietarioDTO(Integer id, VehiculoDTO vehiculo, PropietarioDTO propietario) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.propietario = propietario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public PropietarioDTO getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioDTO propietario) {
        this.propietario = propietario;
    }
}
