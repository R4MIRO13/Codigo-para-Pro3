package pe.edu.pucp.gamesoft.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@WebService(serviceName = "VideojuegoSOAPService")
public class VideojuegoSOAP {

    // URL base de los servicios REST
    private static final String REST_BASE = "http://localhost:8080/GameSoftWR/webresources";
    
    private Client client = ClientBuilder.newClient();

    // -------------------------------
    // Método SOAP para listar géneros
    // -------------------------------
    @WebMethod
    public String listarGeneros() {
        String url = REST_BASE + "/GeneroWR/listarTodos";
        return client.target(url)
                     .request(MediaType.APPLICATION_JSON)
                     .get(String.class); // devuelve JSON como String
    }

    // -------------------------------------------
    // Método SOAP para insertar un videojuego
    // -------------------------------------------
    @WebMethod
    public String insertarVideojuego(
            @WebParam(name="idGenero") int idGenero,
            @WebParam(name="descripcionGenero") String descripcionGenero,
            @WebParam(name="categoria") String categoria,
            @WebParam(name="nombre") String nombre,
            @WebParam(name="fechaLanzamiento") String fechaLanzamiento,
            @WebParam(name="precioAproxMercado") double precio,
            @WebParam(name="numeroJugadoresMC") int numeroJugadoresMC) {

        String url = REST_BASE + "/VideojuegoWR/insertar";

        // Construir JSON para el POST
        String json = String.format(
            "{\"genero\":{\"idGenero\":%d,\"descripcion\":\"%s\"},\"categoria\":\"%s\",\"nombre\":\"%s\",\"fechaLanzamiento\":\"%s\",\"precioAproxMercado\":%.2f,\"numeroJugadoresMC\":%d}",
            idGenero, descripcionGenero, categoria, nombre, fechaLanzamiento, precio, numeroJugadoresMC
        );

        // Llamada POST al REST
        Response response = client.target(url)
                                  .request(MediaType.APPLICATION_JSON)
                                  .post(Entity.entity(json, MediaType.APPLICATION_JSON));

        return response.readEntity(String.class); // devuelve la respuesta del REST
    }
}