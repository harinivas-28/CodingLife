package Problems.java;
import java.util.*;

/*
Imagine you're designing a sequence of signals for a high-tech robot.
The robot receives its instructions as list of integers, where each integer
represents one byte of the command data. A complete command can be composed of
1 to 4 bytes, following these strict rules:

- For a 1-byte command, the first bit must be 0, followed by the command's code.
- For a multi-byte command (with n bytes), the first byte starts with n
  consecutive 1’s, immediately followed by a 0. Each of the following n – 1 bytes
  must begin with the bit pattern 10.

This is how the robot interprets the byte sequences:

 Number of Bytes   |        Robot Signal Sequence
                   |              (binary)
-------------------+---------------------------------------
        1          |   0xxxxxxx
        2          |   110xxxxx 10xxxxxx
        3          |   1110xxxx 10xxxxxx 10xxxxxx
        4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Here, each x represents a bit that can be either 0 or 1.

Note: Only the least significant 8 bits of each integer in the input list of
integers are used, meaning each integer stands for exactly one byte of data.

Your challenge is to verify whether the provided sequence of robot instructions
strictly follows the defined encoding rules.

Example 1:
----------
Input=
197 130 1

Output=
true

Explanation:
- The array corresponds to the binary sequence: 11000101 10000010 00000001.
- This is a valid encoding: a 2-byte command (11000101 10000010) followed by a
  valid 1-byte command (00000001).

Example 2:
----------
Input=
234 140 4

Output=
false

Explanation:
- The array corresponds to the binary sequence: 11101011 10001100 00000100.
- The first three bits of the first byte are 1’s with a following 0, indicating
  a 3-byte command. The second byte starts correctly with 10, but the third byte
  does not begin with 10, so the command sequence is invalid.

Constraints:

- 1 <= instructions.length <= 2 * 10^4
- 0 <= instruction <= 255

*/
public class Day20P2_Bits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = ArrayUtils.parseIntArray(sc.nextLine());
        sc.close();
        int i = 0;
        while(i<a.length){
            int ones = countOnes(a[i]);
            // If 1-Byte ithe continue
            if(ones==0){
                i++;
                continue;
            }
            // if 1-4 bytes kanna ekkuva unna or only 1 or more than array length unna false
            if(ones>4 || ones==1 || i+ones>a.length){
                System.out.println(false);
                return;
            }
            i++; // move from command to the next sequence 
            for(int x=1;x<ones;x++){
                int n = a[i+x];
                // no of elements==ones, each element(byte) should start with '10'
                if(((n>>6)&1)!=0 || ((n>>7)&1)!=1){
                    System.out.println(false);
                    return;
                }
            }
            i += ones;
        }
        System.out.println(true);
    }
    private static int countOnes(int num){
        int i = 7, ones = 0;
        while(i>=0 && ((num>>i)&1)==1){
            ones++;
            i--;
        }
        return ones;
    }
}
/*
 * import java.util.*;
public class Solution{
    public static boolean verify(int[] a){
        int i = 0;
        while (i < a.length){
            String b = String.format("%8s", Integer.toBinaryString(a[i])).replace(' ', '0');
            int c = 0;
            for (char ch : b.toCharArray()){
                if (ch == '1') c++;
                else break;
            }
        if (c == 0){
            i++;
        } 
        else if (c >= 2 && c <= 4){
                if (i + c > a.length) return false;
                for (int j = 1; j < c; j++){
                    String d = String.format("%8s", Integer.toBinaryString(a[i + j])).replace(' ', '0');
                    if (!d.startsWith("10")) return false;
                }
                i += c;
            } 
        else return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] t = s.nextLine().trim().split("\\s+");
        int[] a = new int[t.length];
        for(int i=0; i<t.length; i++){
            a[i] = Integer.parseInt(t[i]);
            if(a[i]<0 || a[i]>255) return;
        }
        System.out.println(verify(a));
    }

}
 */