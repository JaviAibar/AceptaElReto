import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class P343 {
    
    
// Implement memoization
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Este try-catch es para recibir la info desde el archivo
        try {
            scan = new Scanner(new File("TestingData/P343_2s.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }
        int testCase = 0;
        while (true) {
            ++testCase;
            /*System.out.println(scan.nextLine());
            if (testCase < 10000) continue;*/
            int mesaX = scan.nextInt();
            int mesaY = scan.nextInt();
            int matamoscasX = scan.nextInt();
            int matamoscasY = scan.nextInt();
            //System.out.printf("mesaX %d, mesaY %d, mataX %d, mataY %d\n", mesaX, mesaY, matamoscasX, matamoscasY);
            if (mesaX == 0 && mesaY == 0 && matamoscasX == 0 && matamoscasY == 0) break;
            scan.nextLine();
            
            int[] res = new int[8]; // 0, 1, 2, 3, 4, 5, 6, 7
            char[][] mesa = new char[mesaY][mesaX];
            for (int y = 0; y < mesaY; y++) {
                String line = scan.nextLine();
                for (int x = 0; x < mesaX; x++) {
                    mesa[y][x] = line.charAt(x);
                   // System.out.print(mesa[y][x]);
                }
               // System.out.println();
            }

            for (int yM = 0; yM + matamoscasY <= mesaY; yM++) {
                for (int xM = 0; xM + matamoscasX <= mesaX; xM++) {
                    int count = 0;
                    for (int y = yM; y < matamoscasY + yM && count < 8; y++) {
                        for (int x = xM; x < matamoscasX + xM && count < 8; x++) {
                            if (mesa[y][x] == 'X') {
                                count++;
                            }
                        }
                    }
                    if (count < 8)
                        res[count]++;
                }
            }
            System.out.println(Arrays.toString(res));
        }
    }
}
