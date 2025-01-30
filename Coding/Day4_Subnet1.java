import java.util.*;

public class Day4_Subnet1 {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int cidr = sc.nextInt();
        System.out.println(getIp(cidr));
        sc.close();
    }
    private static String getIp(int cidr){
        int mask = 0xffffffff << (32-cidr);
        return String.format("%d.%d.%d.%d",
            (mask >> 24) & 0xff,
            (mask >> 16) & 0xff,
            (mask >> 8) & 0xff,
            mask & 0xff
        );
    }
}