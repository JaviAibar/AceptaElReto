/*
Repartiendo regalos en tu calle
Tiempo máximo: 1,000-2,000 s  Memoria máxima: 4096 KiB
Papá Noel quiere repartir juguetes a todos los niños de la mejor calle del mundo: la tuya. Para ello, consulta una lista de los portales de esa calle en los que debe dejar regalos.

La forma en la que reparte los regalos es peculiar. Aterriza con su trineo en un portal determinado (que no tiene por qué ser uno en los que tiene que dar regalos), y luego sigue las siguientes reglas:

Reparte los regalos al portal que tiene más cerca de su posición actual.
La distancia entre dos portales es el valor absoluto de su resta. Es decir, la distancia entre el portal 10 y el portal 8 es 2 (10 − 8 = 2), lo mismo que la distancia entre el portal 8 y el portal 10 (valor absoluto de 8 − 10).
Si dos portales están a igual distancia, siempre va hacia el que tiene el número más grande.
¿Cuál es el orden en el que visita los portales?

Entrada
La entrada comienza con un número que indica el número de casos de prueba que siguen a continuación.

Cada caso de prueba tiene dos líneas. La primera contiene el número p del portal en el que Papá Noel aterriza (0 ≤ p ≤ 5.000) seguido del número n de portales donde hay que repartir regalos (2 ≤ n ≤ 1.000). La segunda línea tiene n números distintos entre 0 y 5.000 con los números del portal en los que hay que dejar regalos.

Salida
Por cada caso de prueba se mostrará una única línea con el orden en el que Papá Noel irá dejando los regalos cumpliendo las normas anteriores. El portal en el que aterriza debe mostrarse únicamente si en él hay que dejar algo.

Entrada de ejemplo
3
0 2
2 4
3 3
2 5 1
3 3
2 4 7
Salida de ejemplo
 
2 4
2 1 5
4 2 7
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class P367 {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

         // Este try-catch es para recibir la info desde el archivo
        try {
            scan = new Scanner(new File("TestingData/P367.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }

        int cases = scan.nextInt();
        scan.nextLine();
        for (int c = 0; c < cases; c++) {
            int initialPortal = scan.nextInt();
            int nGifts = scan.nextInt();
            scan.nextLine();
            int[] portals = new int[nGifts];
            for (int g = 0; g < nGifts; g++) {
                portals[g] = scan.nextInt();
            }
            
            Arrays.sort(portals);
           
            int pos = getPos(initialPortal, portals);
            
            if (pos == nGifts-1) {
                System.out.println(subarrayToString(nGifts-1, 0, portals));
                continue;
            }
            int leftPivot = pos;
            int rightPivot = pos + 1;
            int current = initialPortal;
            String res = "";
            while (true) {
                int leftDistance = Math.abs(current - portals[leftPivot]);
                int rightDistance = Math.abs(portals[rightPivot] - current);
                

                if (rightDistance <= leftDistance) {
                    current = portals[rightPivot];
                    res += " "+portals[rightPivot++];
                } else {
                    current = portals[leftPivot];
                    res += " "+portals[leftPivot--];
                }

                if (leftPivot < 0) {
                    res += " " + subarrayToString(rightPivot, nGifts-1, portals);
                    break;
                }
                else if (rightPivot > nGifts-1) {
                    res += " " + subarrayToString(leftPivot, 0, portals);
                    break;
                }
            }
            System.out.println(res.trim());
        }
    }

    public static int getPos(int num, int[] array) {
        int len = array.length;
        int pos = 0;
        for(int i = 1; i < len; i++) {
            if (array[i] > num){
                return pos;
            }
            pos = i;
        }
        return pos;
    }
    
    public static String subarrayToString(int initPos, int endPos, int[] array) {
        String res = ""+array[initPos];
        
        if (endPos > initPos) {
            for (int i = initPos+1; i <= endPos; i++) {
                res += " "+array[i];
            }
        } else {
            for (int i = initPos-1; i >= endPos; i--) {
                res += " "+array[i];
            }
        }

        return res;
    }




     public static void testingGetPos() {
        ArrayList<int[]> arrays = new ArrayList<int[]>();
        int[] inputNums = new int[]{4, 2, 3, 4, 5, 8, 0};
        int[] expectedOutputs = new int[]{1, 0, 0, 0, 1, 3, 0};
        arrays.add(new int[]{1, 3, 5, 6, 7});
        arrays.add(new int[]{3, 5, 6, 7});
        arrays.add(new int[]{3, 5, 6, 7});
        arrays.add(new int[]{3, 5, 6, 7});
        arrays.add(new int[]{3, 5, 6, 7});
        arrays.add(new int[]{3, 5, 6, 7});
        arrays.add(new int[]{0, 5, 6, 7});

        for (int i = 0; i < expectedOutputs.length; i++) {
            int res = getPos(inputNums[i], arrays.get(i));
            if (res == expectedOutputs[i])
                System.out.printf("[%d] Correct\n", i);
            else
                System.out.printf("[%d] Error: Expected %d but was %d\n", i, expectedOutputs[i], res);
        }
    }

    public static void testingSubarrayToString() {
        ArrayList<int[]> arrays = new ArrayList<int[]>();
        String[] expectedOutputs = new String[7];
        // these numbers will be taken by pair (0, 3) to be init and end pos 
        int[] inputNums = new int[]{0, 3, 3, 0, 2, 2, 0, 0, 7, 7, 1, 4, 5, 1
        };

        arrays.add(new int[]{1, 3, 5, 6, 7});
        expectedOutputs[0] = "1 3 5 6";

        arrays.add(new int[]{3, 5, 6, 7});
        expectedOutputs[1] = "7 6 5 3";

        arrays.add(new int[]{68, 24, 42, 89, 5});
        expectedOutputs[2] = "42";
        
        arrays.add(new int[]{-21, 8, -37, 50, -15, 0, 12, -48});
        expectedOutputs[3] = "-21";

        arrays.add(new int[]{-21, 8, -37, 50, -15, 0, 12, -48});
        expectedOutputs[4] = "-48";

        arrays.add(new int[]{73, 29, 50, 14, 91, 6});
        expectedOutputs[5] = "29 50 14 91";

        arrays.add(new int[]{2, -7, 10, 0, -3, 8, -5});
        expectedOutputs[6] = "8 -3 0 10 -7";
        /*
        arrays.add(new int[]{46, 14, 33, 21, 8, 49, 2, 30, 11, 5});
        arrays.add(new int[]{72, -88, 55, -37});*/

        for (int i = 0; i < inputNums.length; i+=2) {
            String res = subarrayToString(inputNums[i], inputNums[i+1], arrays.get(i/2));
            if (res.equals(expectedOutputs[i/2]))
                System.out.printf("[%d] Correct\n", i/2);
            else
                System.out.printf("[%d] Error: Expected %s but was %s\n", i/2, expectedOutputs[i/2], res);
        }
    }
}
