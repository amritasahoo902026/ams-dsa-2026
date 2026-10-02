package com.ds.collectionsJava.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(3);

        Thread producer=new Thread(()->{

            try{
                for(int i=0;i<10;i++){

                    blockingQueue.put(i);
                    System.out.println("Produced for value : "+i);
                }
            }catch (InterruptedException ex){

                Thread.currentThread().interrupt();
            }
        });

        Thread consumer=new Thread(()->{

            try{
                for(int j=0;j<10;j++){

                 int value =   blockingQueue.take();
                    System.out.println("Consumed "+value);
                }
            }catch (InterruptedException ex){

                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
