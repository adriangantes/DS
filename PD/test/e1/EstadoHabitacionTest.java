package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoHabitacionTest {

    @Test
    public void testEstadoHabitacionLibre() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.terminar();
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.liberar();
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.aprobar(supervisor);
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.reservar("");
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.reservar("Manolo");
        assertEquals(Estado.RESERVADA, habitacion.getEstado());
        habitacion.terminar();
        assertEquals(Estado.LIBRE, habitacion.getEstado());
        habitacion.limpiar(limpiador);
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());
    }

    @Test
    public void testEstadoHabitacionReservada() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.reservar("Manolo");

        habitacion.reservar("Manolo");
        assertEquals(Estado.RESERVADA, habitacion.getEstado());
        habitacion.limpiar(limpiador);
        assertEquals(Estado.RESERVADA, habitacion.getEstado());
        habitacion.aprobar(supervisor);
        assertEquals(Estado.RESERVADA, habitacion.getEstado());
        habitacion.terminar();
        assertEquals(Estado.LIBRE, habitacion.getEstado());

        habitacion.reservar("Manolo");
        assertEquals(Estado.RESERVADA, habitacion.getEstado());

        habitacion.liberar();
        assertEquals(Estado.SUCIA, habitacion.getEstado());
    }

    @Test
    public void testEstadoHabitacionSucia() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.reservar("Manolo");
        habitacion.liberar();

        habitacion.reservar("Manolo");
        assertEquals(Estado.SUCIA, habitacion.getEstado());

        habitacion.terminar();
        assertEquals(Estado.SUCIA, habitacion.getEstado());
        habitacion.liberar();
        assertEquals(Estado.SUCIA, habitacion.getEstado());
        habitacion.aprobar(supervisor);
        assertEquals(Estado.SUCIA, habitacion.getEstado());

        habitacion.limpiar(limpiador);
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());
    }

    @Test
    public void testEstadoHabitacionPendiente() {
        Personal supervisor = new Personal("Juanito", true);
        Personal limpiador = new Personal("Pepe", false);
        Habitacion habitacion = new Habitacion(1, supervisor);

        habitacion.reservar("Manolo");
        habitacion.liberar();
        habitacion.limpiar(limpiador);

        habitacion.reservar("Manolo");
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());
        habitacion.terminar();
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());
        habitacion.liberar();
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());

        habitacion.limpiar(limpiador);
        assertEquals(Estado.PENDIENTE, habitacion.getEstado());

        habitacion.aprobar(supervisor);
        assertEquals(Estado.LIBRE, habitacion.getEstado());
    }
}
