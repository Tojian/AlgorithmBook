package com.taojian.interview;

import java.awt.List;
import java.util.*;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-04 19:54
 **/

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int A = sc.nextInt();
            int cnt = 0;
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                int in = sc.nextInt();
                int out = sc.nextInt();
                if (A >= in && A <= out) {
                    res.add(id);
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println("null");
                return;
            }
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
        sc.close();
    }
}


