import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestingP341 {
     public static void main(String[] args) {
        TestReduceByMin();
    }

    public static void TestReduceByMin() {
        ArrayList<Integer> lists = new ArrayList<>();

        Scanner input = null;
        Scanner output = null;

        try {
            input = new Scanner(new File("TestingData/TestReduceByMin.in"));        
            output = new Scanner(new File("TestingData/TestReduceByMin.out"));
        } catch (Exception e) {
            System.err.println("ERROR al cargar archivos de test "+e);
        }
        
        int i = 0;

        while (input.hasNext()) {
            int[] arrayInput = JaviUtil.stringToArray(input.nextLine());
            int[] arrayOutput = JaviUtil.stringToArray(output.nextLine());
            //System.out.println(Arrays.toString(arrayInput));
           // System.out.println(Arrays.toString(arrayOutput));

            int[] res = P341.ReduceByMin(arrayInput);

            if (Arrays.equals(res, arrayOutput))
                System.out.printf("[%d] Correct!\n", i);
            else
                System.err.printf("[%d] Error: Expected %s, but got %s\n", i, Arrays.toString(arrayOutput), Arrays.toString(res));
            i++;
        }
    }
}
