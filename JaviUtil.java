public class JaviUtil {
    public static int[] stringToArray(String line) {
        String[] numbersString = line.split(" ");
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        return numbers;
    }
}
