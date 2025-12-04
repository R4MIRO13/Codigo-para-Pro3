package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

import java.util.ArrayList;

public interface VehiculoDAO {
    
    public Integer insertar(VehiculoDTO vehiculo);
    
    public VehiculoDTO obtenerPorId(Integer id);
    
    public ArrayList<VehiculoDTO> listarTodos();
    
    public Integer modificar(VehiculoDTO vehiculo);
    
    public Integer eliminar(VehiculoDTO vehiculo);
}