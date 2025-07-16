package Practise.java;

public class MyHashSet<E> {
    private static final Object PRESENT = new Object();
    private MyHashMap<E, Object> map;
    public MyHashSet() {
        map = new MyHashMap<>();
    }
    public void add(E ele){
        map.put(ele, PRESENT);
    }
    public void remove(E ele){
        map.remove(ele);
    }
    public boolean contains(E ele){
        return map.containsKey(ele);
    }
    public int size(){
        return map.size();
    }
}
