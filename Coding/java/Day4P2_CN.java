/*
Write a program that takes an IP address and subnet mask (in CIDR notation,
e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

Input Format:
---------------
A String, IPAddress
An integer, CIDR

Output Format:
---------------
Space separated IP addresses, netwrok IP and broadcast IP.


Sample Input-1:
-----------------
192.168.1.10
24

Sample Output-1:
------------------
192.168.1.0 192.168.1.255


Sample Input-2:
-----------------
192.0.2.1
24

Sample Output-2:
------------------
192.0.2.0 192.0.2.255

 */
package Coding.java;

import java.net.UnknownHostException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Day4P2_CN {
    public static void main(String[] args) throws UnknownHostException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cidr = sc.nextInt();
        sc.close();

//        int mask = 0xffffffff << (32-cidr);
//        int ip = toInteger(InetAddress.getByName(s).getAddress());
        int mask = -1 << (32-cidr);
        int ip = getIpFromString(s);
        int network = ip & mask;
        int broadcast = network | ~mask;

        System.out.println("Network: " + toString(network));
        System.out.println("Broadcast: " + toString(broadcast));
    }

    private static int toInteger(byte[] bytes) {
        int result = 0;
        for (byte b : bytes) {  // 1 byte is 8 bits so
            result = result << 8 | (b & 0xFF); // move 8 bits to left
        }
        return result;
    }

    private static String toString(int ip) {
        return String.format("%d.%d.%d.%d",
            (ip >> 24 & 0xff),
            (ip >> 16 & 0xff),
            (ip >> 8 & 0xff),
            (ip & 0xff));
    }
    private static int getIpFromString(String s){
        String[] str = s.split("\\.");
        return (Integer.parseInt(str[0]) << 24) |
                (Integer.parseInt(str[1]) << 16) |
                (Integer.parseInt(str[2]) << 8) |
                (Integer.parseInt(str[3]));
    }
}
