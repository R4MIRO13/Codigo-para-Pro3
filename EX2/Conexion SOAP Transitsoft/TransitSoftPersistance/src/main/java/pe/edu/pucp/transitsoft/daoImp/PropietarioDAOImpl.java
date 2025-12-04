package pe.edu.pucp.transitsoft.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.transitsoft.dao.PropietarioDAO;
import pe.edu.pucp.transitsoft.daoImp.util.Columna;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class PropietarioDAOImpl extends DAOImplBase implements PropietarioDAO {
    
    private PropietarioDTO propietario;
    
    public PropietarioDAOImpl() {
        super("propietario");
        this.propietario = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("dni", false, false));
        this.listaColumnas.add(new Columna("nombres", false, false));
        this.listaColumnas.add(new Columna("apellidos", false, false));
        this.listaColumnas.add(new Columna("direccion", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.propietario.getDni());
        this.statement.setString(2, this.propietario.getNombres());
        this.statement.setString(3, this.propietario.getApellidos());
        this.statement.setString(4, this.propietario.getDireccion());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setInt(1, this.propietario.getDni());
        this.statement.setString(2, this.propietario.getNombres());
        this.statement.setString(3, this.propietario.getApellidos());
        this.statement.setString(4, this.propietario.getDireccion());
        this.statement.setInt(5, this.propietario.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.propietario.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.propietario.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.propietario = new PropietarioDTO();
        this.propietario.setId(this.resultSet.getInt("id"));
        this.propietario.setDni(this.resultSet.getInt("dni"));
        this.propietario.setNombres(this.resultSet.getString("nombres"));
        this.propietario.setApellidos(this.resultSet.getString("apellidos"));
        this.propietario.setDireccion(this.resultSet.getString("direccion"));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.propietario = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.propietario);
    }
    
    @Override
    public Integer insertar(PropietarioDTO propietario) {        
        this.propietario = propietario;
        return super.insertar();
    }
    
    @Override
    public PropietarioDTO obtenerPorId(Integer id) {
        this.propietario = new PropietarioDTO();
        this.propietario.setId(id);
        super.obtenerPorId();
        return this.propietario;
    }
    
    @Override
    public ArrayList<PropietarioDTO> listarTodos() {
        return (ArrayList<PropietarioDTO>) super.listarTodos();
    }
    
    @Override
    public Integer modificar(PropietarioDTO propietario) {
        this.propietario = propietario;
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(PropietarioDTO propietario) {
        this.propietario = propietario;
        return super.eliminar();
    }
    
}