/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e3;

import java.util.*;
public record Track (String position, String record, String artist, String title, int duration){

    public Track{
        if (position == null || position.isEmpty()){ // Si la posición es nula o esta vacía lanza una excepción
            throw new IllegalArgumentException("Posicion nula");
        }
        if (record == null || record.isEmpty()){ // Si el ID es nula o esta vacía lanza una excepción
            throw new IllegalArgumentException("ID nula");
        }
        if (artist == null || artist.isEmpty()){ // Si el artista es nula o esta vacía lanza una excepción
            throw new IllegalArgumentException("Artista nulo");
        }
        if (title == null || title.isEmpty()){ // Si el título es nula o esta vacía lanza una excepción
            throw new IllegalArgumentException("Título nula");
        }
        if (duration <= 0){ // Si la duración es nula o esta vacía lanza una excepción
            throw new IllegalArgumentException("Duración no válida");
        }
    }

    public String getPosition(){
        return position;
    } // Devuelve la posición

    public String getRecord() {
        return record;
    } // Devuelve la grabación

    public String getArtist(){
        return artist;
    } // Devuelve el artista

    public String getTitle(){
        return title;
    } // Devuelve el título

    public int getDuration(){
        return duration;
    } // Devuelve la duración

    @Override
    public boolean equals(Object o) {

        if (this == o) return true; // Si son la misma pista devuelve true
        if (o == null || getClass() != o.getClass()) return false;
        // Si el objeto pasado es nulo o esta vacío devuelve falso

        return hashCode() == o.hashCode(); // Si ambos objetos tienen el mismo ID de grabación devuelve verdadero
    }

    @Override
    public int hashCode() { // Devuelve el hashCode de la pista según su grabación
        return Objects.hash(record);
    }

    @Override
    public String toString() { // Devuelve el string correspondiente a la pista

        return "Pista: " + position + " - Artista: " + artist
                + " - Título: " + title + " - Duración: " + duration
                + " segundos - Grabación: " + record;
    }

}