/*
La pulga
Tiempo máximo: 1,000 s  Memoria máxima: 4096 KiB
Captura del juego 'La Pulga' para ZX Spectrum
"La pulga" es considerado el primer videojuego desarrollado en España. Creado por Paco Suárez y Paco Portalo, fue publicado en 1983 para ZX Spectrum y portado a otros ordenadores de la época, como MSX, Amstrad CPC y Commodore 64. Se exportó a muchos países con distintos nombres ("Bugaboo", "Roland in the Caves", "Il Paese Incantato", …) suponiendo el inicio de la llamada edad de oro del software español.

El juego comienza con una de las primeras "cinemáticas" (cut scenes) de la historia. Muestra a la pulga protagonista, Bugaboo, tripulando su sonda Cebolla X7 y estrellándose en un planeta del sector Almak-1 donde había detectado vida. Termina en una gruta de la que debe escapar saltando hasta volver a la superficie.

Una de las mecánicas más novedosas fue el control. En los juegos anteriores las teclas se transformaban en acciones inmediatas. En "La pulga", sin embargo, la protagonista salta con mayor o menor intensidad dependiendo del tiempo que el jugador haya mantenido pulsada la tecla de salto. En la pantalla se muestra una barra que indica la potencia y que crece rápidamente mientras la tecla se mantiene pulsada. Dependiendo del momento en el que se suelte, la pulga saltará más o menos. Si se pasa un tiempo máximo, la barra vuelve a la posición inicial (potencia 0) y empieza a crecer de nuevo.

Esta novedosa mecánica afectaba de forma decisiva a la jugabilidad. Cuando el jugador necesitaba huir rápidamente del único enemigo del juego, querría hacerlo saltando mucho pero eso requería mantener la tecla pulsada más tiempo, aumentando el peligro. Es de suponer que los desarrolladores hicieron muchas pruebas hasta afinar la mecánica y los tiempos para conseguir una buena jugabilidad.

Entrada
La entrada comienza con un número indicando cuántos casos de prueba deberán ser procesados. Cada caso de prueba está compuesto por tres números, 1 ≤ n ≤ 100, 1 ≤ f ≤ 100 y 1 ≤ t ≤ 100.000. El primero indica el número de pasos que tiene la barra de potencia. El segundo indica el factor por el que se multiplica la potencia indicada por la barra antes de aplicar el salto. Por último, t indica el tiempo, en centésimas de segundo, que se ha mantenido pulsada la tecla de salto.

Al principio, la barra está a 0 y se incrementa de uno en uno por cada centésima de segundo que la tecla se mantenga pulsada. Cuando se llena completamente, se pone a 0 y repite el ciclo.

Salida
Por cada caso de prueba el programa escribirá la potencia de salto que hay que aplicar a la pulga.

Entrada de ejemplo
3
32 1 32
32 1 33
40 10 46
Salida de ejemplo
32
0
50
*/
import java.util.Scanner;

public class Problema615 {

    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        int numCasos = tec.nextInt();
        tec.nextLine();

        for (int i = 0; i < numCasos; i++) {
            int n = tec.nextInt();
            int f = tec.nextInt();
            int t = tec.nextInt();
            
           /* if (t == 0)
                System.out.println(0);
            else*/ if (t <= n)
                System.out.println(t * f);
            else {
                int mod = t % n;
                if (mod == 0)
                System.out.println(n * f);
                else
                System.out.println((mod - 1)*f);
            }
        }
    }
}