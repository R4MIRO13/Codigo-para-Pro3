using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TransitSoftModel;

namespace TransitSoftPersistance.DAO
{
    public interface VehiculoDAO
    {
        int Insertar(VehiculoDTO vehiculo);

        VehiculoDTO ObtenerPorId(int vehiculoId);

        BindingList<VehiculoDTO> ListarTodos();

        int Modificar(VehiculoDTO vehiculo);

        int Eliminar(VehiculoDTO vehiculo);
    }
}
