package Problems.java;

import java.util.Arrays;

public class ArrayUtils {
    public static int[] parseIntArray(String input) {
        return Arrays.stream(input.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
    public static int[] parseIntArray(String input, int n) {
        return Arrays.stream(input.split(" "))
                .limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
