/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MesaBillar {
    private boolean partidaIniciada;
    private List<BolaBillar> bolasMesa;
    private List<BolaBillar> bolasCajetin;

    public MesaBillar() {
        partidaIniciada = false; // Inicializa a falso

        bolasMesa = new ArrayList<>(); // Crea una lista para guardar las bolas sobre la mesa
        bolasCajetin = new ArrayList<>(); // Crea una lista para guardar las bolas fuera de la mesa

        Collections.addAll(bolasCajetin, BolaBillar.values()); // Agrega todas las bolas al cajetín
    }

    public void iniciarPartida() {
        partidaIniciada = true; // Inicia la partida
        bolasMesa.clear(); // Limpia la mesa
        bolasCajetin.clear(); // Limpia la caja de bolas
        Collections.addAll(bolasMesa, BolaBillar.values()); // Añade todas las bolas a la mesa
    }

    public void meterBola(BolaBillar bola) {

        if (bolasCajetin().contains(bola)){
            throw new IllegalArgumentException("La bola no esta en la mesa");
        }else{
            if (!partidaIniciada) { // Si la partida ha finalizado

                if (bola == BolaBillar.BLANCA){ // Si la bola es la blanca
                    bolasMesa.remove(bola); // Saca la bola de la mesa
                    bolasCajetin.add(bola); // Guarda la bola en el cajetín
                }

                return; // Si la partida no está en marcha no hace nada
            }

            if (bola == BolaBillar.BOLA8) { // Si la bola es la negra
                bolasMesa.remove(bola); // Saca la bola de la mesa
                bolasCajetin.add(bola); // Guarda la bola en el cajetín
                partidaIniciada = false; // La partida ha acabado

            } else if (bola.getNumero() >= 1 && bola.getNumero() <= 7 || bola.getNumero() >= 9 && bola.getNumero() <= 15) {
                // Si la bola es lisa o rayada
                bolasMesa.remove(bola); // Saca la bola de la mesa
                bolasCajetin.add(bola); // Guarda la bola en el cajetín
            }
        }

    }

    public List<BolaBillar> bolasMesa() {
        return bolasMesa;
    }

    public List<BolaBillar> bolasCajetin() {
        return bolasCajetin;
    }

    public boolean esPartidaIniciada() {
        return partidaIniciada;
    }

    public String obtenerGanador() {

        if (!bolasMesa.isEmpty()){ // Si la mesa no esta vacía
            int contadorLisas = 0, contadorRayadas = 0, numero;

            for (BolaBillar bola : bolasMesa) { // Recorre todas las bolas que quedan en la mesa

                numero = bola.getNumero(); // Obtiene el numero de la bola de la mesa

                if (numero >= 1 && numero <= 7) { // Si el numero pertenece a las lisas
                    contadorLisas++; // Suma uno al contador de lisas
                } else if (numero >= 9 && numero <= 15) { // Si el numero pertenece a las rayadas
                    contadorRayadas++; // Suma uno al contador de rayadas
                }
            }

            if (contadorLisas < contadorRayadas) { // Si hay más rayadas, devuelve el tipo de las bolas lisas
                return BolaBillar.BOLA1.getTipo();
            } else if (contadorLisas > contadorRayadas) { // Si hay más lisas, devuelve el tipo de las bolas rayadas
                return BolaBillar.BOLA9.getTipo();
            }
        }

        // Si no devuelve nada antes devuelve empate
        // Porque la mesa esta vacía o hay el mismo número de lisas que de rayadas
        return "Empate";
    }
}
