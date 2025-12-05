package pe.edu.pucp.transitsoft.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.transitsoft.dao.VehiculoPropietarioDAO;
import pe.edu.pucp.transitsoft.daoImp.util.Columna;
import pe.edu.pucp.transitsoft.model.VehiculoPropietarioDTO;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class VehiculoPropietarioDAOImpl extends DAOImplBase implements VehiculoPropietarioDAO {
    
    private VehiculoPropietarioDTO vehiculoPropietario;
    
    public VehiculoPropietarioDAOImpl() {
        super("vehiculo_propietario");
        this.vehiculoPropietario = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("id_vehiculo", false, false));
        this.listaColumnas.add(new Columna("id_propietario", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.vehiculoPropietario.getId_vehiculo());
        this.statement.setInt(2, this.vehiculoPropietario.getId_propietario());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setInt(1, this.vehiculoPropietario.getId_vehiculo());
        this.statement.setInt(2, this.vehiculoPropietario.getId_propietario());
        this.statement.setInt(3, this.vehiculoPropietario.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.vehiculoPropietario.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.vehiculoPropietario.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.vehiculoPropietario = new VehiculoPropietarioDTO();
        this.vehiculoPropietario.setId(this.resultSet.getInt("id"));
        this.vehiculoPropietario.setId_vehiculo(this.resultSet.getInt("id_vehiculo"));
        this.vehiculoPropietario.setId_propietario(this.resultSet.getInt("id_propietario"));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.vehiculoPropietario = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.vehiculoPropietario);
    }
    
    @Override
    public Integer insertar(VehiculoPropietarioDTO vehiculoPropietario) {        
        this.vehiculoPropietario = vehiculoPropietario;
        return super.insertar();
    }
    
    @Override
    public VehiculoPropietarioDTO obtenerPorId(Integer id) {
        this.vehiculoPropietario = new VehiculoPropietarioDTO();
        this.vehiculoPropietario.setId(id);
        super.obtenerPorId();
        return this.vehiculoPropietario;
    }
    
    @Override
    public ArrayList<VehiculoPropietarioDTO> listarTodos() {
        return (ArrayList<VehiculoPropietarioDTO>) super.listarTodos();
    }
    
    @Override
    public Integer modificar(VehiculoPropietarioDTO vehiculoPropietario) {
        this.vehiculoPropietario = vehiculoPropietario;
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(VehiculoPropietarioDTO vehiculoPropietario) {
        this.vehiculoPropietario = vehiculoPropietario;
        return super.eliminar();
    }
    
    @Override
    public ArrayList<VehiculoDTO> listarVehiculosPorPropietario(Integer id_propietario) {
        ArrayList<VehiculoDTO> lista = new ArrayList<>();
        String sql = "SELECT v.id, v.placa, v.marca, v.modelo, v.anho " +
                     "FROM vehiculo v " +
                     "INNER JOIN vehiculo_propietario vp ON v.id = vp.id_vehiculo " +
                     "WHERE vp.id_propietario = ?";

        try {
            this.abrirConexion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, id_propietario);
            this.resultSet = this.statement.executeQuery();

            while (this.resultSet.next()) {
                VehiculoDTO v = new VehiculoDTO();
                v.setId(this.resultSet.getInt("id"));
                v.setPlaca(this.resultSet.getString("placa"));
                v.setMarca(this.resultSet.getString("marca"));
                v.setModelo(this.resultSet.getString("modelo"));
                v.setAnho(this.resultSet.getInt("anho"));
                lista.add(v);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar vehículos por propietario: " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }

        return lista;
    }

    @Override
    public ArrayList<PropietarioDTO> listarPropietariosPorVehiculo(Integer id_vehiculo) {
        ArrayList<PropietarioDTO> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.dni, p.nombres, p.apellidos, p.direccion " +
                     "FROM propietario p " +
                     "INNER JOIN vehiculo_propietario vp ON p.id = vp.id_propietario " +
                     "WHERE vp.id_vehiculo = ?";

        try {
            this.abrirConexion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, id_vehiculo);
            this.resultSet = this.statement.executeQuery();

            while (this.resultSet.next()) {
                PropietarioDTO p = new PropietarioDTO();
                p.setId(this.resultSet.getInt("id"));
                p.setDni(this.resultSet.getString("dni"));
                p.setNombres(this.resultSet.getString("nombres"));
                p.setApellidos(this.resultSet.getString("apellidos"));
                p.setDireccion(this.resultSet.getString("direccion"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar propietarios por vehículo: " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex);
            }
        }

        return lista;
    }

}