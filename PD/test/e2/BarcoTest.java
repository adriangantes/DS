package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {
    @Test
    public void barcosTest (){
        Barco flota = new Barco(11,42,47,46,28);
        Barco negativo = new Barco(-1,-1,-1,-1,-1);

        assertEquals(flota.getHp(),11);
        assertEquals(flota.getBlindaje(),42);
        assertEquals(flota.getAtaque(),47);
        assertEquals(flota.getAntiaereo(),46);
        assertEquals(flota.getVision(),28);
        flota.setHp(20);
        assertEquals(flota.getHp(),20);
    }
}
