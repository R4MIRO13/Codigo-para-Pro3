using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TransitSoftBusiness.VehiculoWS; // <- Usa el namespace generado para tu WSDL de Vehiculo

namespace TransitSoftBusiness
{
    public class VehiculoBO
    {
        private VehiculoClient clienteSOAP;

        public VehiculoBO()
        {
            // Inicializa el cliente SOAP generado por Visual Studio
            this.clienteSOAP = new VehiculoClient();
        }

        // ===================== CRUD =====================

        public int Insertar(string placa, string marca, string modelo, int anho)
        {
            return this.clienteSOAP.insertarVehiculo(placa, marca, modelo, anho);
        }

        public int Modificar(int id, string placa, string marca, string modelo, int anho)
        {
            return this.clienteSOAP.modificarVehiculo(id, placa, marca, modelo, anho);
        }

        public int Eliminar(int id)
        {
            return this.clienteSOAP.eliminarVehiculo(id);
        }

        public vehiculoDTO ObtenerPorId(int id)
        {
            return this.clienteSOAP.obtenerVehiculoPorId(id);
        }

        public IList<vehiculoDTO> ListarTodos()
        {
            return this.clienteSOAP.listarVehiculos();
        }
    }
}
