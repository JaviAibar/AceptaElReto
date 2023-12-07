/*
 * Reina del súper
 * 
 * Hace tiempo, Ismael se enamoró perdidamente de una cajera del supermercado. No se cansa de espiarla entre la sección de ofertas y menaje del hogar.
 * Tiene la tarjeta echando humo, porque aunque tenga la nevera llena, todas las tardes baja a comprar cualquier cosa con tal de volver a verla. Y da igual cuánta gente haya; él siempre se pone a esperar en la fila de su caja.
 * Pero al llegar hoy al súper se ha llevado una desagradable sorpresa. Al cerebrito de turno que gestiona el supermercado le ha dado por instaurar la "fila única". Ahora en lugar de haber filas independientes para cada caja, hay una única fila para todas y cuando una caja se queda vacía, el primero que ocupa la fila va a ella.
 * El gerente del súper seguramente piense que ahora los clientes quedarán más satisfechos con el servicio proporcionado porque saben que nunca esperarán de más, pero a Ismael le han destrozado la vida. Ya no tiene la garantía de que le atienda su reina del súper particular cuando le toca pagar.
 * Sólo le queda una alternativa. Cuando se aproxima a la fila única, puede estimar cuánto tardará cada cliente en pasar por la caja en base a la cantidad de productos en el carrito y averiguar entonces en qué caja le tocará para ver si es la de su amada o no.

 * Entrada

 * La entrada estará compuesta por distintos casos de prueba, cada uno de ellos representando el estado del supermercado uno de los días en los que Ismael va a comprar.
 * Cada caso de prueba consta de dos líneas. La primera contiene el número n de cajas abiertas en ese momento (1 ≤ n ≤ 5) y el número c de clientes esperando (1 ≤ c ≤ 1.000). A continuación viene una línea con c números positivos que indican el número de segundos que tardará cada cliente en ser atendido. El primer número se corresponde con el tiempo de la primera persona de la fila única.
 
 * Salida

 * Para cada caso de prueba se escribirá una línea con el número de la caja en la que será atendido Ismael si se pone a esperar en ese momento.
 * Ten en cuenta que las cajas están numeradas de la 1 a la n y que en caso de quedar dos cajas libres a la vez, el primer cliente irá a la caja con menor número.
*/
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class P341 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
         
        // Este try-catch es para recibir la info desde el archivo
        try {
            scan = new Scanner(new File("TestingData/P341.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }
        int testCase = 0;
        while (scan.hasNext()) {
            System.out.printf("[%d] ",++testCase);
            int checkoutLen = scan.nextInt();
            int clientsLen = scan.nextInt();
            if (checkoutLen > clientsLen) {
                cleanBuffer(clientsLen);
                System.out.println(clientsLen+1);
                continue;
            }
            if (checkoutLen == 1) {
                cleanBuffer(clientsLen);
                System.out.println(1);
                continue;
            }
            
            int[] checkouts = new int[checkoutLen];
            int[] clients = new int[clientsLen - checkoutLen];
            
            for (int c = 0; c < clientsLen; c++) {
                if (c < checkoutLen) {
                    checkouts[c] = scan.nextInt();
                } else {
                    clients[c-checkoutLen] = scan.nextInt();
                }
            }
            clientsLen -= checkoutLen;
            
            int clientIndex = 0;
            boolean found = false;
            while (!found) {
                int[] empties = ReduceByMin(checkouts);
                for (int e = 0; e < empties.length; e++) {
                    if (clientIndex >= clientsLen) {
                        System.out.println(empties[e]+1);
                        found = true;
                        break;
                    }
                    checkouts[empties[e]] = clients[clientIndex++];
                }
            }
        }
        
    }

    private static void cleanBuffer(int clientsLen) {
        for (int c = 0; c < clientsLen; c++)
            scan.nextInt();
    }

    public static int[] ReduceByMin(int[] array) {
        int min = obtenerNumeroMasBajo(array);

        ArrayList<Integer> empties = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                array[i] = 0;
                empties.add(i);
            } else {
                array[i] -= min;
            }
        }
        return convertirListaAArray(empties);
    }

    public static int[] convertirListaAArray(List<Integer> listaInteger) {
        int[] arrayDeInt = new int[listaInteger.size()];
        int index = 0;

        for (Integer numero : listaInteger) {
            arrayDeInt[index++] = numero;
        }

        return arrayDeInt;
    }

    public static int obtenerNumeroMasBajo(int[] listaEnteros) {
        int minimo = listaEnteros[0];  // Inicializar con el primer elemento

        // Iterar sobre la lista para encontrar el número más bajo
        for (int i = 1; i < listaEnteros.length; i++) {
            int actual = listaEnteros[i];
            if (actual < minimo) {
                minimo = actual;
            }
        }

        return minimo;
    }
}