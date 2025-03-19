package Coding.java;

import java.util.Arrays;

public class ArrayUtils {
    public static int[] parseIntArray(String input) {
        return Arrays.stream(input.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}
