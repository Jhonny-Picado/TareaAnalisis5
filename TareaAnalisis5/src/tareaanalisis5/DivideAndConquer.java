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
public class DivideAndConquer {

    public DivideAndConquer() {

    }

    /* Algoritmo de DivideAndConquer que busca la mayor secuencia ordenada
    en un string, recibe de parametros el string, un arreglo donde se va
    guardando la posible solución y un arreglo para almacenar la solucion.
    Ademas, usa dos variables enteras que se necesitan */
    public void DivideAndConquer(String string, char[] temporal, char[] solucion, int posicion, int index) {

        //Primeramente itera sobre los elementos del string
        for (int i = posicion; i < string.length(); i++) {

            //Consulta si el index, que es la posición en donde se esta
            //guardando la solucion es 0
            if (index == 0) {

                //Entonces guarda la letra en el temporal y busca 
                //recursivamente entre el resto del string
                temporal[index] = string.charAt(i);
                DivideAndConquer(string, temporal, solucion, 0, index + 1);
            } //Aca valida si el siguiente de la ultima letra guardada en temporal 
            //es igual a la letra del string donde esta revisando
            else if (temporal[index - 1] + 1 == string.codePointAt(i)) {

                /* Si lo cumple entonces guarda la letra y busca recursivamente 
            Con la peculiaridad de que la siguiente recursión iniciará en la 
            ultima posicion iterada */
                temporal[index] = string.charAt(i);
                DivideAndConquer(string, temporal, solucion, i, index + 1);
            }
        }

        /* Aca depues de haber realizado la solución, llama a una función 
        auxiliar para validar si la solucion construida en la recurción es 
        mejor que la actual */
        if (Mejor(solucion, temporal, string.length(), index)) {
            System.arraycopy(temporal, 0, solucion, 0, string.length());
        }
    }

    public boolean Mejor(char[] actual, char[] aspirante, int cantidad, int index) {
        for (int i = index; i < cantidad; i++) {
            aspirante[i] = '*';
        }
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
