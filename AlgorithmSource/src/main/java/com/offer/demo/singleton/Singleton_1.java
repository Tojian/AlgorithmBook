/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.offer.demo.singleton;

public class Singleton_1 {

    public static void main(String[] args) {
        Singleton_1 singleton_11 = Singleton_1.getSingleton_1();
        Singleton_1 singleton_12 = Singleton_1.getSingleton_1();
        System.out.println(singleton_11);
        System.out.println(singleton_12);
    }
    private  static Singleton_1 singleton_1 = null;

    private Singleton_1(){}

    public static Singleton_1 getSingleton_1(){
        if (singleton_1 == null){
            singleton_1 = new Singleton_1();
        }
        return  singleton_1;
    }
}
