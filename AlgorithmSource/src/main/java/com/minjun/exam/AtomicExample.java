package com.minjun.exam;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zmjkey on 2018/7/23.
 */
public class AtomicExample implements Runnable{
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String args[]){
        Thread t1 = new Thread(new AtomicExample());
        Thread t2 = new Thread(new AtomicExample());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        while(num.get() < 100){
            System.out.print(num.getAndIncrement() + " ");
        }

//        synchronized (AtomicExample.class){
//            for(int i = 0; i < 100; i++){
//                System.out.print(i + " ");
//            }
//        }
    }
}
