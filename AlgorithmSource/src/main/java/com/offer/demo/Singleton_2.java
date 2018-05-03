/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.offer.demo;

/**
 *  单例模式
 */

public class Singleton_2 {

    public static void main(String[] args) {

        Singleton_2 singleton_1 = Singleton_2.getSingleton_2();
        Singleton_2 singleton_12 = Singleton_2.getSingleton_2();
        System.out.println(singleton_1);
        System.out.println(singleton_12);
    }

    private  static Singleton_2 singleton_2 = new Singleton_2();

    private Singleton_2(){}

    public static Singleton_2 getSingleton_2(){
        return singleton_2;
    }
}
