/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e1;

public class StringUtilities {

    public static boolean isValidString(String string, String valids, int minLength){

        if (string == null || string.isEmpty() || string.length() < minLength) {
            // Para una cadena vacía, nula o menor que la longitud minima devuelve falso
            return false;
        }

        for (char c : string.toCharArray()) { // Para cada caracter del string
            if (!Character.isDigit(c) && valids.indexOf(c) == -1) {
                // Si algún caracter no es un número o un caracter válido devuelve falso
                return false;
            }
        }

        return true; // Si se cumplen las condiciones devuelve verdadero
    }

    public static String lowercaseFirst(String string) {

        if (string == null) { // Si el string de entrada es nulo o esta vacío devuelve nulo
            return null;
        }

        StringBuilder minus = new StringBuilder(); // StringBuilder para almacenar caracteres en minúscula
        StringBuilder mayus = new StringBuilder(); // StringBuilder para almacenar caracteres en mayúscula

        for (char c : string.toCharArray()) { // Para cada caracter del string
            if (Character.isLowerCase(c)) { // Si es minúscula la almacena en minus
                minus.append(c);
            } else { // Si no la almacena en mayus
                mayus.append(c);
            }
        }

        minus.append(mayus); // Añade a minus, por el final, los caracteres de mayus

        return minus.toString(); // Devuelve el string deseado
    }


    public static boolean checkTextStats(String string, int minLength, int maxLength) {

        if (string == null || string.isEmpty()) { // Verifica si el string es nulo o vacío
            throw new IllegalArgumentException("El texto de entrada es nulo o vacío.");
        }

        if (minLength <= 0 || maxLength <= 0) { // Verifica que los valores mínimo y máximo son válidos
            throw new IllegalArgumentException("Los valores mínimos y máximos deben ser positivos.");
        }

        if (minLength > maxLength) { // Verifica que el mínimo sea menor que el máximo
            throw new IllegalArgumentException("El valor mínimos debe ser menor que el valor máximo deben.");
        }


        String[] words = string.split(" "); // Divide el string en palabras usando espacios como separador

        int totalLength = 0, maxLengthWordLength = 0;

        for (String word : words) { // Calcula con cada palabra la longitud total de las palabras
            totalLength += word.length();

            if (word.length() > maxLengthWordLength) { // Si una palabra es mas larga que la palabra más larga guardada
                maxLengthWordLength = word.length(); // Actualiza la longitud más larga
            }
        }

        double averageLength = (double) totalLength / words.length;// Calcula la longitud media de las palabras

        return averageLength >= minLength && averageLength <= maxLength &&
                maxLengthWordLength <= 2 * averageLength; // Verifica ambas condiciones, si se cumplen devuelve verdadero
    }
}