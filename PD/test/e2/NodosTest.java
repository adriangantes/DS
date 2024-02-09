package e2;

import org.junit.jupiter.api.Test;

public class NodosTest {
    @Test
    public void NodoFinalTest (){
        Barco barco1 = new Barco(1,1,1,1,1);
        Barco barco2 = new Barco(100,100,100,100,100);

        NodoFinal nodoA = new NodoFinal('A');
        NodoFinal nodoNulo = new NodoFinal('\0');
        nodoA.simulacion(barco1);
        nodoA.simulacion(barco2);
        nodoNulo.simulacion(barco1);
    }

    @Test
    public void NodoAtaqueAereoTest (){
        Barco barco1 = new Barco(1,1,1,1,1);
        Barco barco2 = new Barco(100,100,100,100,100);

        NodoFinal nodoA = new NodoFinal('A');
        NodoAtaqueAereo nodoB = new NodoAtaqueAereo('B', nodoA, 50);
        NodoAtaqueAereo nodoC = new NodoAtaqueAereo('C', null, -1);
        nodoB.simulacion(barco1);
        nodoB.simulacion(barco2);
        nodoC.simulacion(null);
        nodoC.simulacion(barco2);
    }

    @Test
    public void NodoTormentaMarinaTest (){
        Barco barco1 = new Barco(1,1,1,1,1);
        Barco barco2 = new Barco(100,100,100,100,100);

        NodoFinal nodoA = new NodoFinal('A');
        NodoTormentaMarina nodoB = new NodoTormentaMarina('B', nodoA, 50);
        NodoTormentaMarina nodoC = new NodoTormentaMarina('C', null, -1);
        nodoB.simulacion(barco1);
        nodoB.simulacion(barco2);
        nodoC.simulacion(null);
        nodoC.simulacion(barco2);
    }

    @Test
    public void NodoBatallaTest (){
        Barco barco1 = new Barco(1,1,1,1,1);
        Barco barco2 = new Barco(100,100,100,100,100);
        Barco barco3 = new Barco(60,60,1,60,60);
        Barco atacante = new Barco(50,50,50,50,50);

        NodoFinal nodoA = new NodoFinal('A');
        NodoFinal nodoC = new NodoFinal('C');
        NodoBatalla nodoB = new NodoBatalla('B', nodoA, nodoC, atacante);
        NodoBatalla nodoD = new NodoBatalla ('D',null,null, null);
        NodoBatalla nodoF = new NodoBatalla ('D',null,null, barco2);

        nodoB.simulacion(barco1);
        nodoB.simulacion(barco2);
        nodoD.simulacion(barco1);
        nodoD.simulacion(barco2);
        nodoD.simulacion(barco3);
        nodoD.simulacion(null);
        nodoF.simulacion(barco3);

        barco1.setHp(100);
        barco3.setHp(50);
        NodoBatalla nodoG = new NodoBatalla ('D',null,nodoA, barco1);
        nodoG.simulacion(barco3);
    }

    @Test
    public void NodoAvistamientoTest (){
        Barco barco1 = new Barco(1,1,1,1,1);
        Barco barco2 = new Barco(100,100,100,100,100);

        NodoFinal nodoA = new NodoFinal('A');
        NodoFinal nodoC = new NodoFinal('C');
        NodoAvistamiento nodoB = new NodoAvistamiento('B', nodoA, nodoC, 50);
        NodoAvistamiento nodoD = new NodoAvistamiento('B', null, null, 50);
        NodoAvistamiento nodoE = new NodoAvistamiento('B', null, null, -1);

        nodoB.simulacion(barco1);
        nodoB.simulacion(barco2);
        nodoB.simulacion(null);
        nodoD.simulacion(barco1);
        nodoD.simulacion(barco2);
    }
}
