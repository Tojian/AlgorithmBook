package com.taojian.interview.pinduoduo;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-30 20:34
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        function(n, m);

    }

    public static void function(int a, int b) {
        List t1 = new ArrayList();
        List t2 = new ArrayList();

        int p = -1;
        while (true) {
            t1.add(a / b);
            int x = a % b;
            if (x == 0) {
                break;
            }
            p = t2.indexOf(x);
            if (p >= 0) {
                break;
            } else {
                t2.add(x);
            }

            a = x * 10;
        }

        for (int i = 1; i < t1.size(); i++) {
            if (i == p + 1) {
                System.out.println(p + " " + (t1.size() - p - 1));
                break;
            }
        }
        if (p == -1) {
            System.out.println((t1.size() - 1) + " " + 0);
        }

    }
}
