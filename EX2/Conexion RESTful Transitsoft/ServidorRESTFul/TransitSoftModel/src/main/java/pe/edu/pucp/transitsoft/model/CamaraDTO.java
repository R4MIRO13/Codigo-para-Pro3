package pe.edu.pucp.transitsoft.model;

public class CamaraDTO {
    private Integer id;
    private String modelo;
    private String codigo_serie;
    private Integer latitud;
    private Integer longitud;

    public CamaraDTO() {
        this.id = null;
        this.modelo = null;
        this.codigo_serie = null;
        this.latitud = null;
        this.longitud = null;
    }

    public CamaraDTO(Integer id, String modelo, String codigo_serie, Integer latitud, Integer longitud) {
        this.id = id;
        this.modelo = modelo;
        this.codigo_serie = codigo_serie;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigo_serie() {
        return codigo_serie;
    }

    public void setCodigo_serie(String codigo_serie) {
        this.codigo_serie = codigo_serie;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }
}
