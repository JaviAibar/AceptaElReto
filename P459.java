/*
Presupuestando semáforos
Tiempo máximo: 1,000-2,000 s  Memoria máxima: 8192 KiB
Semáforo en Capinota (Cochabamba, Bolivia). https://capinota.wordpress.com/2015/06/18/obras-inutiles-semaforos-sin-autos/
El tráfico en el pueblo se ha vuelto inmanejable. Hace unos años era raro ver dos tractores coincidir en una esquina. Ahora la salida del sol hace despertar a infinidad de coches, tractores, furgonetas, motos y otros medios de locomoción que llenan las calles de ruido y confusión. Si a eso le sumamos los peatones que zigzaguean por la falta de aceras y le añadimos aquellos que siguen moviéndose en burro, la situación es insostenible.

Como alcalde, Jacinto ha decidido coger el toro por los cuernos y, pese a las protestas de muchos vecinos, llenar el pueblo de semáforos. Pondrá, dice, un semáforo en cada calle que llegue a una intersección, trayendo la modernidad a este pueblo que hace bien poco no tenía ni las calles asfaltadas.

Eso sí, como el número de intersecciones en el pueblo es grande no podrá hacerlo de manera inmediata. El primer paso es incorporar la previsión del gasto en los presupuestos del año que viene. Y para eso necesita saber cuántos semáforos habrá que instalar, por lo que es hora de ponerse a contar.

Entrada
La entrada contiene distintos casos de prueba, cada uno con un plano en forma de cuadrícula.

La descripción de cada plano comienza con una línea con dos números con el ancho (1 ≤ a ≤ 1.000) y alto (1 ≤ l ≤ 1.000) del pueblo.

A continuación vienen l líneas cada una con a caracteres (distintos de espacios). Cada carácter tiene un significado (los hay para simbolizar parques, casas, consultorio médico...), pero el que nos interesa es el # que representa una calle (cuyo ancho es siempre 1). Las calles van en horizontal o vertical.

Salida
Por cada caso de prueba se escribirá una línea con un único número conteniendo el número de semáforos totales que hay que presupuestar.

Entrada de ejemplo
5 4
--#..
--#..
####'
:::##
7 3
..#....
#######
..#...#
7 4
..#....
#######
...#.#.
...#.#.
13 3
..#####...###
..#...#...#..
###...#####..
Salida de ejemplo
 
3
4
9
0
*/
import java.util.Scanner;

public class PresupuestandoSemaforos {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        while (lector.hasNext()) {
            int ancho = lector.nextInt();
            int lineas = lector.nextInt();
            lector.nextLine();
            String[] calle = new String[lineas];
            for (int i = 0; i < lineas; i++) {
                calle[i] = lector.nextLine();
            }
            int intersecciones = 0;
            for (int i = 0; i < lineas; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (calle[i].charAt(j) == '#') {
                        int interAux = 0;

                        if (i - 1 >= 0 && calle[i - 1].charAt(j) == '#') { // Miramos arriba
                            interAux++;
                        }

                        if (i + 1 < lineas && calle[i + 1].charAt(j) == '#') { // Miramos abajo
                            interAux++;
                        }

                        if (j - 1 >= 0 && calle[i].charAt(j - 1) == '#') { // miramos atrás
                            interAux++;
                        }

                        if (j + 1 < ancho && calle[i].charAt(j + 1) == '#') { // Miramos delante
                            interAux++;
                        }

                        if (interAux > 2) {
                            intersecciones += interAux;
                        }
                    }
                }
            }
            System.out.println(intersecciones);
        }
    }
}