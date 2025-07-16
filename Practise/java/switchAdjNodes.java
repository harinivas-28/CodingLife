package Practise.java;
import java.util.*;

public class switchAdjNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printList(node);
        node = swapAdjacentNodes(node); // Fix swapping logic
        printList(node);
        sc.close();
    }

    private static ListNode swapAdjacentNodes(ListNode head) {
        if (head == null || head.next == null) return head; // Handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
        }
        return dummy.next;
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }
}