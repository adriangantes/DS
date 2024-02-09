package e2;

abstract class NodoRutaFija extends Nodo {

    private final int ataque;
    private final Nodo hijo;

    public NodoRutaFija (char nombre, Nodo hijo, int ataque){
        super(nombre);

        if (hijo == null){
            System.out.println("Hijo nulo, inicializado a nulo.");
            this.hijo = null;
        }else{
            this.hijo = hijo;
        }

        if(ataque < 0){
            System.out.println("Ataque negativo, inicializado a 0.");
            this.ataque = 0;
        }else{
            this.ataque = ataque;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public Nodo getHijo() {
        return hijo;
    }

    @Override
    public int nodosMinimos() {
        return 1 + this.getHijo().nodosMinimos();
    }
}
