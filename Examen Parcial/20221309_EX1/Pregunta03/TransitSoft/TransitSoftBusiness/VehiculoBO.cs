using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TransitSoftModel;
using TransitSoftPersistance.DAO;
using TransitSoftPersistance.DAOImpl;

namespace TransitSoftBusiness
{
    public class VehiculoBO
    {
        private VehiculoDAO vehiculoDAO;

        public VehiculoBO()
        {
            this.vehiculoDAO = new VehiculoDAOImpl();
        }

        public int Insertar(string placa, string marca, string modelo, int anho, int propietarioId)
        {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.Placa = placa;
            vehiculoDTO.Marca = marca;
            vehiculoDTO.Modelo = modelo;
            vehiculoDTO.Anho = anho;
            vehiculoDTO.Propietario = new PropietarioDTO();
            vehiculoDTO.Propietario.Id = propietarioId;
            return this.vehiculoDAO.Insertar(vehiculoDTO);
        }

        public int Eliminar(int id)
        {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.Id = id;
            return this.vehiculoDAO.Eliminar(vehiculoDTO);
        }

        public int Modificar(int id, string placa, string marca, string modelo, int anho, int propietarioId)
        {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.Id = id;
            vehiculoDTO.Placa = placa;
            vehiculoDTO.Marca = marca;
            vehiculoDTO.Modelo = modelo;
            vehiculoDTO.Anho = anho;
            vehiculoDTO.Propietario = new PropietarioDTO();
            vehiculoDTO.Propietario.Id = propietarioId;
            return this.vehiculoDAO.Modificar(vehiculoDTO);
        }

        public VehiculoDTO ObtenerPorId(int id)
        {
            return this.vehiculoDAO.ObtenerPorId(id);
        }

        public BindingList<VehiculoDTO> ListarTodos()
        {
            return this.vehiculoDAO.ListarTodos();
        }
    }
}
