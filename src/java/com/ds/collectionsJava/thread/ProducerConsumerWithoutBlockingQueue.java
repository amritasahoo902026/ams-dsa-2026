package com.ds.collectionsJava.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWithoutBlockingQueue {

    private static final Queue<Integer> queue=new LinkedList<>();

    private static final int CAPACITY=3;

    static class Producer implements Runnable{


        @Override
        public void run(){

            try{

                for(int i=0;i<10;i++){

                    synchronized (queue){

                        while (queue.size()==CAPACITY){

                            queue.wait();
                        }
                        queue.add(i);
                        System.out.println("Produced : "+ i);
                        queue.notifyAll();
                    }
                }
            }catch (InterruptedException ex){

                Thread.currentThread().interrupt();
            }
        }
    }
    static  class Consumer implements Runnable{

        @Override
        public void run(){

            try{
                for(int j=0;j<=10;j++){

                    synchronized (queue){

                        while (queue.isEmpty()){

                            queue.wait();
                        }
                        int value= queue.poll();
                        System.out.println("Consumed :"+value);
                        queue.notifyAll();
                    }
                }
            }catch (InterruptedException ex){

                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

}
