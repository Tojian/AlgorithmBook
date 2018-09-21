package com.taojian.interview;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-09 10:02
 **/
public class Testtt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][3];

        for (int i = 0; i < n; i++) {
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
            data[i][2] = in.nextInt();
        }
        System.out.println(getCount(data, n));
    }

    public static int getCount(int[][] data, int n) {
        int count = 0;
        boolean[] flag = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][0] < data[j][0] && data[i][1] < data[j][1] && data[i][2] < data[j][2]) {
                    flag[i] = true;
                    continue;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                count++;
            }
        }

        return count;
    }

    public static int solution(int[] a, int[] b, int[] c) {
        if (a.length == 0 || b.length == 0 || c.length == 0) {
            return 0;
        }
        List<ArrayList<Integer>> lists = getlocation(a);
        if (lists == null) {
            return 0;
        }
        int count = 0;
        for (ArrayList<Integer> arrayList : lists) {
            if (b[arrayList.get(1)] > b[arrayList.get(0)] && c[arrayList.get(1)] > c[arrayList.get(0)]) {
                count++;
            }
        }
        return count;
    }

    //ai , bi , ci
    public static List<ArrayList<Integer>> getlocation(int[] a) {
        List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                if (a[j] > a[i]) {
                    arrayList.add(i);
                    arrayList.add(j);
                    lists.add(arrayList);
                }

            }

        }
        return lists;
    }

}
