package pe.edu.pucp.transitsoft.bo.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoBO {

    private HttpClient cliente;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String url;
    private ObjectMapper mapper;

    public VehiculoBO() {
        //OJO, esto debe leerse de un .properties
        this.url = "http://localhost:8080/TransitSoftBusinessServidorWS/resources/Vehiculos";
    }

    public Integer insertar(String placa, String marca, String modelo, Integer anho) throws JsonProcessingException, IOException, InterruptedException {
        this.crearHttpClient();

        //EN BLANCO
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setPlaca(placa);
        vehiculoDTO.setMarca(marca);
        vehiculoDTO.setModelo(modelo);
        vehiculoDTO.setAnho(anho);

        //EN VERDE - serialización
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(vehiculoDTO);

        this.crearHttpRequestPOST(jsonRequest);

        this.enviarRequest();

        //EN VERDE - deserialización
        VehiculoDTO vehiculoRespuesta = mapper.readValue(response.body(), VehiculoDTO.class);
        this.cerrarHttpClient();

        if (response.statusCode() == Response.Status.CREATED.getStatusCode()) {
            return vehiculoRespuesta.getId();
        }
        return 0;
    }

    public Integer eliminar(Integer id) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestDELETE(id);
        this.enviarRequest();
        this.cerrarHttpClient();

        if (this.response.statusCode() == Response.Status.NO_CONTENT.getStatusCode()) {
            return id;
        }
        return 0;
    }

    public VehiculoDTO obtenerPorId(Integer id) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET(id);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NOT_FOUND.getStatusCode()) {
            return null;
        }
        VehiculoDTO vehiculoDTORespuesta = this.deserializar(VehiculoDTO.class);
        return vehiculoDTORespuesta;
    }

    public ArrayList<VehiculoDTO> listarTodos() throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<VehiculoDTO> listaVehiculos = this.deserializarListaDTO(new TypeReference<ArrayList<VehiculoDTO>>() {
        });
        return listaVehiculos;
    }

    public Integer modificar(Integer id, String placa, String marca, String modelo, Integer anho) throws JsonProcessingException, IOException, InterruptedException{
        this.crearHttpClient();
        VehiculoDTO vehiculoDTO = this.crearDTO(id, placa, marca, modelo, anho);
        String jsonRequest = this.serializarDTO(vehiculoDTO);
        this.crearHttpRequestPUT(jsonRequest);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.OK.getStatusCode())
            return id;
        return 0;
    }

    private void crearHttpClient() {
        //EN ROJO
        this.cliente = HttpClient.newHttpClient();
    }

    private void cerrarHttpClient() {
        this.cliente.close();
    }

    private void crearHttpRequestDELETE(Integer id) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url + "/" + id))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }

    private void crearHttpRequestPOST(String jsonRequest) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void enviarRequest() throws IOException, InterruptedException {
        //EN NEGRO -> envio
        this.response = this.cliente.send(this.request, HttpResponse.BodyHandlers.ofString());
    }
	
    private VehiculoDTO crearDTO(String placa, String marca, String modelo, Integer anho) {
        Integer id = null;
        return this.crearDTO(id, placa, marca, modelo, anho);
    }
    
    private VehiculoDTO crearDTO(Integer id, String placa, String marca, String modelo, Integer anho) {
        //EN BLANCO
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setId(id);
        vehiculoDTO.setPlaca(placa);
        vehiculoDTO.setMarca(marca);
        vehiculoDTO.setModelo(modelo);
        vehiculoDTO.setAnho(anho);
        return vehiculoDTO;
    }

    private String serializarDTO(VehiculoDTO vehiculoDTO) throws JsonProcessingException {
        //EN VERDE - serialización        
        String jsonRequest = this.mapper.writeValueAsString(vehiculoDTO);
        return jsonRequest;
    }

    private VehiculoDTO deserializar(Class<VehiculoDTO> clase) throws JsonProcessingException {
        //EN VERDE - deserialización
        VehiculoDTO vehiculoRespuesta = mapper.readValue(response.body(), clase);
        return vehiculoRespuesta;
    }

    private ArrayList<VehiculoDTO> deserializarListaDTO(TypeReference<ArrayList<VehiculoDTO>> typeReference) throws JsonProcessingException {
        //EN VERDE - deserialización
        ArrayList<VehiculoDTO> listaVehiculos = this.mapper.readValue(this.response.body(), typeReference);
        return listaVehiculos;
    }

    private void crearHttpRequestGET() {
        Integer id = null;
        this.crearHttpRequestGET(id);
    }

    private void crearHttpRequestGET(Integer id) {
        //EN AZUL
        String URLGET = this.url;
        if (id != null) {
            URLGET = URLGET.concat("/" + id);
        }
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(URLGET))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    private void crearHttpRequestPUT(String jsonRequest) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }
}