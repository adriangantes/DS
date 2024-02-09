package e2;

public class NodoBatalla extends NodoBifurcacion{
    private final Barco atacante;

    public NodoBatalla (char nombre, Nodo hijoIzq, Nodo hijoDer, Barco atacante){
        super(nombre, hijoIzq, hijoDer);
        if(atacante == null){
            System.out.println("Atacante vacio, inicializado a 0.");
            this.atacante = new Barco(0,0,0,0,0);
        }else{
            this.atacante = atacante;
        }
    }

    @Override
    public void simulacion(Barco barco) {

        if (barco == null){
            System.out.println("Barco nulo.");
        }else{

            int result1, result2;
            result1 = barco.getAtaque() - this.atacante.getBlindaje();
            result2 = this.atacante.getAtaque() - barco.getBlindaje();

            if (result1 >= 0){
                this.atacante.setHp(this.atacante.getHp() - result1);
            }

            if (result2 >= 0){
                barco.setHp(barco.getHp() - result2);
            }

            if (barco.getHp() <= 0){
                this.printResult (false, barco, this.getNombre());
            }else{

                if (this.atacante.getHp() <= 0){

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
    }

    @Override
    public void mostrarMapa() {
        System.out.print("(" + this.getNombre() + " Battle, ");

        this.getHijoIzq().mostrarMapa();
        System.out.print(", ");
        this.getHijoDer().mostrarMapa();

        System.out.print(")");
    }
}
