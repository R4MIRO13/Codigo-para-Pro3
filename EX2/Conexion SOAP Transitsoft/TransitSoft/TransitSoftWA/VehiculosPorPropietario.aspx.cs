using System;
using TransitSoftBusiness.VehiculoPropietarioWS;

namespace TransitSoftWA
{
    public partial class VehiculosPorPropietario : System.Web.UI.Page
    {
        private VehiculoPropietarioClient cliente = new VehiculoPropietarioClient();

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            int id = int.Parse(txtIdPropietario.Text);
            var lista = cliente.listarVehiculosPorPropietario(id);
            gvVehiculos.DataSource = lista;
            gvVehiculos.DataBind();
        }
    }
}