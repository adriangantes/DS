/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e3;

import java.util.*;

public class Release {
    private final String id;
    private String title;
    private String artist;
    private final List<Track> tracklist;

    public Release(String id) {

        if (id == null || id.isEmpty()) {  // Si el ID es nulo o esta vacío lanza una excepción
            throw new IllegalArgumentException("ID nulo");
        }

        this.id = id; // Almacena el ID
        this.tracklist = new ArrayList<>(); // Crea una lista de pistas
    }

    public void setTitle(String title) {

        if (title == null || title.isEmpty()){ // Si el título es nulo o esta vacío lanza una excepción
            throw new IllegalArgumentException("Título nulo");
        }

        this.title = title; // Almacena el título
    }

    public void setArtist(String artist) {

        if (artist == null || artist.isEmpty()){ // Si el artista es nulo o esta vacío lanza una excepción
            throw new IllegalArgumentException("Artista nulo");
        }

        this.artist = artist; // Almacena el artista
    }

    public void addTrack(Track track) {
        if (track != null) { // Mientras la pista no sea nula la añade a la lista de pistas
            tracklist.add(track);
        }
    }

    public String getId() {
        return id;
    } //Devuelve el ID

    public String getTitle() {
        return title;
    } //Devuelve el título

    public String getArtist() {
        return artist;
    } //Devuelve el artista

    public List<Track> getTracklist() {
        return Collections.unmodifiableList(tracklist);
    } // Devuelve la lista de pistas

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(); // Crea el string

        sb.append("Lanzamiento: ").append(title).append(" - Artista: ").append(artist).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Tracklist:\n"); // Guarda los datos en el string

        for (Track track : tracklist) { // Recorre la lista de pistas y las añade al string
            sb.append(track).append("\n");
        }

        return sb.toString(); // Devuelve el string
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true; // Si es el mismo objeto devuelve verdadero
        if (o == null || getClass() != o.getClass()) return false; // Si el objeto es nulo o esta vacío devuelve falso

        int thisRecord = hashCode(); // Calcula el hashCode de this
        int otherRecord = o.hashCode(); // Calcula el hashCode del objeto

        return thisRecord == otherRecord; // Si son iguales, porque tienen las mismas grabaciones, devuelve verdadero
    }

    @Override
    public int hashCode() {

        int result = 0; // Valor inicial

        for (Track track : tracklist) { // Recorremos toda la lista de pistas
            result =  result + 3 * track.hashCode();
            // Por cada pista obtiene su hashcode, se multiplica por 3 y se suma al total
        }

        return result; //Devuelve el hashCode segun su lista de pistas
    }
}
