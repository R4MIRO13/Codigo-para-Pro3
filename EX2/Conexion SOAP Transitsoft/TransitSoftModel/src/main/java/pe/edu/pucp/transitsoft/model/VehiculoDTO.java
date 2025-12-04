package pe.edu.pucp.transitsoft.model;

public class VehiculoDTO {
    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anho;

    public VehiculoDTO() {
        this.id = null;
        this.placa = null;
        this.marca = null;
        this.modelo = null;
        this.anho = null;
    }

    public VehiculoDTO(Integer id, String placa, String marca, String modelo, Integer anho) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anho = anho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }
}
