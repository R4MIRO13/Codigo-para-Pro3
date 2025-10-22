using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransitSoftModel
{
    public class CamaraDTO
    {
        private int? id;
        private string modelo;
        private string codigoSerie;
        private long? latitud;
        private long? longitud;

        public CamaraDTO()
        {
            this.Id = null;
            this.Modelo = null;
            this.CodigoSerie = null;
            this.Latitud = null;
            this.Longitud = null;
        }

        public CamaraDTO(int? id, string modelo, string codigoSerie, long? latitud, long? longitud)
        {
            this.Id = id;
            this.Modelo = modelo;
            this.CodigoSerie = codigoSerie;
            this.Latitud = latitud;
            this.Longitud = longitud;
        }

        public int? Id { get => id; set => id = value; }
        public string Modelo { get => modelo; set => modelo = value; }
        public string CodigoSerie { get => codigoSerie; set => codigoSerie = value; }
        public long? Latitud { get => latitud; set => latitud = value; }
        public long? Longitud { get => longitud; set => longitud = value; }
    }
}
