package com.taojian.demo.singleton;

/**
 * 双重加锁机制适合多线程的情况
 *
 * com.offer.demo.singleton.Singleton_2@7bddc905
 * com.offer.demo.singleton.Singleton_2@7bddc905
 * com.offer.demo.singleton.Singleton_2@7bddc905
 */
public class Singleton_3_Test {
    public static void main(String[] args) {
        Thread thead1 = new Thread(new Runnable() {
            public void run() {
               Singleton_3 singleton_1 = Singleton_3.getSingleton_3();
                System.out.println(singleton_1);
            }
        });

        Thread thead2 = new Thread(new Runnable() {
            public void run() {
                Singleton_3 singleton_2 =Singleton_3.getSingleton_3();
                System.out.println(singleton_2);
            }
        });
        Thread thead3 = new Thread(new Runnable() {
            public void run() {
                Singleton_3 singleton_3 =Singleton_3.getSingleton_3();
                System.out.println(singleton_3);
            }
        });

        thead1.start();
        thead2.start();
        thead3.start();

    }
}
