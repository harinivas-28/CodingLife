package PYQ;
import java.util.*;
/*
DARWIN BOX - 01
Problem: Conference Meeting Room Booking
You are given multiple time intervals representing the booked time slots for a conference meeting room. Your task is to merge all overlapping or continuous time slots into a minimal list of non-overlapping time slots.

Input Format
The first line contains an integer T, the number of test cases.

For each test case:

The first line contains an integer n — the number of time intervals.

The next n lines each contain two integers start and end representing the start and end time in 24-hour format (e.g., 0900 for 9 AM).

Output Format
For each test case, output the merged time intervals.
Print each merged interval on a new line in the format:

start end
Constraints
1 ≤ T ≤ 100

1 ≤ n ≤ 10⁴

0000 ≤ start < end ≤ 2359

Times are in HHMM format, no colons.

Example Input
1
4
0900 1100
1000 1230
1245 1400
1330 1500

Example Output
0900 1230
1245 1500
Explanation
The first two intervals [0900, 1100] and [1000, 1230] overlap → merged to [0900, 1230].

The next two [1245, 1400] and [1330, 1500] overlap → merged to [1245, 1500].
 */
public class ConferenceMeeting {
    private static void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        List<int[]> ti= new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            ti.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        ti.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for(int[] it: ti){
            if(res.isEmpty() || res.get(res.size()-1)[1]<it[0]){
                res.add(it);
            } else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], it[1]);
            }
        }
        for(int[] x: res){
            System.out.println(x[0]+" "+x[1]);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
}
