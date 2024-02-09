/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MesaBillarTest {
    private MesaBillar mesa;

    @BeforeEach
    public void setUp() {
        mesa = new MesaBillar();
    }

    @Test
    public void testIniciarPartida() {
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());
        assertEquals(16, mesa.bolasMesa().size());
        assertEquals(0, mesa.bolasCajetin().size());
    }

    @Test
    public void testMeterBolaBlancaAntesDeIniciar() {
        BolaBillar blanca = BolaBillar.BLANCA;

        try {
            mesa.meterBola(blanca);
            fail("Se esperaba una IllegalArgumentException");
        } catch (IllegalArgumentException ignored) {

        }

        assertFalse(mesa.esPartidaIniciada());
        assertEquals(0, mesa.bolasMesa().size());
        assertEquals(16, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(blanca));
    }

    @Test
    public void testMeterBolaBlancaDespuesDeIniciar() {
        mesa.iniciarPartida();
        BolaBillar blanca = BolaBillar.BLANCA;
        mesa.meterBola(blanca);
        assertTrue(mesa.esPartidaIniciada());
        assertEquals(16, mesa.bolasMesa().size());
        assertEquals(0, mesa.bolasCajetin().size());
        assertFalse(mesa.bolasCajetin().contains(blanca));
    }

    @Test
    public void testMeterBolaNegraAntesDeIniciar() {
        BolaBillar negra = BolaBillar.BOLA8;

        try {
            mesa.meterBola(negra);
            fail("Se esperaba una IllegalArgumentException");
        } catch (IllegalArgumentException ignored) {

        }

        assertFalse(mesa.esPartidaIniciada());
        assertEquals(0, mesa.bolasMesa().size());
        assertEquals(16, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(negra));
    }

    @Test
    public void testMeterBolaNegraDespuesDeIniciar() {
        mesa.iniciarPartida();
        BolaBillar negra = BolaBillar.BOLA8;
        mesa.meterBola(negra);
        assertFalse(mesa.esPartidaIniciada());
        assertEquals(15, mesa.bolasMesa().size());
        assertEquals(1, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(negra));
    }

    @Test
    public void testMeterBolaLisaDespuesDeIniciar() {
        mesa.iniciarPartida();
        BolaBillar lisa = BolaBillar.BOLA3;
        mesa.meterBola(lisa);
        assertTrue(mesa.esPartidaIniciada());
        assertEquals(15, mesa.bolasMesa().size());
        assertEquals(1, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(lisa));
    }

    @Test
    public void testMeterBolaRayadaDespuesDeIniciar() {
        mesa.iniciarPartida();
        BolaBillar rayada = BolaBillar.BOLA11;
        mesa.meterBola(rayada);
        assertTrue(mesa.esPartidaIniciada());
        assertEquals(15, mesa.bolasMesa().size());
        assertEquals(1, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(rayada));
    }

    @Test
    public void testMeterBolaBlancaPartidaFinalizada() {
        mesa.iniciarPartida();
        BolaBillar negra = BolaBillar.BOLA8;
        BolaBillar blanca = BolaBillar.BLANCA;
        mesa.meterBola(negra);
        mesa.meterBola(blanca);
        assertFalse(mesa.esPartidaIniciada());
        assertEquals(14, mesa.bolasMesa().size());
        assertEquals(2, mesa.bolasCajetin().size());
        assertTrue(mesa.bolasCajetin().contains(blanca));
    }

    @Test
    public void testObtenerGanadorEmpate() {
        mesa.iniciarPartida();
        BolaBillar bola1 = BolaBillar.BOLA1;
        BolaBillar bola9 = BolaBillar.BOLA9;
        mesa.meterBola(bola1);
        mesa.meterBola(bola9);
        assertEquals("Empate", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorLisas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA1);
        mesa.meterBola(BolaBillar.BOLA7);
        mesa.meterBola(BolaBillar.BOLA10);
        assertEquals("LISA", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorRayadas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA10);
        mesa.meterBola(BolaBillar.BOLA12);
        mesa.meterBola(BolaBillar.BOLA3);
        assertEquals("RAYADA", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorSinBolas() {
        mesa.iniciarPartida();
        assertEquals("Empate", mesa.obtenerGanador());
    }
}