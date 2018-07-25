package com.taojian.demo.singleton;

/**
 * Singleton 这种方式之适合单线程的状态
 * com.offer.demo.singleton.Singleton_1@5c25cea
 * com.offer.demo.singleton.Singleton_1@3c13f478
 * com.offer.demo.singleton.Singleton_1@3c13f478
 */
public class Singleton_1_Test {
    public static void main(String[] args) {
        Thread thead1 = new Thread(new Runnable() {
            public void run() {
                Singleton_1 singleton_1 =Singleton_1.getSingleton_1();
                System.out.println(singleton_1);
            }
        });

        Thread thead2 = new Thread(new Runnable() {
            public void run() {
                Singleton_1 singleton_2 =Singleton_1.getSingleton_1();
                System.out.println(singleton_2);
            }
        });
        Thread thead3 = new Thread(new Runnable() {
            public void run() {
                Singleton_1 singleton_3 =Singleton_1.getSingleton_1();
                System.out.println(singleton_3);
            }
        });

        thead1.start();
        thead2.start();
        thead3.start();

    }
}
