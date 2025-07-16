package practise.java;
public class MinHeap {
    private final int[] heap;
    private int size;
    private final int capacity;
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    private int parent(int i){ return (i-1)/2;}
    private int leftChild(int i){ return 2*i+1;}
    private int rightChild(int i){ return 2*i+2;}
    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int val){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        heap[size] = val;
        int curr = size;
        size++;
        while(curr>0 && heap[curr]<heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }
    public int extractMin(){
        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return min;
    }
    private void heapify(int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if(left<size && heap[left]<heap[smallest]){
            smallest = left;
        }
        if(right<size && heap[right]<heap[smallest]){
            smallest = right;
        }
        if(smallest!=i){
            swap(i, smallest);
            heapify(smallest);
        }
    }
    public int peek(){
        if(size==0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.printHeap();
        System.out.println("Min: "+minHeap.extractMin());
        minHeap.printHeap();
        System.out.println("Peek: "+minHeap.peek());
    }
}