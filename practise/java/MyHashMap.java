package practise.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap<K, V> {
    class Node {
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private int n; // nodes
    private int N; // buckets
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i=0;i<4;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }
    @SuppressWarnings("unchecked")
    private void rehash(){
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[N*2];
        N*=2;
        for(int i=0;i<N*2;i++){
            buckets[i] = new LinkedList<>();
        }
        for(int i=0;i<oldBuckets.length;i++){
            LinkedList<Node> ll = oldBuckets[i];
            for(int j=0;j<ll.size();j++){
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }
    public int hashFunction(K key){
        int bi = key.hashCode();
        return Math.abs(bi)%N;
    }
    public int searchInLL(K key, int bi){
        LinkedList<Node> ll = buckets[bi];
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }
    public void put(K key, V value){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        if(di==-1){
            buckets[bi].add(new Node(key, value));
            n++;
        } else {
            Node node = buckets[bi].get(di);
            node.value = value;
        }
        double lambda = (double)n/N;
        if(lambda>2.0){
            rehash();
        }
    }
    public boolean containsKey(K key){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        if(di==-1){
            return false;
        } 
        return true;
    }
    public V get(K key){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        if(di==-1){
            return null;
        } else {
            Node node = buckets[bi].get(di);
            return node.value;
        }
    }
    public V remove(K key){
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        if(di==-1){
            return null;
        } else {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }
    }
    public boolean isEmpty(){
        return n==0;
    }
    public ArrayList<K> keySet(){
        ArrayList<K> res = new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            LinkedList<Node> ll = buckets[i];
            for(int j=0;j<ll.size();j++){
                Node node = ll.get(j);
                res.add(node.key);
            }
        }
        return res;
    }
    public ArrayList<V> values(){
        ArrayList<V> res = new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            LinkedList<Node> ll = buckets[i];
            for(int j=0;j<ll.size();j++){
                Node node = ll.get(j);
                res.add(node.value);
            }
        }
        return res;
    }
}
