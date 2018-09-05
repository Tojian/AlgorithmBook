package com.minjun.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/30.
 */


public class pdd3 {

    static void f(int a, int b){
        List shang = new ArrayList();  //商
        List yu = new ArrayList();  //余数
        List res = new ArrayList();  //结果
        int p = - 1;//循环节的起始位置
        while(true){

            shang.add(a/b);
            int x = a % b;
            if(x == 0) break;

            p = yu.indexOf(x);

            if(p >= 0) break;
            else
                yu.add(x);

            a = x*10;
        }
        //System.out.println(shang.toString());
        //System.out.println("---------------");
        //System.out.println(shang.size());
        //System.out.print(shang.get(0)+".");


        for(int i = 1; i < shang.size();i++){

            //if(i == p + 1)System.out.print("[");
            int len = shang.size() - (p+1);
            res.add(p+"");
            res.add(len+"");
            //System.out.print(shang.get(i));
        }
        //if(p >= 0)
        //System.out.println("]");

        System.out.println(res.get(0)+" "+res.get(1));

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        f(a, b);

    }

}