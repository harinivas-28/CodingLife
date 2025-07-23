package Practise.java;
import java.util.*;
import java.util.stream.IntStream;

public class streams {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5, 8, 1, 9, 2, 4);
        List<Integer> res = list.stream()
                .filter(x->x%2==0)
                .map(x->x*x)
                .sorted().toList();
        System.out.println(res);
        List<Integer> l1 = IntStream.range(1, 10).boxed().toList();
        l1.parallelStream().forEach(x->System.out.print(x+" "));
        System.out.println();
        l1.parallelStream().forEach(x-> System.out.println(Thread.currentThread().getName()+" => "+x));
    }
}
