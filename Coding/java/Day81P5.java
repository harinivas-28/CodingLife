package Coding.java;

import java.util.Scanner;

/*
Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information
between any two electronic devices.

Addresses in Type-I has the following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 and 255 only
	- each part is separated by periods(.)
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has the following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:)
	- each part should conatins atmost 4 alphanumerics,
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.

You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing,
return "Type-II" if belongs to "Type-II" Addressing,
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid

*/
public class Day81P5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        if(ipv4(s)){
            System.out.println("Type-I");
        } else if(ipv6(s)){
            System.out.println("Type-II");
        } else {
            System.out.println("Invalid");
        }
    }
    private static boolean ipv4(String s){
        String[] strs = s.split("\\.");
        if(strs.length!=4) return false;
        for(String x: strs){
            if (x.isEmpty() || (x.length() > 1 && x.startsWith("0"))) return false;
            try {
                int num = Integer.parseInt(x);
                if (num < 0 || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    private static boolean ipv6(String s){
        String[] strs = s.split(":");
        if(strs.length!=8) return false;
        for(String x: strs){
            if(x.isEmpty() || x.length()>4) return false;
            for(char c: x.toCharArray()){
                if(!isHex(c)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isHex(char c){
        return Character.isDigit(c) || (c>='a' && c<='f') || (c>='A' && c<='F');
    }
}
