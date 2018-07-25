package com.taojian.demo.singleton;

/**
 * 饿汉式适合多线程的情况
 *
 * com.offer.demo.singleton.Singleton_2@7bddc905
 * com.offer.demo.singleton.Singleton_2@7bddc905
 * com.offer.demo.singleton.Singleton_2@7bddc905
 */
public class Singleton_2_Test {
    public static void main(String[] args) {
        Thread thead1 = new Thread(new Runnable() {
            public void run() {
               Singleton_2 singleton_1 = Singleton_2.getSingleton_2();
                System.out.println(singleton_1);
            }
        });

        Thread thead2 = new Thread(new Runnable() {
            public void run() {
                Singleton_2 singleton_2 =Singleton_2.getSingleton_2();
                System.out.println(singleton_2);
            }
        });
        Thread thead3 = new Thread(new Runnable() {
            public void run() {
                Singleton_2 singleton_3 =Singleton_2.getSingleton_2();
                System.out.println(singleton_3);
            }
        });

        thead1.start();
        thead2.start();
        thead3.start();

    }
}
