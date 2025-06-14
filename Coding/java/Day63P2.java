package Coding.java;
import java.util.*;
/*
You are building memory management for a smart home hub where apps are loaded on-demand.
The hub has limited memory (cache size). If an app is not in memory (cache miss), it is loaded and
a page fault occurs. If memory is full, the Least Recently Used (LRU) app is removed.

Simulate the LRU page replacement and count total page faults.

Input Format:
-------------
- Cache size
- Space-separated app access sequence (e.g., Thermostat Camera Lights)

Output Format:
--------------
Total page faults
Final cache contents

Sample Input:
-------------
3
Thermostat Camera Lights Thermostat Camera Doorbell Lights Thermostat

Sample Output:
--------------
Total Page Faults: 6
Final Cache: [Doorbell, Lights, Thermostat]


Sample Input:
--------------
2
AC Light Fan AC Heater Light

Sample Output:
--------------
Total Page Faults: 6
Final Cache: [Heater, Light]
 */

public class Day63P2 {
    static class Node {
        String k;
        Node prev, next;
        Node(String k){
            this.k = k;
            prev = null;
            next = null;
        }
    }
    static int cap;
    static int pf = 0;
    static Map<String, Node> map;
    static Node head, tail;
    private static void add(Node t){
        t.next = head.next;
        t.prev = head;
        head.next.prev = t;
        head.next = t;
    }
    private static void remove(Node t){
        t.prev.next = t.next;
        t.next.prev = t.prev;
    }
    private static void put(String s){
        if(map.containsKey(s)){
            Node t = map.get(s);
            remove(t);
            add(t);
        } else {
            pf++;
            if(cap==map.size()){
                Node t = tail.prev;
                remove(t);
                map.remove(t.k);
            }
            Node newNode = new Node(s);
            add(newNode);
            map.put(s, newNode);
        }
    }
    public Day63P2(int capacity){
        map = new HashMap<>();
        cap = capacity;
        head = new Node("head");
        tail = new Node("tail");
        head.next = tail;
        tail.prev = head;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        Day63P2 sol = new Day63P2(n);
        for(String s: strs){
            put(s);
        }
        System.out.println("Total Page Faults: " + pf);
        System.out.print("Final Cache: [");
        Node temp = head.next;
        while (temp != tail) {
            System.out.print(temp.k);
            if (temp.next != tail) System.out.print(", ");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
/*
import java.util.*;

public class Solution {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s[]=sc.nextLine().split(" ");
        sc.close();
        LinkedHashSet<String> st=new LinkedHashSet<>();
        int j=0,ans=0;
        for(String i:s){
            if(st.contains(i)){
                st.remove(i);
                st.add(i);
            }
            else{
                ans++;
                if(st.size()==n){
                    Iterator<String> it=st.iterator();
                    it.next();
                    it.remove();
                }
                st.add(i);
            }
        }
        System.out.println("Total Page Faults: "+ans);
        System.out.println("Final Cache: "+st);
    }
}
 */