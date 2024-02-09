package e1;

public interface EstadoHabitacion {
    Boolean reservar(String huesped);
    Boolean terminar();
    Boolean limpiar(Personal limpiador);
    Boolean liberar();
    Boolean aprobar(Personal supervisor);
    Estado getEstado();
}
