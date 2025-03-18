package practise.java;
import java.util.*;
public class switchAdjNodes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ListNode node = new ListNode();
        ListNode temp = node;
        for(int i=0;i<arr.length;i++){
            temp.val = arr[i];
            temp = temp.next;
        }
        // NOTE: Unfinished Work
        sc.close();
    }
}
