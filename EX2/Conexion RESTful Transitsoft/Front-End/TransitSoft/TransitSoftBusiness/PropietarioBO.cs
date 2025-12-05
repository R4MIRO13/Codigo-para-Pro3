using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TransitSoftBusiness.PropietarioWS; // <- Asegúrate de usar el namespace generado para tu WSDL

namespace TransitSoftBusiness
{
    public class PropietarioBO
    {
        private PropietarioClient clienteSOAP;

        public PropietarioBO()
        {
            // Inicializa el cliente SOAP generado por Visual Studio
            this.clienteSOAP = new PropietarioClient();
        }

        // ===================== CRUD =====================

        public int Insertar(int dni, string nombres, string apellidos, string direccion)
        {
            return this.clienteSOAP.insertarPropietario(dni,nombres,apellidos,direccion);
        }

        public int Modificar(int id, int dni, string nombres, string apellidos, string direccion)
        {
            return this.clienteSOAP.modificarPropietario(id,dni,nombres,apellidos,direccion);
        }

        public int Eliminar(int id)
        {
            return this.clienteSOAP.eliminarPropietario(id);
        }

        public propietarioDTO ObtenerPorId(int id)
        {
            return this.clienteSOAP.obtenerPropietarioPorId(id);
        }

        public IList<propietarioDTO> ListarTodos()
        {
            return this.clienteSOAP.listarPropietarios();
        }
    }
}