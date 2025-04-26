package practise.java;

public class MyArrayList {
    private int[] arr;
    private int size;
    public MyArrayList(){
        arr = new int[2];
        size = 0;
    }
    public int get(int ind){
        if(ind<0 || ind>=arr.length) throw new IndexOutOfBoundsException();
        return arr[ind];
    }
    public void set(int ind, int val){
        if(ind<0 || ind>=size) throw new IndexOutOfBoundsException();
        arr[ind] = val;
    }
    public void remove(int ind){
        if(ind<0 || ind>=size) throw new IndexOutOfBoundsException();
        for(int i=ind;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
    }
    public void add(int val){
        if(size==arr.length){
            resize();
        }
        arr[size++] = val;
    }
    private void resize(){
        int[] newArr = new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public int size(){
        return size;
    }
    public void print(){
        for(int x=0;x<size;x++) System.out.print(arr[x]+" ");
        System.out.println();
    }
}

