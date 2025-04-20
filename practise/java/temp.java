package practise.java;
public class temp {
    public static void main(String[] args) {
        int n = 5;
        int num = 1;
        for(int i=n;i>0;i--){
            int temp = n-i;
            for(int j=0;j<num;j++){
                System.out.print((num+temp)+" ");
            }
            num++;
            System.out.println();
        }
    }
}
