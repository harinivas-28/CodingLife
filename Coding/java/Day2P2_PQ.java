/*
You are a student organizer, and you are given n students. Each student has two values:
    Student Name: A unique identifier for the student.
    Score: The score achieved by the student.

Your goal is to organize these students in the order of their scores (highest score first). 
If two students have the same score, order them alphabetically by their names. 

Write a program to simulate how the students are organized using a priority queue.

Input Format:
-------------
Line-1: An integer, N
Next N lines: space separated string and integer, name and score of each student.

Output Format:
--------------
Organized students data as shown in samples.


Sample Input-1:
---------------
5
Alice 85
Bob 92
Charlie 78
Diana 95
Eve 88

Sample Output-1:
----------------
(Diana, 95)
(Bob, 92)
(Eve, 88)
(Alice, 85)
(Charlie, 78)


Sample Input-2:
---------------
4
Bob 90
Charlie 85
Diana 92
Alice 85

Sample Output-2:
----------------
(Diana, 92)
(Bob, 90)
(Alice, 85)
(Charlie, 85)

*/
package Coding;
import java.util.*;
public class Day2P2_PQ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b)->{
            if(a.score==b.score){
                return a.name.compareTo(b.name);
            }
            return Integer.compare(b.score, a.score);
        });
        for(int i=0;i<n;i++){
            String name = sc.next();
            int score = Integer.parseInt(sc.next());
            pq.add(new Student(name, score));
        }
        // while(!pq.isEmpty()){
        //     Student temp = pq.poll();
        //     System.out.println("("+temp.name+", "+temp.score+")");
        // }
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        sc.close();
    }
}
class Student {
    String name;
    int score;
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString(){
        return "("+this.name+", "+this.score+")";
    }
}
