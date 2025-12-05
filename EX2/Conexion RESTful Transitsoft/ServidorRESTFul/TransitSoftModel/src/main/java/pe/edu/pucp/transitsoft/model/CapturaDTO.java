package pe.edu.pucp.transitsoft.model;

import java.time.LocalDateTime;

public class CapturaDTO {
    private Integer id;
    private Integer id_camara;
    private String placa;
    private Double velocidad;
    private LocalDateTime fecha_captura;
    private String estado;

    public CapturaDTO() {
        this.id = null;
        this.id_camara = null;
        this.placa = null;
        this.velocidad = null;
        this.fecha_captura = null;
        this.estado = null;
    }

    public CapturaDTO(Integer id, Integer id_camara, String placa, Double velocidad, LocalDateTime fecha_captura, String estado) {
        this.id = id;
        this.id_camara = id_camara;
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

    public Integer getId_camara() {
        return id_camara;
    }

    public void setId_camara(Integer id_camara) {
        this.id_camara = id_camara;
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
