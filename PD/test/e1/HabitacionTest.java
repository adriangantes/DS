package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HabitacionTest {

    @Test
    public void testConstructorHabitacion() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        
        Habitacion habitacion = new Habitacion(1, supervisor);
        assertEquals(habitacion.getSupervisor(),supervisor);
    }

    @Test
    public void testGettersHabitacion (){
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        assertEquals(1, habitacion.getNumero());
        assertEquals("Juanito", habitacion.getSupervisor().getNombre());
        assertEquals(supervisor, habitacion.getSupervisor());
        assertNull(habitacion.getHuesped());
        assertNull(habitacion.getLimpiador());
        habitacion.setLimpiador(limpiador);
        assertEquals(limpiador, habitacion.getLimpiador());
    }

    @Test
    public void testSettersHabitacion (){
        Personal supervisor = new Personal("Juanito", true);
        Habitacion habitacion = new Habitacion(1, supervisor);

        assertNull(habitacion.getHuesped());
        habitacion.setHuesped("Manolo");
        assertEquals("Manolo", habitacion.getHuesped());
    }

    @Test
    public void testAccionesHabitacion (){
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.reservar("Manolo");
        assertEquals(Estado.RESERVADA, habitacion.getEstado());
        habitacion.terminar();
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.reservar("Manolo");
        habitacion.liberar();
        assertEquals(Estado.SUCIA, habitacion.getEstado());
        habitacion.limpiar(limpiador);
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());
        habitacion.aprobar(supervisor);
        assertEquals(Estado.LIBRE, habitacion.getEstado());
    }

    @Test
    public void testSetSupervisorHabitacion() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.setSupervisor(supervisor);
        habitacion.setSupervisor(limpiador);
        assertEquals(habitacion.getSupervisor(), supervisor);
    }

    @Test
    public void testSetLimpiadorHabitacion() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.setLimpiador(limpiador);
        habitacion.setLimpiador(supervisor);
        assertEquals(habitacion.getLimpiador(),limpiador);
    }
}
