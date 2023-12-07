import java.io.File;
import java.util.Scanner;

public class PlantillaHasNext {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         
        // Este try-catch es para recibir la info desde el archivo
        try {
            scan = new Scanner(new File("TestingData/PXXX.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }
        while (scan.hasNext()) {

        }
    }
}