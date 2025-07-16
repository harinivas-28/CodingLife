package Practise.java;

public class MyArray {
    private int[] arr;
    private int size;
    public MyArray(int cap){
        arr = new int[cap];
        size = 0;
    }
    public int get(int ind){
        if(ind<0 || ind>=arr.length) throw new IndexOutOfBoundsException();
        return arr[ind];
    }
    public void add(int val){
        if(size==arr.length){
            System.out.println("Array is Full!");
            return;
        }
        arr[size++] = val;
    }
    public int size(){
        return size;
    }
    public void print(){
        for(int x=0;x<size;x++) System.out.print(arr[x]+" ");
        System.out.println();
    }
}
