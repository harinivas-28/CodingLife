package Practise.java;
import java.util.*;
public class temp {
    public static void main(String[] args) {
        int[] t = {0, 1,2, 3, 4, 5};
        int m = Arrays.stream(t).max().getAsInt();
        System.out.println(m);
    }
}
