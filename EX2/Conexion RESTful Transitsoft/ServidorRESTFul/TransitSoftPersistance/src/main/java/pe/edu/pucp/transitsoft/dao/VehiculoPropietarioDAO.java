package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;
import pe.edu.pucp.transitsoft.model.VehiculoPropietarioDTO;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

public interface VehiculoPropietarioDAO {

    public Integer insertar(VehiculoPropietarioDTO vehiculoPropietario);
    
    public VehiculoPropietarioDTO obtenerPorId(Integer id);
    
    public ArrayList<VehiculoPropietarioDTO> listarTodos();
    
    public Integer modificar(VehiculoPropietarioDTO vehiculoPropietario);
    
    public Integer eliminar(VehiculoPropietarioDTO vehiculoPropietario);
    
    public ArrayList<VehiculoDTO> listarVehiculosPorPropietario(Integer id_propietario);
    
    public ArrayList<PropietarioDTO> listarPropietariosPorVehiculo(Integer id_vehiculo);
}
