package com.taojian.demo.singleton;

public class Singleton_3 {

    public static void main(String[] args) {

        Singleton_3 singleton_1 = Singleton_3.getSingleton_3();
        Singleton_3 singleton_2 = Singleton_3.getSingleton_3();
        System.out.println(singleton_1);
        System.out.println(singleton_2);
    }

    private volatile static Singleton_3 singleton_3;

    private Singleton_3(){}

    public static Singleton_3 getSingleton_3(){

        if (singleton_3 == null){
            synchronized(Singleton_3.class){
                if (singleton_3 == null){
                    singleton_3 = new Singleton_3();
                }
            }
        }
        return  singleton_3;
    }
}
