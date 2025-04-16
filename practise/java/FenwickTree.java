package practise.java;

public class FenwickTree {
    private int[] bit; // Binary Indexed Tree
    private int n;
    private int[] arr;
    // Public methods
    public void constructTree(int[] arr) { // O(N)
        n = arr.length;
        this.arr = arr;
        // int ht = (int)(Math.log(n + 1) / Math.log(2));
        // int sz = (int)Math.pow(2, ht)-1;
        // bit = new int[sz]; 
        // OR 
        bit = new int[4*n];
        constructTreeHelper(0, arr, 0, n - 1);
    }
    public int query(int low, int high){ // O(logN)
        return queryHelper(0, 0, n - 1, low, high);
    }
    public void update(int index, int val){ // O(logN)
        int diff = val - arr[index];
        arr[index] = val;
        updateHelper(0, 0, n-1, index, diff);
    }

    // Private Methods
    private void updateHelper(int idx, int start, int end, int index, int diff){
        if(start>index || end<index) return;
        bit[idx] += diff;
        if(start!=end){
            int mid = start+(end-start)/2;
            updateHelper(2*idx+1, start, mid, index, diff);
            updateHelper(2*idx+2, mid+1, end, index, diff);
        }
    }
    private int queryHelper(int idx, int start, int end, int low, int high){
        if (low <= start && high >= end) return bit[idx];
        if (end < low || start > high) return 0;
        int mid = start + (end - start) / 2;
        return queryHelper(2 * idx + 1, start, mid, low, high) + 
               queryHelper(2 * idx + 2, mid + 1, end, low, high);
    }

    private int constructTreeHelper(int idx, int[] arr, int low, int high) {
        if (low > high) return 0;
        if (low == high) {
            bit[idx] = arr[low];
            return bit[idx];
        }
        int mid = low + (high - low) / 2;  
        bit[idx] = constructTreeHelper(2 * idx + 1, arr, low, mid) + 
                   constructTreeHelper(2 * idx + 2, arr, mid + 1, high);
        return bit[idx];
    }
}