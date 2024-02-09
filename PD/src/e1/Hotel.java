package e1;

import java.util.ArrayList;

public class Hotel {
    private final String nombre;
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Personal> personal = new ArrayList<>();
    private int numHabitaciones = 0;

    public Hotel (String nombre){
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre nulo\n");
            this.nombre = "Sin nombre";
        }else{
            this.nombre = nombre;
        }
    }

    public void addPersonal (Personal persona){
        if (persona.getNombre() == null || persona.getNombre().equals("")){
            System.out.println("Personal con nombre nulo, no se ha añadido.");
        }else{
            personal.add(persona);
        }
    }

    public void addHabitacion (String nombre){
        boolean success = false;

        for (Personal persona : personal){
            if (nombre.equals(persona.getNombre()) && persona.getSupervisor()){
                this.numHabitaciones++;
                habitaciones.add(new Habitacion(numHabitaciones,persona));
                success = true;
                break;
            }
        }

        if (!success){
            System.out.println("Supervisor inexistente\n");
        }
    }

    public void reservarHabitacion (int numero, String huesped){
        if (huesped == null || huesped.equals(" ")){
            System.out.println("Huesped nulo, no se ha realizado la reserva");
        }else{
            if (numero > 0 && numero <= habitaciones.size()) {
                habitaciones.get(numero - 1).reservar(huesped);
            } else {
                System.out.println("Número de habitación no valido\n");
            }
        }
    }

    public void terminarHabitacion (int numero){
        if (numero > 0 && numero <= habitaciones.size()) {
            habitaciones.get(numero - 1).terminar();
        } else {
            System.out.println("Número de habitación no valido\n");
        }
    }

    public void limpiarHabitacion (int numero, String nombre){
        if (numero > 0 && numero <= habitaciones.size()) {
            boolean success = false;
            Habitacion habitacion = habitaciones.get(numero - 1);

            for (Personal persona : personal){
                if (nombre.equals(persona.getNombre()) && !persona.getSupervisor()){
                    habitacion.limpiar(persona);
                    success = true;
                    break;
                }
            }

            if (!success){
                System.out.println("Personal de limpieza inexistente\n");
            }

        } else {
            System.out.println("Número de habitación no valido\n");
        }
    }

    public void liberarHabitacion (int numero){
        if (numero > 0 && numero <= habitaciones.size()) {
            habitaciones.get(numero - 1).liberar();
        } else {
            System.out.println("Número de habitación no valido\n");
        }
    }

    public void aprobarHabitacion (int numero, String nombre){

        if (numero > 0 && numero <= habitaciones.size()) {
            boolean success = false;
            Habitacion habitacion = habitaciones.get(numero - 1);

            for (Personal persona : personal){
                if (nombre.equals(persona.getNombre()) && persona.getSupervisor()){
                    habitacion.aprobar(persona);
                    success = true;
                    break;
                }
            }

            if (!success){
                System.out.println("Supervisor inexistente\n");
            }
        } else {
            System.out.println("Número de habitación no valido\n");
        }
    }

    public ArrayList<Habitacion> habitacionesDisponibles (){
        ArrayList<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion habitacion : habitaciones){
            if (habitacion.getEstado() == Estado.LIBRE){
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    public ArrayList<Habitacion> habitacionesSucias (){
        ArrayList<Habitacion> sucias = new ArrayList<>();

        for (Habitacion habitacion : habitaciones){
            if (habitacion.getEstado() == Estado.SUCIA){
                sucias.add(habitacion);
            }
        }
        return sucias;
    }

    public ArrayList<Habitacion> habitacionesPendientes (){
        ArrayList<Habitacion> pendientes = new ArrayList<>();

        for (Habitacion habitacion : habitaciones){
            if (habitacion.getEstado() == Estado.PENDIENTE){
                pendientes.add(habitacion);
            }
        }
        return pendientes;
    }

    public void informacionHotel() {
        System.out.print("\nHotel: " + this.nombre + "\n\n");

        for (Habitacion habitacion : habitaciones) {
            System.out.print("Room no. " + habitacion.getNumero() + ": ");

            if (habitacion.getEstado() == Estado.RESERVADA) {
                System.out.println("Booked by " + habitacion.getHuesped() + ". " + "Occupied.");
            } else {
                System.out.print("Free. ");
                if (habitacion.getEstado() == Estado.LIBRE) {
                    System.out.println("This room was approved by " + habitacion.getSupervisor().getNombre() + ".");
                } else if (habitacion.getEstado() == Estado.PENDIENTE){
                    System.out.println("Room cleaned by " + habitacion.getLimpiador().getNombre() + ", pending approval.");
                }else {
                    System.out.println("Cleaning pending.");
                }
            }
        }
        System.out.println();
    }

    public Habitacion getHabitacion (int n){
        if (n > 0 && n <= habitaciones.size()) {
            return habitaciones.get(n - 1);
        } else {
            System.out.println("Número de habitación no valido\n");
            return null;
        }
    }
}
