package e2;

public class NodoAvistamiento extends NodoBifurcacion{
    private final int referencia;

    public NodoAvistamiento (char nombre, Nodo hijoIzq, Nodo hijoDer, int referencia){
        super(nombre, hijoIzq, hijoDer);
        if (referencia < 0){
            System.out.println("Referancia menor a 0, inicializado a 0.");
            this.referencia = 0;
        }else{
            this.referencia = referencia;
        }
    }

    @Override
    public void simulacion(Barco barco) {
        if (barco == null){
            System.out.println("Barco nulo.");
        }else{
            if (barco.getVision() >= referencia){
                if (this.getHijoIzq() == null){
                    System.out.println("Nodo siguiente nulo, hijo izquierdo de " + this.getNombre() + ". Fin de incursion");
                }else{
                    this.getHijoIzq().simulacion(barco);
                }
            }else{
                if (this.getHijoDer() == null){
                    System.out.println("Nodo siguiente nulo, hijo derecho de " + this.getNombre() + ". Fin de incursion");
                }else{
                    this.getHijoDer().simulacion(barco);
                }
            }
        }
    }

    @Override
    public void mostrarMapa() {
        System.out.print("(" + this.getNombre() + " WaypointSpotting, ");

        this.getHijoIzq().mostrarMapa();
        System.out.print(", ");
        this.getHijoDer().mostrarMapa();

        System.out.print(")");
    }
}
