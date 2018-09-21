package com.taojian.interview;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-06 20:53
 * <p>
 * <p>
 * 时间限制：C/C++语言 2000MS；其他语言 4000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * <p>
 * 1、r-l+1=k;
 * <p>
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * <p>
 * 输出满足条件的区间个数。
 **/

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(countArea(nums, n, k, t));
    }

    public static int countArea(int[] nums, int n, int k, int t) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
        }
        if (TakeOutCount(map, t)) {
            count++;
        }

        for (int i = k; i < n; i++) {
            map.put(nums[i - k], map.get(nums[i - k]) - 1);
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
            if (TakeOutCount(map, t)) {
                count++;
            }
        }
        return count;

    }

    public static boolean TakeOutCount(HashMap<Integer, Integer> map, int t) {
        for (Integer key : map.keySet()) {
            if (map.get(key) >= t) {
                return true;
            }
        }
        return false;
    }

}

