package Problems.java;
import java.util.*;
/*
There are N employees from 3 different companies in a row, emps[], the employees
are identified using company IDs as 1,2,3. A Courier Boy need to deliver
P parcels to these 3 companies. The parcel details are given as parcels[],
where parcel[i]=[Ci,CIDi], i-th parcel, 'Ci' is Courier Boy's current position,
and  'CIDi' is company's ID, he/she needs to deliver parcel[i] from Ci position
to the nearest employee belongs to company ID equals to CIDi in the row.

You are given emps[] and parcels[] information,
Your task is to help the courier boy to find the distance between him to
the nearest employee in that row to deliver the parcel.
If there is no solution found, return -1.

Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, only 1, 2 & 3.
Next P lines: Two space separated integers, position Ci and Company ID

Output Format:
--------------
Print the space separated integers, distance between boy and the employee for
all the parcels.


Sample Input-1:
---------------
6 2
1 1 2 2 3 3
1 3
2 2

Sample Output-1:
----------------
3 0

Sample Input-2:
---------------
5 2
1 2 3 2 1
2 1
1 1

Sample Output-2:
----------------
2 1

 */
public class Day44P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        int[] cmp = new int[n];
        for(int i=0;i<n;i++) cmp[i] = sc.nextInt();
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<p;i++){
            int x = sc.nextInt(), y = sc.nextInt();
            l.add(new int[]{x, y});
        }
        System.out.println("Brute Force: "+bruteForce(n, p, cmp, l)); // O(n*p)
        System.out.println("Optimized Binary Search: "+optimizedBS(n, p, cmp, l)); // O(n+p*logn)
        System.out.println("Optimized 2-Pass: "+optimized2Pass(n, p, cmp, l)); // O(n*(no of uniqueValues in cmp==3))

    }
    private static String optimized2Pass(int n, int p, int[] cmp, List<int[]> l){
        Set<Integer> s = new HashSet<>();
        for(int x: cmp) s.add(x);
        Map<Integer, int[]> map = new HashMap<>();
        for(int x: s){
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int last = -1;
            for(int i=0;i<n;i++){
                if(cmp[i]==x) last = i;
                if(last!=-1) dist[i] = i-last;
            }
            last = -1;
            for(int i=n-1;i>=0;i--){
                if(cmp[i]==x) last = i;
                if(last!=-1) dist[i] = Math.min(dist[i], last-i);
            }
            map.put(x, dist);
        }
        int[] res = new int[p];
        for(int i=0;i<p;i++){
            int[] q = l.get(i);
            int idx = q[0], tar = q[1];
            if(!map.containsKey(tar)){
                res[i] = -1;
                continue;
            }
            int d = map.get(tar)[idx];
            res[i] = d==Integer.MAX_VALUE ? -1 : d;
        }
        return Arrays.toString(res);
    }
    private static String optimizedBS(int n,int p, int[] cmp, List<int[]> l){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(cmp[i], x->new ArrayList<>()).add(i);
        }
        int[] res = new int[p];
        for(int i=0;i<p;i++){
            int[] q = l.get(i);
            int x = q[0], y = q[1];
            if(!map.containsKey(y)){
                res[i] = -1;
                continue;
            }
            List<Integer> t = map.get(y);
            res[i] = bS(t, q[0], q[1]);
        }
        return Arrays.toString(res);
    }
    private static int bS(List<Integer> l, int idx, int tar){
        int st=0, end = l.size()-1;
        int dist = Integer.MAX_VALUE;
        while(st<=end){
            int mid = (st+end)/2;
            int cmp = l.get(mid);
            dist = Math.min(dist, Math.abs(cmp-idx));
            if(cmp<tar) st = mid+1;
            else end = mid-1;
        }
        return dist;
    }
    private static String bruteForce(int n, int p, int[] cmp, List<int[]> l){
        int[] res = new int[p];
        for(int k=0;k<p;k++){
            int[] q = l.get(k);
            int idx = q[0], tar = q[1];
            boolean f = false;
            int dist = 0;
            int i=idx, j=idx;
            while(i>=0 || j<n){
                if(i>=0 && cmp[i]==tar){
                    f = true;
                    break;
                }
                if(j<n && cmp[j]==tar){
                    f = true;
                    break;
                }
                i--;
                j++;
                dist++;
            }
            res[k] = f?dist:-1;
        }
        return Arrays.toString(res);
    }
}
