package pe.edu.pucp.transitsoft.bo.server;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dao.VehiculoPropietarioDAO;
import pe.edu.pucp.transitsoft.daoImp.VehiculoPropietarioDAOImpl;
import pe.edu.pucp.transitsoft.model.VehiculoPropietarioDTO;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class VehiculoPropietarioBO {

    private final VehiculoPropietarioDAO vehiculoPropietarioDAO;
    
    public VehiculoPropietarioBO(){
        this.vehiculoPropietarioDAO = new VehiculoPropietarioDAOImpl();
    }
    
    public Integer insertar(VehiculoPropietarioDTO vehiculoPropietarioDTO){
        return this.vehiculoPropietarioDAO.insertar(vehiculoPropietarioDTO);
    }
    
    public VehiculoPropietarioDTO obtenerPorId(Integer id){
        return this.vehiculoPropietarioDAO.obtenerPorId(id);
    }
    
    public ArrayList<VehiculoPropietarioDTO> listarTodos(){
        return this.vehiculoPropietarioDAO.listarTodos();
    }
    
    public Integer modificar(VehiculoPropietarioDTO vehiculoPropietarioDTO){
        return this.vehiculoPropietarioDAO.modificar(vehiculoPropietarioDTO);
    }
    
    public Integer eliminar(Integer id){
        VehiculoPropietarioDTO vehiculoPropietarioDTO = new VehiculoPropietarioDTO();
        vehiculoPropietarioDTO.setId(id);
        return this.vehiculoPropietarioDAO.eliminar(vehiculoPropietarioDTO);
    }
	
    public ArrayList<VehiculoDTO> listarVehiculosPorPropietario(Integer id_propietario){
        return this.vehiculoPropietarioDAO.listarVehiculosPorPropietario(id_propietario);
    }
    
    public ArrayList<PropietarioDTO> listarPropietariosPorVehiculo(Integer id_vehiculo){
        return this.vehiculoPropietarioDAO.listarPropietariosPorVehiculo(id_vehiculo);
    }
}
