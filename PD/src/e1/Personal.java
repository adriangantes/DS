package e1;

public class Personal {
    private final String nombre;
    private Boolean Supervisor;

    public Personal (String nombre, Boolean Supervisor){
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre nulo.");
            this.nombre = null;
        }else{
            this.nombre = nombre;
        }
        this.Supervisor = Supervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(Boolean supervisor) {
        this.Supervisor = supervisor;
    }
}
