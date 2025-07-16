package practise.java;

public class MaxHeap {
    private final int[] heap;
    private final int capacity;
    private int size;
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        this.size = 0;
    }
    private void swap(int a, int b){
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }
    private int parent(int i){ return (i-1)/2; }
    private int leftChild(int i){ return 2*i+1; }
    private int rightChild(int i){ return 2*i+2; }
    public void insert(int x){
        if(size==capacity){
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = x;
        int curr = size;
        size++;
        while(curr>0 && heap[curr]>heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }
    public int extractMax(){
        if(size==0){
            throw new IllegalStateException("Heap is Empty");
        }
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return max;
    }
    private void heapify(int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if(left<size && heap[left]>heap[largest]){
            largest = left;
        }
        if(right<size && heap[right]>heap[largest]){
            largest = right;
        }
        if(largest!=i){
            swap(i, largest);
            heapify(largest);
        }
    }
    public int size(){ return size; }
    public int peek(){
        if(size==0){
            throw new IllegalStateException("Heap is Empty");
        }
        return heap[0];
    }
    public boolean isEmpty(){ return size==0; }
    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.printHeap();
        System.out.println("Max: "+maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println("Peek: "+maxHeap.peek());
    }
}
