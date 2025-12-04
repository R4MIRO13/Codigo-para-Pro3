package pe.edu.pucp.transitsoft.model;

import java.time.LocalDateTime;

public class CapturaDTO {
    private Integer id;
    private CamaraDTO camara;
    private String placa;
    private Double velocidad;
    private LocalDateTime fecha_captura;
    private String estado;

    public CapturaDTO() {
        this.id = null;
        this.camara = null;
        this.placa = null;
        this.velocidad = null;
        this.fecha_captura = null;
        this.estado = null;
    }

    public CapturaDTO(Integer id, CamaraDTO camara, String placa, Double velocidad, LocalDateTime fecha_captura, String estado) {
        this.id = id;
        this.camara = camara;
        this.placa = placa;
        this.velocidad = velocidad;
        this.fecha_captura = fecha_captura;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CamaraDTO getCamara() {
        return camara;
    }

    public void setCamara(CamaraDTO camara) {
        this.camara = camara;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public LocalDateTime getFecha_captura() {
        return fecha_captura;
    }

    public void setFecha_captura(LocalDateTime fecha_captura) {
        this.fecha_captura = fecha_captura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
