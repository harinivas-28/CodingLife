package CompanyQuestions;
import java.util.*;
/*
Question 6 – Construction Work

Construction Work

Luke likes to construct and play with arrays. His dad gave him an array 'M' of length 'N' and assigned to him the following tasks to be done in order:

1. Create continuous groups of size i with the elements of the array M.
2. Once the groups are created, find the minimum values from each group and select the maximum value among all these minimum values.
3. Place the highest value as iᵗʰ element in the new array P.
4. Repeat the process until the group size becomes equal to N.

You must help Luke to find the array P and return it as the output.

Note: Assume 1-based indexing in array M and P.



Input Specification:
--------------------
 input1: An integer value N, representing the length of the array M
 input2: An integer array M, representing the array Luke’s dad gave him

Output Specification:
---------------------
Return the array P as the output.

Example 1:
----------
input1: 3
input2: [1,2,3]


Output: [3,2,1]

Explanation:
------------

With the given array M={1,2,3} we can create continuous groups of size 1,2 and 3

 →There are three Groups of size 1: {1},{2},{3} and the minimum elements in these groups are the elements themselves.We get three choices 1,2 and 3 ,of which the maximum is 3; therefore,the first element of the array p will be 3

 →There are two Groups of size 2 : {1,2},{2,3} and the minimum elements in these groups are {1}and{2},of which the Maximum is 2;therefore,the second element of the array P will be 2

 →There is only one Group of size 3: {1,2,3} and the minimum element of the group is 1.Now, as there are no alternatives to choose from, the third element of the array P will be 1

Therefore,[3,2,1] is returned as the output.


Example 2:
----------

input1: 4
input2: [20,10,30,40]


Output: [40,30,10,10]

Explanation:
------------
With the given array M = [20,10,30,40], we can create continuous groups of size 1,2,3 and 4

 →there are four Groups of size 1 :(20), (10), (30), (40), and the minimum elements in these groups are the elements themselves.We get four choices 20,10,30 and 40 of which the maximum is 40 therefore the first element of the array P will be 40.
 →there are three Groups of size 2 :(20,10),(10,30) and (30,40), the minimum elements in these groups are (10),(10),(30) of which the maximum is 30; therfore, the second element of the array P will be 30.
 →there are two Groups of size 3 :(20,10,30) and (10,30,40), the minimum elements in these groups are (10) and (10) of which the maximum is 10; therefore, the third element of the array P will be 10.
→ there is one group of size 4: (20,10,30,40) and the minimum element of the group is 10,Now as there are no alternatives to choose from the fourth element of the array P will be 10.

Therfore (40,30,10,10) is returned as the output.
 */
public class ConstructionWork {
    private static int[] solve(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        for(int i=1;i<=n;i++){ // window size from 1 to n
            Deque<Integer> dq = new LinkedList<>();
            int maxMin = Integer.MIN_VALUE; // maximum value from the minimum's
            for(int j=0;j<n;j++){
                while(!dq.isEmpty() && dq.peekFirst()<j-i+1){
                    dq.pollFirst();
                }
                while(!dq.isEmpty() && nums[dq.peekLast()]>=nums[j]){
                    dq.pollLast();
                }
                dq.offerLast(j);
                if(j>=i-1){
                    maxMin = Math.max(maxMin, nums[dq.peekFirst()]);
                }
            }
            res[i-1] = maxMin;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        int[] res = solve(nums);
        System.out.println(Arrays.toString(res));
    }
}
