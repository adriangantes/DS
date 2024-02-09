package e2;

import org.junit.jupiter.api.Test;

public class OperacionesTest {
    @Test
    public void operacionesTest (){
        Barco barcoB = new Barco(20,30,25,0,0);
        Barco barcoF = new Barco(30,17,41,0,0);
        Barco flotaA = new Barco(11,42,47,0,0);
        Barco flotaB = new Barco(1,25,0,46,28);

        NodoFinal nodoD = new NodoFinal('D');
        NodoFinal nodoH = new NodoFinal('H');
        NodoFinal nodoI = new NodoFinal('I');
        NodoFinal nodoK = new NodoFinal('K');

        NodoAtaqueAereo nodoE = new NodoAtaqueAereo('E', nodoK, 151);
        NodoTormentaMarina nodoG = new NodoTormentaMarina('G', nodoI, 67);

        NodoBatalla nodoF = new NodoBatalla('F', nodoH, nodoG, barcoF);

        NodoBatalla nodoB = new NodoBatalla('B', nodoD, nodoE, barcoB);
        NodoTormentaMarina nodoC = new NodoTormentaMarina('C', nodoF, 20);

        NodoAvistamiento nodoA = new NodoAvistamiento('A', nodoB, nodoC, 28);

        nodoA.simulacion(flotaA);
        nodoA.simulacion(flotaB);
        nodoA.printCaminoMinimo();
        nodoA.mostrarMapa();
    }
}
