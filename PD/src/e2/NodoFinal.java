package e2;

public class NodoFinal extends Nodo{

    public NodoFinal (char nombre){
        super(nombre);
    }

    @Override
    public void simulacion(Barco barco) {
        printResult (barco.getHp() > 0, barco, this.getNombre());
    }

    @Override
    public int nodosMinimos() {
        return 1;
    }

    @Override
    public void mostrarMapa() {
        System.out.print("(" + this.getNombre() + " End)");
    }
}
