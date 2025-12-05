package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.transitsoft.daoImp.PropietarioDAOImpl;
import pe.edu.pucp.transitsoft.model.PropietarioDTO;

public class PropietarioDAOTest {

    private PropietarioDAO propietarioDAO;

    public PropietarioDAOTest() {
        this.propietarioDAO = new PropietarioDAOImpl();
    }

    @BeforeEach
    public void setUp() {
        // Limpiar BD antes de cada test
        eliminarTodo();
    }

    @Test
    public void testInsertar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarPropietarios(ids);
        assertEquals(3, ids.size());
        eliminarTodo();
    }

    private void insertarPropietarios(ArrayList<Integer> listaIds) {

        PropietarioDTO p1 = new PropietarioDTO();
        p1.setDni(12345678);
        p1.setNombres("Juan");
        p1.setApellidos("Pérez");
        p1.setDireccion("Av. Siempre Viva 123");

        Integer r1 = propietarioDAO.insertar(p1);
        assertTrue(r1 > 0);
        listaIds.add(r1);

        PropietarioDTO p2 = new PropietarioDTO();
        p2.setDni(87654321);
        p2.setNombres("María");
        p2.setApellidos("Gómez");
        p2.setDireccion("Calle Los Cedros 456");

        Integer r2 = propietarioDAO.insertar(p2);
        assertTrue(r2 > 0);
        listaIds.add(r2);

        PropietarioDTO p3 = new PropietarioDTO();
        p3.setDni(11223344);
        p3.setNombres("Carlos");
        p3.setApellidos("Ramírez");
        p3.setDireccion("Jr. Los Laureles 789");

        Integer r3 = propietarioDAO.insertar(p3);
        assertTrue(r3 > 0);
        listaIds.add(r3);
    }

    @Test
    public void testObtenerPorId() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarPropietarios(ids);

        for (int i = 0; i < ids.size(); i++) {
            PropietarioDTO p = propietarioDAO.obtenerPorId(ids.get(i));
            assertNotNull(p);
            assertEquals(ids.get(i), p.getId());
        }
        eliminarTodo();
    }

    @Test
    public void testListarTodos() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarPropietarios(ids);

        ArrayList<PropietarioDTO> lista = propietarioDAO.listarTodos();
        assertEquals(ids.size(), lista.size());

        // Ordenar por ID para comparar correctamente
        lista.sort(Comparator.comparing(PropietarioDTO::getId));
        ids.sort(Integer::compareTo);

        for (int i = 0; i < ids.size(); i++) {
            assertEquals(ids.get(i), lista.get(i).getId());
        }

        eliminarTodo();
    }

    @Test
    public void testModificar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarPropietarios(ids);

        ArrayList<PropietarioDTO> lista = propietarioDAO.listarTodos();

        for (int i = 0; i < lista.size(); i++) {
            PropietarioDTO p = lista.get(i);
            p.setNombres("NuevoNombre" + i);
            p.setApellidos("NuevoApellido" + i);
            p.setDireccion("NuevaDireccion" + i);
            propietarioDAO.modificar(p);
        }

        ArrayList<PropietarioDTO> lista2 = propietarioDAO.listarTodos();
        lista.sort(Comparator.comparing(PropietarioDTO::getId));
        lista2.sort(Comparator.comparing(PropietarioDTO::getId));

        for (int i = 0; i < lista.size(); i++) {
            assertEquals(lista.get(i).getNombres(), lista2.get(i).getNombres());
            assertEquals(lista.get(i).getApellidos(), lista2.get(i).getApellidos());
            assertEquals(lista.get(i).getDireccion(), lista2.get(i).getDireccion());
        }

        eliminarTodo();
    }

    @Test
    public void testEliminar() {
        ArrayList<Integer> ids = new ArrayList<>();
        insertarPropietarios(ids);
        eliminarTodo();
    }

    private void eliminarTodo() {
        ArrayList<PropietarioDTO> lista = new ArrayList<>(propietarioDAO.listarTodos());
        for (PropietarioDTO p : lista) {
            Integer r = propietarioDAO.eliminar(p);
            assertTrue(r > 0);
            PropietarioDTO eliminado = propietarioDAO.obtenerPorId(p.getId());
            assertNull(eliminado);
        }
    }
}