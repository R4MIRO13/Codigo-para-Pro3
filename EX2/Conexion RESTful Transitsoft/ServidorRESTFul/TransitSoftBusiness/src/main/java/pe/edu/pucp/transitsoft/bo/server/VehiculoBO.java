package pe.edu.pucp.transitsoft.bo.server;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dao.VehiculoDAO;
import pe.edu.pucp.transitsoft.daoImp.VehiculoDAOImpl;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoBO {

    private final VehiculoDAO vehiculoDAO;
    
    public VehiculoBO(){
        this.vehiculoDAO = new VehiculoDAOImpl();
    }
    
    public Integer insertar(VehiculoDTO vehiculoDTO){
        return this.vehiculoDAO.insertar(vehiculoDTO);
    }
    
    public VehiculoDTO obtenerPorId(Integer id){
        return this.vehiculoDAO.obtenerPorId(id);
    }
    
    public ArrayList<VehiculoDTO> listarTodos(){
        return this.vehiculoDAO.listarTodos();
    }
    
    public Integer modificar(VehiculoDTO vehiculoDTO){
        return this.vehiculoDAO.modificar(vehiculoDTO);
    }
    
    public Integer eliminar(Integer id){
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setId(id);
        return this.vehiculoDAO.eliminar(vehiculoDTO);
    }
}
