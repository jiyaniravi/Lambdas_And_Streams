package com.af;

import java.util.stream.IntStream;

public class ThreadWithStreams {
    public static void main(String[] args) {

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i++){
                    System.out.println(Thread.currentThread().getId()+" : "+i);
                }
            }
        };*/

        /*Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getId() + " : " + i);
            }
        };*/

        Runnable runnable = () -> {
            IntStream.range(0,1000)
                    .forEach( i -> System.out.println(Thread.currentThread().getId() + " : " + i));
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
