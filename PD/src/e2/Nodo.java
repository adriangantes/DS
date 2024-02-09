package e2;

public abstract class Nodo {
    private final char nombre;

    public Nodo (char nombre){
        if (nombre == '\0'){
            System.out.println("Nombre vacio.");
        }
        this.nombre = nombre;
    }

    public char getNombre(){
        return this.nombre;
    }

    public abstract void simulacion (Barco barco);

    public abstract int nodosMinimos ();

    public abstract void mostrarMapa ();

    public void printResult (Boolean exito, Barco barco, char nombre){
        System.out.println("\nSortie Result:");

        if (exito){
            System.out.println("\tSUCCESS");
        }else{
            System.out.println("\tFAIL");
        }

        if (nombre == '\0'){
            System.out.println("\tLast Visited Node: Nodo sin nombre");
        }else{
            System.out.println("\tLast Visited Node: " + nombre);
        }

        System.out.println("\tFinal HP: " + barco.getHp());
    }

    public void printCaminoMinimo (){
        System.out.println("\nSmallest Node Count to End: " + this.nodosMinimos());
    }
}
