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
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class PropietarioBO {

    private HttpClient cliente;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String url;
    private ObjectMapper mapper;

    public PropietarioBO() {
        //OJO, esto debe leerse de un .properties
        this.url = "http://localhost:8080/TransitSoftBusinessServidorWS/resources/Propietarios";
    }

    public Integer insertar(String dni, String nombres, String apellidos, String direccion) throws JsonProcessingException, IOException, InterruptedException {
        this.crearHttpClient();

        //EN BLANCO
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setDni(dni);
        propietarioDTO.setNombres(nombres);
        propietarioDTO.setApellidos(apellidos);
        propietarioDTO.setDireccion(direccion);

        //EN VERDE - serialización
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(propietarioDTO);

        this.crearHttpRequestPOST(jsonRequest);

        this.enviarRequest();

        //EN VERDE - deserialización
        PropietarioDTO propietarioRespuesta = mapper.readValue(response.body(), PropietarioDTO.class);
        this.cerrarHttpClient();

        if (response.statusCode() == Response.Status.CREATED.getStatusCode()) {
            return propietarioRespuesta.getId();
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

    public PropietarioDTO obtenerPorId(Integer id) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET(id);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NOT_FOUND.getStatusCode()) {
            return null;
        }
        PropietarioDTO propietarioDTORespuesta = this.deserializar(PropietarioDTO.class);
        return propietarioDTORespuesta;
    }

    public ArrayList<PropietarioDTO> listarTodos() throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<PropietarioDTO> listaPropietarios = this.deserializarListaDTO(new TypeReference<ArrayList<PropietarioDTO>>() {
        });
        return listaPropietarios;
    }

    public Integer modificar(Integer id, String dni, String nombres, String apellidos, String direccion) throws JsonProcessingException, IOException, InterruptedException{
        this.crearHttpClient();
        PropietarioDTO propietarioDTO = this.crearDTO(id, dni, nombres, apellidos, direccion);
        String jsonRequest = this.serializarDTO(propietarioDTO);
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
	
    private PropietarioDTO crearDTO(String dni, String nombres, String apellidos, String direccion) {
        Integer id = null;
        return this.crearDTO(id, dni, nombres, apellidos, direccion);
    }
    
    private PropietarioDTO crearDTO(Integer id, String dni, String nombres, String apellidos, String direccion) {
        //EN BLANCO
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setId(id);
        propietarioDTO.setDni(dni);
        propietarioDTO.setNombres(nombres);
        propietarioDTO.setApellidos(apellidos);
        propietarioDTO.setDireccion(direccion);
        return propietarioDTO;
    }

    private String serializarDTO(PropietarioDTO propietarioDTO) throws JsonProcessingException {
        //EN VERDE - serialización        
        String jsonRequest = this.mapper.writeValueAsString(propietarioDTO);
        return jsonRequest;
    }

    private PropietarioDTO deserializar(Class<PropietarioDTO> clase) throws JsonProcessingException {
        //EN VERDE - deserialización
        PropietarioDTO propietarioRespuesta = mapper.readValue(response.body(), clase);
        return propietarioRespuesta;
    }

    private ArrayList<PropietarioDTO> deserializarListaDTO(TypeReference<ArrayList<PropietarioDTO>> typeReference) throws JsonProcessingException {
        //EN VERDE - deserialización
        ArrayList<PropietarioDTO> listaPropietarios = this.mapper.readValue(this.response.body(), typeReference);
        return listaPropietarios;
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