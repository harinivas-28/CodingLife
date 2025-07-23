package Practise.java;

public class basicThreads extends Thread {
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Child Thread: "+i);
        }
    }
    public static void main(String[] args){
        basicThreads t  = new basicThreads();
        t.start();
        for(int i=0;i<5;i++){
            System.out.println("Main Thread: "+i);
        }
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread using Runnable is running.");
        }
    }
}
