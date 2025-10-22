using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransitSoftModel
{
    public class CapturaDTO
    {
        private int? id;
        private string placa;
        private double? velocidad;
        private DateTime? fechaCaptura;
        private CamaraDTO camara;
        private EstadoCapturaDTO? estado;
        private VehiculoDTO vehiculo;

        public CapturaDTO()
        {
            this.Id = null;
            this.Placa = null;
            this.Velocidad = null;
            this.FechaCaptura = null;
            this.Camara = null;
            this.Estado = null;
            this.Vehiculo = null;
        }

        public CapturaDTO(int? id, string placa, double? velocidad, DateTime? fechaCaptura, CamaraDTO camara, EstadoCapturaDTO? estado, VehiculoDTO vehiculo)
        {
            this.Id = id;
            this.Placa = placa;
            this.Velocidad = velocidad;
            this.FechaCaptura = fechaCaptura;
            this.Camara = camara;
            this.Estado = estado;
            this.Vehiculo = vehiculo;
        }

        public int? Id { get => id; set => id = value; }
        public string Placa { get => placa; set => placa = value; }
        public double? Velocidad { get => velocidad; set => velocidad = value; }
        public DateTime? FechaCaptura { get => fechaCaptura; set => fechaCaptura = value; }
        public CamaraDTO Camara { get => camara; set => camara = value; }
        public EstadoCapturaDTO? Estado { get => estado; set => estado = value; }
        public VehiculoDTO Vehiculo { get => vehiculo; set => vehiculo = value; }
    }
}
