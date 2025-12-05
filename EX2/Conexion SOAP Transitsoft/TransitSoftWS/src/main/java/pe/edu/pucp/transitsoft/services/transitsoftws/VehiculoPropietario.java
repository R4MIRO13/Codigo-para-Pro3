package pe.edu.pucp.transitsoft.services.transitsoftws;

import java.util.ArrayList;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.transitsoft.bo.VehiculoPropietarioBO;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;
import pe.edu.pucp.transitsoft.model.VehiculoPropietarioDTO;

@WebService(serviceName = "VehiculoPropietario")
public class VehiculoPropietario {

    private final VehiculoPropietarioBO bo = new VehiculoPropietarioBO();

    // ===================== Consultas =====================
    @WebMethod(operationName = "listarVehiculosPorPropietario")
    public ArrayList<VehiculoDTO> listarVehiculosPorPropietario(
            @WebParam(name = "id_propietario") Integer id_propietario) {
        return bo.listarVehiculosPorPropietario(id_propietario);
    }

    @WebMethod(operationName = "listarPropietariosPorVehiculo")
    public ArrayList<PropietarioDTO> listarPropietariosPorVehiculo(
            @WebParam(name = "id_vehiculo") Integer id_vehiculo) {
        return bo.listarPropietariosPorVehiculo(id_vehiculo);
    }

    @WebMethod(operationName = "listarRelaciones")
    public ArrayList<VehiculoPropietarioDTO> listarTodos() {
        return bo.listarTodos();
    }

    @WebMethod(operationName = "obtenerRelacionPorId")
    public VehiculoPropietarioDTO obtenerPorId(@WebParam(name = "id") Integer id) {
        return bo.obtenerPorId(id);
    }

    // ===================== Operaciones de modificación =====================
    @WebMethod(operationName = "insertarRelacion")
    public Integer insertar(@WebParam(name = "id_vehiculo") Integer id_vehiculo,
                            @WebParam(name = "id_propietario") Integer id_propietario) {
        return bo.insertar(id_vehiculo, id_propietario);
    }

    @WebMethod(operationName = "modificarRelacion")
    public Integer modificar(@WebParam(name = "id") Integer id,
                             @WebParam(name = "id_vehiculo") Integer id_vehiculo,
                             @WebParam(name = "id_propietario") Integer id_propietario) {
        return bo.modificar(id, id_vehiculo, id_propietario);
    }

    @WebMethod(operationName = "eliminarRelacion")
    public Integer eliminar(@WebParam(name = "id") Integer id) {
        return bo.eliminar(id);
    }
}