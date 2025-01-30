import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Day4_Subnet2 {
    public static void main(String[] args) throws UnknownHostException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cidr = sc.nextInt();
        sc.close();

        int mask = 0xffffffff << (32-cidr);
        int ip = toInteger(InetAddress.getByName(s).getAddress());

        int network = ip & mask;
        int broadcast = network | ~mask;

        System.out.println("Network: " + toString(network));
        System.out.println("Broadcast: " + toString(broadcast));
    }

    private static int toInteger(byte[] bytes) {
        int result = 0;
        for (byte b : bytes) {
            result = result << 8 | (b & 0xFF);
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
}
