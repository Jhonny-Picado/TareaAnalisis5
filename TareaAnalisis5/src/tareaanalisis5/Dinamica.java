/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaanalisis5;

/**
 *
 * @author Jhonny Picado Vega
 */
public class Dinamica {

    public Dinamica() {

    }


    /* Este corresponde al algoritmo de programación dinámica, recibe por parametros
        un string, la tabla de memoizacion y un arreglo.
     */
    public void AlgoritmoDinamica(String string, char[][] tabla, char[] solucion) {

        //Primeramente se realiza una iteración sobre el string
        for (int i = 0; i < string.length(); i++) {

            //Después, siempre se asigna cada letra al primer elemento de una celda
            tabla[i][0] = string.charAt(i);

            //Inicio un index que se ubica en las posiciones de la tabla
            int index = 1;

            //Aca se elimino la llamada recursiva, y se puso una iteración que recorra
            //las siguientes letras de la que se está evaluando
            for (int j = i + 1; j < string.length(); j++) {

                /* Revisa el unico caso posible, y utiliza el resultado parcial de la tabla
                En este caso, revisa si la ultima letra registrada es la anterior de 
                la letra por la cual se esta iterando en el segundo ciclo */
                if (tabla[i][index - 1] + 1 == string.codePointAt(j)) {

                    //Realiza la memoización, si se cumplió el caso
                    tabla[i][index] = string.charAt(j);
                    index++;
                }
            }

            //Después de revisar la solución construida, entonces intercambia valores
            if (Mejor(solucion, tabla[i], string.length())) {
                System.arraycopy(tabla[i], 0, solucion, 0, string.length());
            }
        }
    }

    public boolean Mejor(char[] actual, char[] aspirante, int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            if (actual[i] == '*' && aspirante[i] != '*') {
                return true;
            } else if (actual[i] == '*' && aspirante[i] == '*') {
                return false;
            }
        }
        return false;
    }

}
