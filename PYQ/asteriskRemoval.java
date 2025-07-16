package PYQ;

import java.util.Scanner;
// EPAM
// Coding Question 2 :- Clearance Asteroid-Removing  a string along with it’s preceding character .
//(Java only)
//Eg : Input – abc*def*u**
//Output – abd
public class asteriskRemoval {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*' && !sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
