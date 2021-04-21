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
public class TareaAnalisis5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Aca se instancia el string a utilizar
        String string = "Blanco, Amarillo y rojo, caramelos hay en todas partes, quien sabe que hora es";
        string = string.toLowerCase(); //Con esta instruccion se pone en minusculas

        //Inicializo los arreglos a utilizar, con asteriscos
        char solucion[] = new char[string.length()];
        char temporal[] = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            solucion[i] = '*';
            temporal[i] = '*';
        }

        //Llamo al algoritmo a utilizar
        DivideAndConquer divide = new DivideAndConquer();
        divide.DivideAndConquer(string, temporal, solucion, 0, 0);

        //Despliega el resultado
        System.out.println("****************Solucion*********************");
        System.out.print("[   ");
        for (int i = 0; i < string.length(); i++) {
            if (solucion[i] == '*') {
                break;
            }
            System.out.print(solucion[i] + "  ");
        }
        System.out.println("  ]");

        System.out.println("********Programacion Dinamica**************");
        //String a revisar
        //String string = "Blanco, Amarillo y rojo, caramelos hay en todas partes, quien sabe que hora es";
        //string = string.toLowerCase(); //Con esta instruccion se pone en minusculas

        //Inicializa la tabla a utilizar para la programación dinámica una matriz en este caso
        char tabla[][] = new char[string.length()][string.length()];

        //Tambien se inicia una solucion para guardar la combinación correcta
        char solucion2[] = new char[string.length()];

        //Aca inicializa con astericos ambas estructuras de datos
        for (int i = 0; i < tabla[0].length; i++) {

            solucion2[i] = '*';
            for (int j = 0; j < tabla[1].length; j++) {
                tabla[i][j] = '*';
            }
        }

        //Llama al algoritmo a utilizar
        Dinamica dinamica = new Dinamica();
        dinamica.AlgoritmoDinamica(string, tabla, solucion2);

        for (int i = 0; i < tabla[0].length; i++) {
            for (int j = 0; j < tabla[1].length; j++) {

                //if(tabla[i][j]=='*')
                // break;
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("****************Solucion*********************");
        System.out.print("[   ");
        for (int i = 0; i < string.length(); i++) {
            if (solucion2[i] == '*') {
                break;
            }
            System.out.print(solucion2[i] + "  ");
        }
        System.out.println("  ]");
    }
}
