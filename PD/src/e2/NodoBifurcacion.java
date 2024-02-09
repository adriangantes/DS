package e2;

abstract class NodoBifurcacion extends Nodo{

    private final Nodo hijoIzq;
    private final Nodo hijoDer;

    public NodoBifurcacion (char nombre, Nodo hijoIzq, Nodo hijoDer){
        super(nombre);

        if (hijoIzq == null){
            System.out.println("Hijo izquierdo nulo, inicializado a nulo.");
            this.hijoIzq = null;
        }else{
            this.hijoIzq = hijoIzq;
        }

        if (hijoDer == null){
            System.out.println("Hijo derecho nulo, inicializado a nulo.");
            this.hijoDer = null;
        }else{
            this.hijoDer = hijoDer;
        }
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    @Override
    public int nodosMinimos() {
        return 1 + Math.min(this.getHijoIzq().nodosMinimos(),this.getHijoDer().nodosMinimos());
    }
}
