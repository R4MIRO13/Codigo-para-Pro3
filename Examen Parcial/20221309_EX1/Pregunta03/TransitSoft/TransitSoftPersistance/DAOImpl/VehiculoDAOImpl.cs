using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using TransitSoft.DAO;
using TransitSoft.DAO.Util;
using TransitSoftModel;
using TransitSoftPersistance.DAO;
using static System.Collections.Specialized.BitVector32;

namespace TransitSoftPersistance.DAOImpl
{
    public class VehiculoDAOImpl : DAOImplBase, VehiculoDAO
    {
        private VehiculoDTO vehiculo;

        public VehiculoDAOImpl() : base("vehiculo")
        {
            this.retornarLlavePrimaria = true;
            this.vehiculo = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("id", true, true));
            this.listaColumnas.Add(new Columna("placa", false, false));
            this.listaColumnas.Add(new Columna("marca", false, false));
            this.listaColumnas.Add(new Columna("modelo", false, false));
            this.listaColumnas.Add(new Columna("anho", false, false));
        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {
            AgregarParametro("@placa", this.vehiculo.Placa);
            AgregarParametro("@marca", this.vehiculo.Marca);
            AgregarParametro("@modelo", this.vehiculo.Modelo);
            AgregarParametro("@anho", this.vehiculo.Anho);
        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@id", this.vehiculo.Id);
            AgregarParametro("@placa", this.vehiculo.Placa);
            AgregarParametro("@marca", this.vehiculo.Marca);
            AgregarParametro("@modelo", this.vehiculo.Modelo);
            AgregarParametro("@anho", this.vehiculo.Anho);
        }

        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@id", this.vehiculo.Id);
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@id", this.vehiculo.Id);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.vehiculo = new VehiculoDTO();
            this.vehiculo.Id = this.lector.GetInt32(0);
            this.vehiculo.Placa = this.lector.GetString(1);
            this.vehiculo.Marca = this.lector.GetString(2);
            this.vehiculo.Modelo = this.lector.GetString(3);
            this.vehiculo.Anho = this.lector.GetInt32(4);
            this.vehiculo.Propietario = new PropietarioDTO();
            this.vehiculo.Propietario.Id = this.lector.GetInt32(5);
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.vehiculo = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.vehiculo);
        }

        //Metodos CRUD
        public int Insertar(VehiculoDTO vehiculo)
        {
            this.vehiculo = vehiculo;
            return base.Insertar();
        }

        public int Modificar(VehiculoDTO vehiculo)
        {
            this.vehiculo = vehiculo;
            return base.Modificar();
        }

        public int Eliminar(VehiculoDTO vehiculo)
        {
            this.vehiculo = vehiculo;
            return base.Eliminar();
        }

        public VehiculoDTO ObtenerPorId(int idVehiculo)
        {
            this.vehiculo = new VehiculoDTO();
            this.vehiculo.Id = idVehiculo;
            base.ObtenerPorId();
            return this.vehiculo;
        }

        public new BindingList<VehiculoDTO> ListarTodos()
        {
            BindingList<Object> lista;
            lista = base.ListarTodos();
            BindingList<VehiculoDTO> retorno = new BindingList<VehiculoDTO>();
            foreach (VehiculoDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }
    }
}
