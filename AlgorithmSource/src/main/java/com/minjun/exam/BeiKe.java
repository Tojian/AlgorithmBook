package com.minjun.exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zmjkey on 2018/9/3.
 */
public class BeiKe {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            int b = in.nextInt();

            if(a == -1 || map.get(a) != null){
                map.put(b, a);
            }else {
                map.put(a, b);
            }
        }

        int m = in.nextInt();

        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();

            int c = a;

            while (map.get(c) != null && map.get(c) != b){
                c = map.get(c);
            }
            if(map.get(c) != null && map.get(c) == b){
                System.out.println(2);
                continue;
            }

            c = b;
            while (map.get(c) != null && map.get(c) != a){
                c = map.get(c);
            }
            if(map.get(c) != null && map.get(c) == a){
                System.out.println(1);
                continue;
            }

            System.out.println(0);
        }


    }
}
