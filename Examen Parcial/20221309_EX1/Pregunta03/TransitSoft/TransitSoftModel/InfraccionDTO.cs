using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransitSoftModel
{
    public class InfraccionDTO
    {
        private string placa;
        private double? velocidad;
        private double? limite;
        private double? exceso;
        private string marcaVehiculo;
        private string modeloVehiculo;
        private int? anhoVehiculo;
        private string dniPropietario;
        private string nombresPropietario;
        private string apellidosPropietario;
        private string direccionPropietario;
        private string modeloCamara;
        private string codigoSerieCamara;
        private long? latitud;
        private long? longitud;
        private double? monto;
        private DateTime? fechaCaptura;
        private DateTime? fechaRegistro;

        public InfraccionDTO()
        {
            this.Placa = null;
            this.Velocidad = null;
            this.Limite = null;
            this.Exceso = null;
            this.MarcaVehiculo = null;
            this.ModeloVehiculo = null;
            this.AnhoVehiculo = null;
            this.DniPropietario = null;
            this.NombresPropietario = null;
            this.ApellidosPropietario = null;
            this.DireccionPropietario = null;
            this.ModeloCamara = null;
            this.CodigoSerieCamara = null;
            this.Latitud = null;
            this.Longitud = null;
            this.Monto = null;
            this.FechaCaptura = null;
            this.FechaRegistro = null;
        }

        public InfraccionDTO(string placa, double? velocidad, double? limite, double? exceso, string marcaVehiculo, string modeloVehiculo, int? anhoVehiculo, string dniPropietario, string nombresPropietario, string apellidosPropietario, string direccionPropietario, string modeloCamara, string codigoSerieCamara, long? latitud, long? longitud, double? monto, DateTime? fechaCaptura, DateTime? fechaRegistro)
        {
            this.Placa = placa;
            this.Velocidad = velocidad;
            this.Limite = limite;
            this.Exceso = exceso;
            this.MarcaVehiculo = marcaVehiculo;
            this.ModeloVehiculo = modeloVehiculo;
            this.AnhoVehiculo = anhoVehiculo;
            this.DniPropietario = dniPropietario;
            this.NombresPropietario = nombresPropietario;
            this.ApellidosPropietario = apellidosPropietario;
            this.DireccionPropietario = direccionPropietario;
            this.ModeloCamara = modeloCamara;
            this.CodigoSerieCamara = codigoSerieCamara;
            this.Latitud = latitud;
            this.Longitud = longitud;
            this.Monto = monto;
            this.FechaCaptura = fechaCaptura;
            this.FechaRegistro = fechaRegistro;
        }

        public string Placa { get => placa; set => placa = value; }
        public double? Velocidad { get => velocidad; set => velocidad = value; }
        public double? Limite { get => limite; set => limite = value; }
        public double? Exceso { get => exceso; set => exceso = value; }
        public string MarcaVehiculo { get => marcaVehiculo; set => marcaVehiculo = value; }
        public string ModeloVehiculo { get => modeloVehiculo; set => modeloVehiculo = value; }
        public int? AnhoVehiculo { get => anhoVehiculo; set => anhoVehiculo = value; }
        public string DniPropietario { get => dniPropietario; set => dniPropietario = value; }
        public string NombresPropietario { get => nombresPropietario; set => nombresPropietario = value; }
        public string ApellidosPropietario { get => apellidosPropietario; set => apellidosPropietario = value; }
        public string DireccionPropietario { get => direccionPropietario; set => direccionPropietario = value; }
        public string ModeloCamara { get => modeloCamara; set => modeloCamara = value; }
        public string CodigoSerieCamara { get => codigoSerieCamara; set => codigoSerieCamara = value; }
        public long? Latitud { get => latitud; set => latitud = value; }
        public long? Longitud { get => longitud; set => longitud = value; }
        public double? Monto { get => monto; set => monto = value; }
        public DateTime? FechaCaptura { get => fechaCaptura; set => fechaCaptura = value; }
        public DateTime? FechaRegistro { get => fechaRegistro; set => fechaRegistro = value; }
    }
}
