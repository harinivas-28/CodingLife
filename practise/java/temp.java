package practise.java;
import java.util.*;

public class temp {
    private static final Scanner sc = new Scanner(System.in);
    private static void solve(){
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 3);
        map.put(3, 1);
        map.put(1, 1);
        map.put(2, 2);
        map.put(5, 1);
        for(int i=1;i<=n;i++){
            int t = sc.nextInt();
            if(map.containsKey(t)){
                map.put(t, map.get(t)-1);
                if(map.get(t)==0){
                    map.remove(t);
                }
            }
            if(map.size()==0){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    public static void main(String[] args){
        int t = sc.nextInt();
        while(t-->0){
            solve();
        }
    }
}