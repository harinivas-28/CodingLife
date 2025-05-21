package Coding.java;
import java.util.*;
/*
Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
The land is divided into rectangular plots, using fences. They have kept some
H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
where hfence[i] is the distance from the top of the land to the i-th horizontal
fence and, vfence[j] is the distance from the top of the land to the j-th
vertical fence. Each 1*1 cell is one acre plot.

Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
Your task is to help Mr.RGV to find the biggest plot vailable after the fences
are setup in the venture.
NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

Input Format:
-------------
Line-1: 4 space separated integers, L,W,H and V
Line-2: H space separated integers, hfence[] in the range [0, L]
Line-3: V space sepaarted integers, vfence[] in the range [0, W]

Output Format:
--------------
Print an integer result, the area of biggest plot.


Sample Input-1:
---------------
5 6 2 2
2 3
2 5

Sample Output-1:
----------------
6


Sample Input-2:
---------------
5 6 1 1
3
4

Sample Output-2:
----------------
12
 */
public class Day47P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt(), w=sc.nextInt(), h=sc.nextInt(), v=sc.nextInt();
        int[] hf = new int[h+2];
        hf[0]=0; hf[h+1]=l;
        for(int i=1;i<=h;i++) hf[i]=sc.nextInt();
        int[] vf = new int[v+2];
        vf[0]=0; vf[v+1]=w;
        for(int i=1;i<=v;i++) vf[i]=sc.nextInt();
        final int MOD = (int)(1e9+7);
        Arrays.sort(hf);
        Arrays.sort(vf);
        int maxH = 0, maxW=0;
        for(int i=1;i<h+2;i++){
            maxH = Math.max(maxH, hf[i]-hf[i-1]);
        }
        for(int i=1;i<v+2;i++){
            maxW = Math.max(maxW, vf[i]-vf[i-1]);
        }
        System.out.println((maxH*maxW)%MOD);
    }
}
