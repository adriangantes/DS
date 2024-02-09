/*
 * TITLE: Diseño Software LABS
 * SUBTITLE: Práctica 1
 * AUTHOR: Adrián Edreira Gantes LOGIN: adrian.gantes
 * GROUP: 1.2
 * DATE: 11 / 10 / 23
 */

package e2;
import java.util.Arrays;

public final class ImmutableMatrix  {

    private final int[][] matrix; // Crea una matriz inmutable

    public ImmutableMatrix(int[][] arr) { // Constructor para un array bidimensional

        if (!isValidMatrix(arr)) { // Si la matriz es irregular lanza  la excepción
            throw new IllegalArgumentException("Matriz irregular (ragged).");
        }

        matrix = new int[arr.length][arr[0].length]; // Crea la matriz

        for (int i = 0; i < arr.length; i++) { // Recorremos cada fila de la matríz
            System.arraycopy(arr[i], 0, matrix[i], 0, arr[0].length);
            // Guarda en cada columna de la fila "i" cada valor
        }
    }

    public ImmutableMatrix(int rows, int columns) { // Constructor para el número de filas y columnas

        if (rows <= 0 || columns <= 0) { // Si las columnas y/o las filas son menores que 0 lanza  la excepción
            throw new IllegalArgumentException("Filas y/o columnas deben ser mayores que cero.");
        }

        matrix = new int[rows][columns]; // Crea la matriz
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++; // Guarda en cada posición cada valor (de 1 a rows*columns)
            }
        }
    }

    private boolean isValidMatrix(int[][] arr) { // Comprueba si una matriz bidimensional es válida

        if (arr == null || arr.length == 0) { // Si la matriz es nula o el número de filas es 0
            return false;
        }

        int columns = arr[0].length; // Guarda en columns el número de columnas de la primera fila

        for (int[] row : arr) { // Recorre todas las filas de la matriz
            if (row.length != columns) { // Si alguna fila tienen menos columnas que la primera devuelve falso
                return false;
            }
        }

        return true; // Si no se han cumplido ninguna de las anteriores restricciones, la matriz es regular
    }

    public String toString() {

        StringBuilder string = new StringBuilder(); // StringBuilder para almacenar los números en un string

        for (int[] row : matrix) {
            string.append(Arrays.toString(row)).append("\n"); // Guarda cada valor de la matriz en el string
        }

        return string.toString(); // Devuelve el string con los números de la matriz
    }

    public int at(int row, int column) {
        if (row >= 0 && row < rowCount() && column >= 0 && column < columnCount()){
            return matrix[row][column]; // Si las coordenadas son válidas devuelve el elemento
        } else {
            throw new IllegalArgumentException("Coordenadas no válidas."); // Si no lanza una excepción
        }
    }

    public int rowCount() {
        return matrix.length;
    } // Devuelve el número de filas

    public int columnCount() {
        return matrix[0].length;
    } // Devuelve el número de columnas

    public int[][] toArray2D() {

        int rows = rowCount(), columns = columnCount(); // Obtiene las filas y columnas de la matriz inmutable

        int[][] copy = new int[rows][columns]; // Crea la copia de la matriz

        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, columns);
            // Guarda en la copia todos los valores de la matriz original con las mismas coordenadas
        }

        return copy; // Devuelve la copia
    }

    public ImmutableMatrix reverse() {

        int rows = rowCount(), columns = columnCount(); // Obtiene las filas y columnas de la matriz inmutable

        int[][] reversedMatrix = new int[rows][columns]; // Crea la nueva matriz inmutable

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                reversedMatrix[i][j] = at(i,rows-j);
                // Guarda en la nueva matriz los valores de la matriz original, invirtiendo las columnas en cada fila
            }
        }

        return new ImmutableMatrix(reversedMatrix); // Devuelve la nueva matriz inmutable
    }

    public ImmutableMatrix transpose() {

        int rows = rowCount(), columns = columnCount(); // Obtiene las filas y columnas de la matriz inmutable

        int[][] transposedMatrix = new int[columns][rows]; // Crea la nueva matriz inmutable

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
                // Guarda en la nueva matriz los valores de la matriz original, poniendo cada fila como columna
            }
        }

        return new ImmutableMatrix(transposedMatrix);  // Devuelve la nueva matriz inmutable
    }
    public ImmutableMatrix reshape(int newColumns) {

        int rows = rowCount(), columns = columnCount(); // Obtiene las filas y columnas de la matriz inmutable

        if (rows * columns % newColumns != 0) { // Si la nueva matriz fuese a ser irregular lanza una excepción
            throw new IllegalArgumentException("La matriz sería irregular.");
        } else{ // Si no procede a crear la nueva matriz

            int newRows = rows * columns / newColumns; // Crea el nuevo número de filas
            int[][] reshapedMatrix = new int[newRows][newColumns];
            // Crea la nueva matriz inmutable, con las nuevas filas y columnas
            int index, newRow, newColumn;

            for (int i = 0; i < rows; i++) { // Recorre las filas de la matriz original
                for (int j = 0; j < columns; j++) { // Recorre las columnas de la matriz original
                    index = i * columns + j; // Almacena la posición de la matriz original de forma unidimensional
                    newRow = index / newColumns; // Calcula la fila de la nueva matriz
                    newColumn = index % newColumns; // Calcula la columna de la nueva matriz
                    reshapedMatrix[newRow][newColumn] = matrix[i][j];
                    // Guarda el valor de la matriz original en las coordenadas de la nueva matriz
                }
            }

            return new ImmutableMatrix(reshapedMatrix);  // Devuelve la nueva matriz inmutable
        }
    }
}
