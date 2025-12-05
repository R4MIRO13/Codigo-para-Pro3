package pe.edu.pucp.transitsoft.services.transitsoftws;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;

import pe.edu.pucp.transitsoft.bo.client.VehiculoBO;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

@WebService(serviceName = "Vehiculo")
public class Vehiculo {
    
    private VehiculoBO vehiculoBO;
    
    public Vehiculo(){
        this.vehiculoBO = new VehiculoBO();
    }
    
    @WebMethod(operationName = "insertarVehiculo")
    public Integer insertarVehiculo(@WebParam(name = "placa") String placa,
            @WebParam(name = "marca") String marca, 
            @WebParam(name = "modelo") String modelo,
            @WebParam(name = "anho") Integer anho) throws IOException, JsonProcessingException, InterruptedException {
        return this.vehiculoBO.insertar(placa, marca, modelo, anho);
    }

    @WebMethod(operationName = "modificarVehiculo")
    public Integer modificarVehiculo(@WebParam(name = "id") Integer id,
            @WebParam(name = "placa") String placa,
            @WebParam(name = "marca") String marca, 
            @WebParam(name = "modelo") String modelo,
            @WebParam(name = "anho") Integer anho) throws IOException, InterruptedException {
        return this.vehiculoBO.modificar(id, placa, marca, modelo, anho);
    }
    
    @WebMethod(operationName = "eliminarVehiculo")
    public Integer eliminarVehiculo(
            @WebParam(name = "id") Integer id) throws IOException, InterruptedException {

        return this.vehiculoBO.eliminar(id);
    }

    @WebMethod(operationName = "obtenerVehiculoPorId")
    public VehiculoDTO obtenerVehiculoPorId(
            @WebParam(name = "id") Integer id) throws IOException, InterruptedException {

        return this.vehiculoBO.obtenerPorId(id);
    }

    @WebMethod(operationName = "listarVehiculos")
    public ArrayList<VehiculoDTO> listarVehiculos() throws IOException, InterruptedException {
        return this.vehiculoBO.listarTodos();
    }
}