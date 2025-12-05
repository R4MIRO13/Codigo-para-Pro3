package pe.edu.pucp.transitsoft.services.transitsoftws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

import pe.edu.pucp.transitsoft.bo.PropietarioBO;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

@WebService(serviceName = "Propietario")
public class Propietario {
    
    private PropietarioBO propietarioBO;
    
    public Propietario(){
        this.propietarioBO = new PropietarioBO();
    }
    
    @WebMethod(operationName = "insertarPropietario")
    public Integer insertarPropietario(@WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres, 
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "direccion") String direccion) {
        return this.propietarioBO.insertar(dni, nombres, apellidos, direccion);
    }

    @WebMethod(operationName = "modificarPropietario")
    public Integer modificarPropietario(@WebParam(name = "id") Integer id,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres, 
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "direccion") String direccion) {
        return this.propietarioBO.modificar(id, dni, nombres, apellidos, direccion);
    }
    
    @WebMethod(operationName = "obtenerPropietarioPorId")
    public PropietarioDTO obtenerPropietarioPorId(
            @WebParam(name = "id") Integer id) {

        return propietarioBO.obtenerPorId(id);
    }

    @WebMethod(operationName = "listarPropietarios")
    public ArrayList<PropietarioDTO> listarPropietarios() {
        return propietarioBO.listarTodos();
    }

    @WebMethod(operationName = "eliminarPropietario")
    public Integer eliminarPropietario(@WebParam(name = "id") Integer id) {
        return propietarioBO.eliminar(id);
    }
}