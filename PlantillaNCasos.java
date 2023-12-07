import java.io.File;
import java.util.Scanner;

public class PlantillaNCasos {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

         // Este try-catch es para recibir la info desde el archivo
        try {
            scan = new Scanner(new File("TestingData/PXXX.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }

        int cases = scan.nextInt();
        // Limpiar el buffer por salto de linea
        scan.nextLine();
        for (int c = 0; c < cases; c++) {

        }
    }
}