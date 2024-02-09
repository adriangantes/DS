package e1;

class Libre implements EstadoHabitacion{
    private static final Libre instancia = new Libre ();
    private Libre () {}
    public static Libre getInstancia(){return instancia;}

    @Override
    public Boolean reservar(String huesped) {
        if (huesped == null || huesped.isEmpty()) {
            System.out.println("Huesped nulo\n");
            return false;
        }else{
            return true;
        }
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
        System.out.println("La habitación ya está libre\n");
        return false;
    }

    @Override
    public Boolean aprobar(Personal supervisor) {
        System.out.println("La habitación ya está libre\n");
        return false;
    }

    public Estado getEstado() {
        return Estado.LIBRE;
    }
}
