package e1;

class Sucia implements EstadoHabitacion{
    private static final Sucia instancia = new Sucia ();
    private Sucia () {}
    public static Sucia getInstancia(){return instancia;}

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
        System.out.println("No se puede aprobar una habitación sucia\n");
        return false;
    }

    @Override
    public Estado getEstado() {
        return Estado.SUCIA;
    }
}
