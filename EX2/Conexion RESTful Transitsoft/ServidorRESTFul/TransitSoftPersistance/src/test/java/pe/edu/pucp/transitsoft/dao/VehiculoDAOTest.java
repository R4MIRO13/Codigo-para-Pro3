package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.transitsoft.daoImp.VehiculoDAOImpl;
import pe.edu.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoDAOTest {

    private VehiculoDAO vehiculoDAO;

    public VehiculoDAOTest() {
        this.vehiculoDAO = new VehiculoDAOImpl();
    }

    @BeforeEach
    public void setUp() {
        eliminarTodo();
    }

    @Test
    public void testInsertar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarVehiculos(ids);
        assertEquals(3, ids.size());
    }

    private void insertarVehiculos(ArrayList<Integer> ids) {

        VehiculoDTO v1 = new VehiculoDTO();
        v1.setPlaca("ABC123");
        v1.setMarca("Toyota");
        v1.setModelo("Corolla");
        v1.setAnho(2015);
        Integer id1 = vehiculoDAO.insertar(v1);
        assertTrue(id1 > 0);
        ids.add(id1);

        VehiculoDTO v2 = new VehiculoDTO();
        v2.setPlaca("XYZ987");
        v2.setMarca("Honda");
        v2.setModelo("Civic");
        v2.setAnho(2018);
        Integer id2 = vehiculoDAO.insertar(v2);
        assertTrue(id2 > 0);
        ids.add(id2);

        VehiculoDTO v3 = new VehiculoDTO();
        v3.setPlaca("LMN456");
        v3.setMarca("Hyundai");
        v3.setModelo("Elantra");
        v3.setAnho(2020);
        Integer id3 = vehiculoDAO.insertar(v3);
        assertTrue(id3 > 0);
        ids.add(id3);
    }

    @Test
    public void testObtenerPorId() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarVehiculos(ids);

        for (int i = 0; i < ids.size(); i++) {
            VehiculoDTO v = vehiculoDAO.obtenerPorId(ids.get(i));
            assertNotNull(v);
            assertEquals(ids.get(i), v.getId());
        }
    }

    @Test
    public void testListarTodos() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarVehiculos(ids);

        ArrayList<VehiculoDTO> lista = vehiculoDAO.listarTodos();
        assertEquals(ids.size(), lista.size());

        // Ordenar ambos para garantizar equivalencia por ID
        ids.sort(Integer::compareTo);
        lista.sort(Comparator.comparing(VehiculoDTO::getId));

        for (int i = 0; i < ids.size(); i++) {
            assertEquals(ids.get(i), lista.get(i).getId());
        }
    }

    @Test
    public void testModificar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarVehiculos(ids);

        ArrayList<VehiculoDTO> listaOriginal = vehiculoDAO.listarTodos();

        // Ordenar por ID
        listaOriginal.sort(Comparator.comparing(VehiculoDTO::getId));

        for (int i = 0; i < listaOriginal.size(); i++) {
            VehiculoDTO v = listaOriginal.get(i);
            v.setPlaca("MOD" + i);
            v.setMarca("MarcaMod" + i);
            v.setModelo("ModeloMod" + i);
            v.setAnho(2000 + i);
            vehiculoDAO.modificar(v);
        }

        ArrayList<VehiculoDTO> listaModificada = vehiculoDAO.listarTodos();
        listaModificada.sort(Comparator.comparing(VehiculoDTO::getId));

        for (int i = 0; i < listaOriginal.size(); i++) {
            assertEquals(listaOriginal.get(i).getPlaca(), listaModificada.get(i).getPlaca());
            assertEquals(listaOriginal.get(i).getMarca(), listaModificada.get(i).getMarca());
            assertEquals(listaOriginal.get(i).getModelo(), listaModificada.get(i).getModelo());
            assertEquals(listaOriginal.get(i).getAnho(), listaModificada.get(i).getAnho());
        }
    }

    @Test
    public void testEliminar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarVehiculos(ids);
        eliminarTodo();

        // Validar que ya no hay vehículos
        assertEquals(0, vehiculoDAO.listarTodos().size());
    }

    private void eliminarTodo() {
        ArrayList<VehiculoDTO> lista = new ArrayList<>(vehiculoDAO.listarTodos());
        for (VehiculoDTO v : lista) {
            Integer r = vehiculoDAO.eliminar(v);
            assertTrue(r > 0);
            assertNull(vehiculoDAO.obtenerPorId(v.getId()));
        }
    }
}