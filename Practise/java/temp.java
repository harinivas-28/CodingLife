package Practise.java;
import java.util.*;
interface t {
    void fly();
    void eat();
}
abstract class f implements t {
    @Override
    public void eat(){
        System.out.println("Eating");
    }
    abstract void jump();
    void dash(){
        System.out.println("Dash");
    }
}
class X extends f {
    @Override
    void jump() {
        System.out.println("Jump");
    }
    @Override
    public void fly() {
        System.out.println("Fly");
    }
}
public class temp {
    public static void main(String[] args) {
        int[] t = {0, 1,2, 3, 4, 5};
        int m = Arrays.stream(t).max().getAsInt();
        System.out.println(m);
    }
}
