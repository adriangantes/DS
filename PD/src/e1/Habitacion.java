package e1;

public class Habitacion{

    private final int numero;
    private Personal supervisor;
    private Personal limpiador;
    private String huesped;
    private EstadoHabitacion estado;

    public Habitacion (int numero, Personal supervisor){
        this.numero = numero;
        this.supervisor = supervisor;
        this.huesped = null;
        this.limpiador = null;
        this.estado = Libre.getInstancia();
    }

    public int getNumero() {
        return numero;
    }

    public Personal getSupervisor() {
        return supervisor;
    }

    public String getHuesped() {
        return huesped;
    }

    public Personal getLimpiador() {
        return limpiador;
    }

    public void setSupervisor (Personal supervisor) {
        if (supervisor.getSupervisor()){
            this.supervisor = supervisor;
        }else{
            System.out.println("No es supervisor\n");
        }
    }

    public void setLimpiador(Personal limpiador) {
        if (!limpiador.getSupervisor()){
            this.limpiador = limpiador;
        }else{
            System.out.println("No es personal de limpieza\n");
        }
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    private void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public void reservar(String huesped) {
        if (estado.reservar(huesped)){
            setHuesped(huesped);
            setEstado(Reservada.getInstancia());
        }
    }

    public void terminar() {
        if (estado.terminar()){
            setHuesped(null);
            setEstado(Libre.getInstancia());
        }
    }

    public void limpiar(Personal limpiador) {
        if (estado.limpiar(limpiador)){
            setLimpiador(limpiador);
            setEstado(Pendiente.getInstancia());
        }
    }

    public void liberar() {
        if (estado.liberar()){
            setHuesped(null);
            setEstado(Sucia.getInstancia());
        }
    }

    public void aprobar(Personal supervisor) {
        if (estado.aprobar(supervisor)){
            setSupervisor(supervisor);
            setEstado(Libre.getInstancia());
        }
    }

    public Estado getEstado() {
        return estado.getEstado();
    }
}
