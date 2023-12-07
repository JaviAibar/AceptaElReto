import java.io.File;
import java.util.Scanner;

public class P342 {

    static final String YES = "LO SABE";
    static final String NO = "NO LO SABE";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            scan = new Scanner(new File("TestingData/P342_both.in"));
            
        } catch (Exception e) {
            System.err.println("Excepción al cargar el archivo de entrada "+e);
        }
        while (true) {
            int ini = scan.nextInt();
            int fin = scan.nextInt();
            int n = scan.nextInt();

            if (ini == 0 && fin == 0 && n == 0)
                break;

            int k = scan.nextInt();
            int[] hypotheses = new int[k];
            for (int i = 0; i < k; i++)
                hypotheses[i] = scan.nextInt();

            if (ini == fin) {
                System.out.println(YES);
                continue;
            }
            if (n == 0) {
                System.out.println(NO);
                continue;
            }

            boolean found = false;
            int closestBelow = -1;
            int closestAbove = 250001;
            for (int hipothesis : hypotheses) {
                if (hipothesis == fin && n == fin) {
                    System.out.println(YES);
                    found = true;
                    break;
                }
                if (n >= hipothesis && hipothesis > closestBelow) {
                    closestBelow = hipothesis;
                } else if (n < hipothesis && hipothesis < closestAbove) {
                    closestAbove = hipothesis;
                }
                if (closestAbove - closestBelow == 1) {
                    System.out.println(YES);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println(NO);
        }
    }
}