package e1;

class Pendiente implements EstadoHabitacion{
    private static final Pendiente instancia = new Pendiente ();
    private Pendiente () {}
    public static Pendiente getInstancia(){return instancia;}

    @Override
    public Boolean reservar(String huesped) {
        System.out.println("No se puede reservar una habitación sucia\n");
        return false;
    }

    @Override
    public Boolean terminar() {
        System.out.println("No se puede terminar una reserva inexistente\n");
        return false;
    }

    @Override
    public Boolean limpiar(Personal limpiador) {
        return true;
    }

    @Override
    public Boolean liberar() {
        System.out.println("No se puede liberar una habitación sucia\n");
        return false;
    }

    @Override
    public Boolean aprobar(Personal supervisor) {
        return true;
    }

    @Override
    public Estado getEstado() {
        return Estado.PENDIENTE;
    }
}
