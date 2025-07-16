package CompanyQuestions;

import Problems.java.ArrayUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CopartSolutions {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
//        p1();
//        p2();
//        p3();
//        p4();
//        p5();
//        p6();
//        p7();
//        p8();
//        p9();
//        p10();
//        p11();
//        p12();
//        p13();
//        p14();
//        p15();
        p16();
    }
    private  static void p16(){
        p6();
    }
    private static void p15(){
        p5();
    }
    private static void p14(){
        int[] nums = ArrayUtils.parseIntArray(sc.nextLine());
        int tar = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) map.put(nums[i], i);
        for(int i=0;i<nums.length;i++){
            int rem = Math.abs(nums[i]-tar);
            if(map.containsKey(rem) && nums[i]!=rem){
                System.out.println(i+" "+map.get(rem));
                return;
            }
        }
        System.out.println(Arrays.toString(new int[]{-1, -1}));
    }
    private static void p13(){
        String[] strs = sc.nextLine().split(" ");
        System.out.println(strs[strs.length-1].length());
    }
    private static void p12(){
        int n= sc.nextInt();
        for(int i=0;i<n;i++) {
            if(i==0 || i==n-1){
                for(int j=0;j<n;j++) System.out.print("*");
                System.out.println();
                continue;
            }
            for(int j=0;j<n;j++){
                if(j==0) System.out.print("* ");
                else if(j==n-1) System.out.print("*\n");
                else System.out.print("  ");
            }
        }
    }
    private static void p11(){
        int cy = 2025;
        while(!(isLeapYear(cy))) cy++;
        List<Integer> next20LeapYears = new ArrayList<>();
        for(int i=1;i<=20;i++){
            next20LeapYears.add(cy);
            cy+=4;
        }
        System.out.println(next20LeapYears);
    }
    private static boolean isLeapYear(int x){
        return x%4==0 && (x%100!=0 || x%400==0);
    }
    private static void p10(){
        String s = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsed = LocalDate.parse(s, dtf);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(parsed, currentDate);
        System.out.println(age.getYears());
    }
    private static void p9(){
        int[] nums = ArrayUtils.parseIntArray(sc.nextLine());
        // Given to use Bubble Sort Algorithm
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }
    private static void p8(){
        int n = sc.nextInt();
        int sum = 0;
        for(int i=3;i<n;i++){
            if(i%3==0) sum+=i;
            else if(i%5==0) sum+=i;
        }
        System.out.println(sum);
    }
    private static void p7(){
        int n = sc.nextInt();
        StringBuilder res = new StringBuilder();
        for(int i=1;i<=n;i++){
            res.append(i%2);
        }
        System.out.println(res);
    }
    private static void p6(){
        int n = sc.nextInt();
        int sum = 0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum += i;
            }
        }
        System.out.println(sum==n?"PREFECT NUMBER":"NOT PERFECT NUMBER");
    }
    private static void p5(){
        int n = sc.nextInt();
        System.out.println(pow(2.0, n));
    }

    private static double pow(double x, int n) {
        if(n==0) return 1;
        if(n<0) return 1/pow(x, -n);
        if(n%2==1) return x*pow(x, n-1);
        return pow(x*x, n/2);
    }

    private static void p4(){
        int[] nums = ArrayUtils.parseIntArray(sc.nextLine());
        int tar = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int x: nums) set.add(x);
        for(int x: nums){
            int rem = Math.abs(x-tar);
            if(set.contains(rem) && x!=rem){
                System.out.println(x+" "+rem);
                return;
            }
        }
        System.out.println(-1);
    }
    private static void p3(){
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
//        System.out.println(s2.indexOf(s1));
        for(int i=0;i<s2.length();){
            int j = 0, t = i;
            while(t<s2.length() && j<s1.length() && s2.charAt(t)==s1.charAt(j)){
                t++;
                j++;
            }
            if(j==s1.length()){
                System.out.println(i);
                return;
            }
            i = i==t?i+1:t;
        }
        System.out.println(-1);
    }
    private static void p2(){
        int n = sc.nextInt();
        int reversed = 0;
        int t = n;
        while(t>0){
            reversed = reversed*10 + (t%10);
            t /= 10;
        }
        System.out.println(n==reversed);
    }
    private static void p1(){
        String s= sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
//        System.out.println(map);
        map.keySet().stream()
                .filter(k->k!=' '&&map.get(k)>1)
                .forEach(k->System.out.println(k+": "+map.get(k)));
    }
}
