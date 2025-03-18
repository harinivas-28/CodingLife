package practise.java;

public class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(){};

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode prev, ListNode next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
