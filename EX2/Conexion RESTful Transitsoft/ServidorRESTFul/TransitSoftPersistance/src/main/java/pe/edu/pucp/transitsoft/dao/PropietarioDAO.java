package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

import java.util.ArrayList;

public interface PropietarioDAO {
    
    public Integer insertar(PropietarioDTO propietario);
    
    public PropietarioDTO obtenerPorId(Integer id);
    
    public ArrayList<PropietarioDTO> listarTodos();
    
    public Integer modificar(PropietarioDTO propietario);
    
    public Integer eliminar(PropietarioDTO propietario);
}