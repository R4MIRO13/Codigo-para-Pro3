using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TransitSoftBusiness.VehiculoPropietarioWS; // <- Usa el namespace generado para tu WSDL de VehiculoPropietario

namespace TransitSoftBusiness
{
    public class VehiculoPropietarioBO
    {
        private VehiculoPropietarioClient clienteSOAP;

        public VehiculoPropietarioBO()
        {
            // Inicializa el cliente SOAP generado por Visual Studio
            this.clienteSOAP = new VehiculoPropietarioClient();
        }

        // ===================== CRUD =====================

        public int Insertar(int id_vehiculo, int id_propietario)
        {
            return this.clienteSOAP.insertarRelacion(id_vehiculo, id_propietario);
        }

        public int Modificar(int id, int id_vehiculo, int id_propietario)
        {
            return this.clienteSOAP.modificarRelacion(id, id_vehiculo, id_propietario);
        }

        public int Eliminar(int id)
        {
            return this.clienteSOAP.eliminarRelacion(id);
        }

        public vehiculoPropietarioDTO ObtenerPorId(int id)
        {
            return this.clienteSOAP.obtenerRelacionPorId(id);
        }

        public IList<vehiculoPropietarioDTO> ListarTodos()
        {
            return this.clienteSOAP.listarRelaciones();
        }

        // ===================== Consultas =====================

        public IList<vehiculoDTO> ListarVehiculosPorPropietario(int id_propietario)
        {
            return this.clienteSOAP.listarVehiculosPorPropietario(id_propietario);
        }

        public IList<propietarioDTO> ListarPropietariosPorVehiculo(int id_vehiculo)
        {
            return this.clienteSOAP.listarPropietariosPorVehiculo(id_vehiculo);
        }
    }
}