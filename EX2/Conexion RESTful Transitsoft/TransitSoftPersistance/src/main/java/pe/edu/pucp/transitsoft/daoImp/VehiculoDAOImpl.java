package pe.edu.pucp.transitsoft.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.transitsoft.dao.VehiculoDAO;
import pe.edu.pucp.transitsoft.daoImp.util.Columna;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoDAOImpl extends DAOImplBase implements VehiculoDAO {
    
    private VehiculoDTO vehiculo;
    
    public VehiculoDAOImpl() {
        super("vehiculo");
        this.vehiculo = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("placa", false, false));
        this.listaColumnas.add(new Columna("marca", false, false));
        this.listaColumnas.add(new Columna("modelo", false, false));
        this.listaColumnas.add(new Columna("anho", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.vehiculo.getPlaca());
        this.statement.setString(2, this.vehiculo.getMarca());
        this.statement.setString(3, this.vehiculo.getModelo());
        this.statement.setInt(4, this.vehiculo.getAnho());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setString(1, this.vehiculo.getPlaca());
        this.statement.setString(2, this.vehiculo.getMarca());
        this.statement.setString(3, this.vehiculo.getModelo());
        this.statement.setInt(4, this.vehiculo.getAnho());
        this.statement.setInt(5, this.vehiculo.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.vehiculo.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.vehiculo.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.vehiculo = new VehiculoDTO();
        this.vehiculo.setId(this.resultSet.getInt("id"));
        this.vehiculo.setPlaca(this.resultSet.getString("placa"));
        this.vehiculo.setMarca(this.resultSet.getString("marca"));
        this.vehiculo.setModelo(this.resultSet.getString("modelo"));
        this.vehiculo.setAnho(this.resultSet.getInt("anho"));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.vehiculo = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.vehiculo);
    }
    
    @Override
    public Integer insertar(VehiculoDTO vehiculo) {        
        this.vehiculo = vehiculo;
        return super.insertar();
    }
    
    @Override
    public VehiculoDTO obtenerPorId(Integer id) {
        this.vehiculo = new VehiculoDTO();
        this.vehiculo.setId(id);
        super.obtenerPorId();
        return this.vehiculo;
    }
    
    @Override
    public ArrayList<VehiculoDTO> listarTodos() {
        return (ArrayList<VehiculoDTO>) super.listarTodos();
    }
    
    @Override
    public Integer modificar(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
        return super.eliminar();
    }
    
}