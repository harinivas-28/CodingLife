package PYQ;

import java.util.Scanner;
// EPAM
// Coding Question 1 :-  Reverse a string without changing sequence of special characters.(Java only)
// Eg : Input  -  abc@def_m_$u
//      Output – umf@edc_b_$a
public class reverseStringSpecialChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int i=0, j=arr.length-1;
        while(i<j){
            if(!Character.isLetterOrDigit(arr[i])){
                i++;
            } else if(!Character.isLetterOrDigit(arr[j])){
                j--;
            } else {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
        System.out.println(new String(arr));
    }
}
