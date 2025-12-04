package pe.edu.pucp.transitsoft.bo;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dao.PropietarioDAO;
import pe.edu.pucp.transitsoft.daoImp.PropietarioDAOImpl;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class PropietarioBO {

    private final PropietarioDAO propietarioDAO;
    
    public PropietarioBO(){
        this.propietarioDAO = new PropietarioDAOImpl();
    }
    
    public Integer insertar(Integer dni, String nombres, String apellidos, String direccion){
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setDni(dni);
        propietarioDTO.setNombres(nombres);
        propietarioDTO.setApellidos(apellidos);
        propietarioDTO.setDireccion(direccion);
        return this.propietarioDAO.insertar(propietarioDTO);
    }
    
    public PropietarioDTO obtenerPorId(Integer id){
        return this.propietarioDAO.obtenerPorId(id);
    }
    
    public ArrayList<PropietarioDTO> listarTodos(){
        return this.propietarioDAO.listarTodos();
    }
    
    public Integer modificar(Integer id, Integer dni, String nombres, String apellidos, String direccion){
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setId(id);
        propietarioDTO.setDni(dni);
        propietarioDTO.setNombres(nombres);
        propietarioDTO.setApellidos(apellidos);
        propietarioDTO.setDireccion(direccion);
        return this.propietarioDAO.modificar(propietarioDTO);
    }
    
    public Integer eliminar(Integer id){
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setId(id);
        return this.propietarioDAO.eliminar(propietarioDTO);
    }
}
