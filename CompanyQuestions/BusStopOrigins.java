package CompanyQuestions;
import java.util.*;
/*
Problem Title: Bus Stop Origins

Starting Point

On the way to Tracy's coaching center and her home, there are exactly N bus stops. These are numbered from 1 (coaching center) to N (Tracy’s home).The number of buses that can be boarded from each bus stop is also given.

Note:" A bus will only stop at a bus stop whose number is a multiple of the bus stop number from which the bus originates"

Find the number of buses originating from each bus stop between her coaching center and her home.

Input Specification
-------------------
input1: N Total number of bus stops. N<=10^4
input2: Array of N Elements, Bus[],Bus[i] = Number of buses that can be boarded from (i+1)th stop ,Bus(i)<=100

Output Specification
---------------------
Return an array of N elements: Result[],Result[i] = Number of buses originating from the (i+1)-th stop.

Example 1:
----------
input1 = 3
input2 = [1, 2, 3]

Output:
[1, 1, 2]

Explanation:
-----------
1 bus originates from the 1st bus stop and stops at all the bus stops.Hence, number of buses originating from 2nd bus stop = 2-1=1; bus from 2nd bus stop will not stop at 3rd bus stop. Hence number of buses originating from the 3rd bus stop =3-1( bus from 1st bus stop)=2.

Example 2:
---------
input1 = 2
input2 = [2, 7]


Output:
[2, 5]

Explanation:
------------
2 buses originate from 1st bus stop at the second bus stop.Hence number of buses originating from 1st bus stop is 7-2=5.
 */
public class BusStopOrigins {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = nums[i];
        }
        for(int i=0;i<n;i++){
            for(int j=2*(i+1);j<=n;j+=(i+1)){
                res[j-1] -= res[i];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
