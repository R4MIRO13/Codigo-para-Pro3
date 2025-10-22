using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransitSoftModel
{
    public class VehiculoDTO
    {
        private int? id;
        private string placa;
        private string marca;
        private string modelo;
        private int? anho;
        private PropietarioDTO propietario;

        public VehiculoDTO()
        {
            this.Id = null;
            this.Placa = null;
            this.Marca = null;
            this.Modelo = null;
            this.Anho = null;
            this.Propietario = null;
        }

        public VehiculoDTO(int? id, string placa, string marca, string modelo, int? anho, PropietarioDTO propietario)
        {
            this.Id = id;
            this.Placa = placa;
            this.Marca = marca;
            this.Modelo = modelo;
            this.Anho = anho;
            this.Propietario = propietario;
        }

        public override string ToString()
        {
            string cadena = "ID_VEHICULO: " + this.id.ToString() + " PLACA: " + this.placa +
                            " MARCA " + this.marca + " MODELO: " + this.modelo +
                            " AÑO: " + this.anho.ToString() + " ID_PROPIETARIO: " +
                            this.propietario.Id.ToString() + " DNI: " + this.propietario.Dni +
                            " NOMBRES: " + this.propietario.Nombres + " APELLIDOS: " +
                            this.propietario.Apellidos + " DIRECCIÓN: " + this.propietario.Direccion;
            return cadena;
        }

        public int? Id { get => id; set => id = value; }
        public string Placa { get => placa; set => placa = value; }
        public string Marca { get => marca; set => marca = value; }
        public string Modelo { get => modelo; set => modelo = value; }
        public int? Anho { get => anho; set => anho = value; }
        public PropietarioDTO Propietario { get => propietario; set => propietario = value; }
    }
}
