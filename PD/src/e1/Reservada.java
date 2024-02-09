package e1;

class Reservada implements EstadoHabitacion{
    private static final Reservada instancia = new Reservada ();
    private Reservada () {}
    public static Reservada getInstancia(){return instancia;}

    @Override
    public Boolean reservar(String huesped) {
        System.out.println("La habitación ya está reservada\n");
        return false;
    }

    @Override
    public Boolean terminar() {
        return true;
    }

    @Override
    public Boolean limpiar(Personal limpiador) {
        System.out.println("No se puede limpiar una habitación reservada\n");
        return false;
    }

    @Override
    public Boolean liberar() {
        return true;
    }

    @Override
    public Boolean aprobar(Personal supervisor) {
        System.out.println("No se puede aprobar una habitación reservada\n");
        return false;
    }

    @Override
    public Estado getEstado() {
        return Estado.RESERVADA;
    }
}
