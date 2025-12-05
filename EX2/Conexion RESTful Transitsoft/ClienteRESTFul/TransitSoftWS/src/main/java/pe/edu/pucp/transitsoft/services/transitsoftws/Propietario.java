package pe.edu.pucp.transitsoft.services.transitsoftws;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;

import pe.edu.pucp.transitsoft.bo.client.PropietarioBO;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

@WebService(serviceName = "Propietarios")
public class Propietario {
    
    private PropietarioBO propietarioBO;
    
    public Propietario(){
        this.propietarioBO = new PropietarioBO();
    }
    
    @WebMethod(operationName = "insertarPropietario")
    public Integer insertarPropietario(@WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres, 
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "direccion") String direccion) throws IOException, JsonProcessingException, InterruptedException {
        return this.propietarioBO.insertar(dni, nombres, apellidos, direccion);
    }

    @WebMethod(operationName = "modificarPropietario")
    public Integer modificarPropietario(@WebParam(name = "id") Integer id,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres, 
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "direccion") String direccion) throws IOException, InterruptedException {
        return this.propietarioBO.modificar(id, dni, nombres, apellidos, direccion);
    }
    
    @WebMethod(operationName = "obtenerPropietarioPorId")
    public PropietarioDTO obtenerPropietarioPorId(
            @WebParam(name = "id") Integer id) throws IOException, InterruptedException {

        return propietarioBO.obtenerPorId(id);
    }

    @WebMethod(operationName = "listarPropietarios")
    public ArrayList<PropietarioDTO> listarPropietarios() throws IOException, InterruptedException {
        return propietarioBO.listarTodos();
    }

    @WebMethod(operationName = "eliminarPropietario")
    public Integer eliminarPropietario(@WebParam(name = "id") Integer id) throws IOException, InterruptedException {
        return propietarioBO.eliminar(id);
    }
}