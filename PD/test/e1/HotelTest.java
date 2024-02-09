package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {

    @Test
    public void testConstructorHotel (){
        Personal supervisorJuanito = new Personal("Juanito", true);
        Personal supervisorPepito = new Personal("Pepito", true);
        Personal limpiadorJuanito = new Personal("Juanito", false);
        Personal limpiadorPepe = new Personal("Pepe", false);
        Personal limpiadorNulo = new Personal("", false);

        Hotel hotel = new Hotel("Hilton");
        Hotel hotelNulo = new Hotel("");

        hotel.addPersonal(supervisorJuanito);
        hotel.addPersonal(supervisorPepito);
        hotel.addPersonal(limpiadorJuanito);
        hotel.addPersonal(limpiadorPepe);
        hotel.addPersonal(limpiadorNulo);

        hotel.addHabitacion("Pepe");
        hotel.informacionHotel();
        hotel.addHabitacion("Pepito");
        hotel.addHabitacion("Juanito");
        hotel.addHabitacion("Pepito");
        hotel.addHabitacion("Juanito");
        hotel.addHabitacion("Pepito");

        hotel.reservarHabitacion(1,null);

        hotel.informacionHotel();
    }

    @Test
    public void testFuncionamientoHotel (){
        Personal supervisorJuanito = new Personal("Juanito", true);
        Personal supervisorPepito = new Personal("Pepito", true);
        Personal limpiadorJuanito = new Personal("Juanito", false);
        Personal limpiadorPepe = new Personal("Pepe", false);

        Hotel hotel = new Hotel("Hilton");

        hotel.addPersonal(supervisorJuanito);
        hotel.addPersonal(supervisorPepito);
        hotel.addPersonal(limpiadorJuanito);
        hotel.addPersonal(limpiadorPepe);

        hotel.addHabitacion("Pepito");
        hotel.addHabitacion("Juanito");
        hotel.addHabitacion("Pepito");
        hotel.addHabitacion("Juanito");
        hotel.addHabitacion("Pepito");

        hotel.informacionHotel();

        hotel.reservarHabitacion(6,"Maria");
        hotel.reservarHabitacion(3,"Maria");
        hotel.reservarHabitacion(1,"Nico");
        hotel.reservarHabitacion(2,"Luis");
        hotel.reservarHabitacion(5,"Lucia");
        hotel.reservarHabitacion(4,"Luis");

        hotel.informacionHotel();

        hotel.terminarHabitacion(6);
        hotel.terminarHabitacion(4);

        hotel.informacionHotel();

        hotel.liberarHabitacion(6);
        hotel.liberarHabitacion(2);
        hotel.liberarHabitacion(5);
        hotel.liberarHabitacion(1);

        hotel.informacionHotel();

        hotel.limpiarHabitacion(6,"Maria");
        hotel.limpiarHabitacion(1,"Maria");
        hotel.limpiarHabitacion(2, "Pepe");
        hotel.limpiarHabitacion(1,"Juanito");

        hotel.informacionHotel();

        hotel.aprobarHabitacion(6,"Maria");
        hotel.aprobarHabitacion(1,"Maria");
        hotel.aprobarHabitacion(1,"Juanito");

        hotel.informacionHotel();

        ArrayList<Habitacion> disponibles = hotel.habitacionesDisponibles();
        assertEquals(2, disponibles.size());
        assertEquals(disponibles.get(0), hotel.getHabitacion(1));
        assertEquals(disponibles.get(1), hotel.getHabitacion(4));

        ArrayList<Habitacion> sucias = hotel.habitacionesSucias();
        assertEquals(1, sucias.size());
        assertEquals(sucias.get(0), hotel.getHabitacion(5));

        ArrayList<Habitacion> pendientes = hotel.habitacionesPendientes();
        assertEquals(1, pendientes.size());
        assertEquals(pendientes.get(0), hotel.getHabitacion(2));

        hotel.getHabitacion(6);
    }
}
