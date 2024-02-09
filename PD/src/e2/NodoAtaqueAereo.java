package e2;

public class NodoAtaqueAereo extends NodoRutaFija{

    public NodoAtaqueAereo(char nombre, Nodo hijo, int ataque) {
        super(nombre, hijo, ataque);
    }

    @Override
    public void simulacion(Barco barco) {

        if (barco == null){
            System.out.println("Barco nulo.");
        }else{
            int result = this.getAtaque() - (2*barco.getAntiaereo() + barco.getBlindaje());

            if (result >= 0){
                barco.setHp(barco.getHp() - result);
            }

            if (barco.getHp() <= 0){
                printResult (false, barco, this.getNombre());
            }else{

                if (this.getHijo() == null){
                    System.out.println("Nodo siguiente nulo, hijo de " + this.getNombre() + ". Fin de incursion");
                }else{
                    this.getHijo().simulacion(barco);
                }
            }
        }
    }

    @Override
    public void mostrarMapa() {
        System.out.print("(" + this.getNombre() + " AirRaid, ");

        this.getHijo().mostrarMapa();

        System.out.print(")");
    }
}
