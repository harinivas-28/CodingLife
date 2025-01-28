import java.util.*;

public class Day2P2_PQ_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt(); // top x elements
        int f = sc.nextInt(); // powers f
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        int[] freq = new int[51];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.score-a.score);
        Deque<Integer> dq = new LinkedList<>(); // To store the Last added element
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<k;i++){ // Freq of nums in first window
            freq[nums[i]]++;
        }
        for(int j=0;j<51;j++){ // adding them to pq
            if(freq[j]!=0){
                pq.offer(new Pair(j, (int)Math.pow(j, freq[j])));
            }
        }
        int val = 0;
        for(int temp=0;temp<x;temp++){ // val of top x nums
            Pair p = pq.poll();
            dq.offerLast(p.num);
            val += p.num;
            pq.offer(new Pair(p.num, (int)p.score/p.num));
        }
        res.add(val);

        for(int i=k;i<n;i++){ // sliding the window
            freq[nums[i-k]]--;
            freq[nums[k]]++;
            pq.offer(new Pair(nums[i], freq[nums[i]]));
            val -= (!dq.isEmpty()) ? dq.pollFirst(): 0;
            Pair p = pq.poll();
            val += p.num;
            res.add(val);
            pq.offer(new Pair(p.num, p.score/p.num));
        }
        System.out.println(res);
    }
}
class Pair {
    int num;
    int score;
    public Pair(int num, int score){
        this.num = num;
        this.score = score;
    }
}