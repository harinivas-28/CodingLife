package Coding.java;

import java.util.*;

public class Day11P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<=l.length()-10;i++){
            String sub = l.substring(i, i+10);
            if(sub.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}")){
                set.add(sub.substring(sub.length()-4));
            }
        }
        System.out.println(set.size());
    }
}
