package Practise.java;
import java.util.*;
public class abstractInterfaces {
    interface t {
        void fly();
        void eat();
    }
    abstract static class f implements t {
        @Override
        public void eat(){
            System.out.println("Eating");
        }
        abstract void jump();
        void dash(){
            System.out.println("Dash");
        }
    }
    static class X extends f {
        @Override
        void jump() {
            System.out.println("Jump");
        }
        @Override
        public void fly() {
            System.out.println("Fly");
        }
    }
    public static void main(String[] args) {
        int[] t = {0, 1,2, 3, 4, 5};
        int m = Arrays.stream(t).max().getAsInt();
        System.out.println(m);
    }
}
