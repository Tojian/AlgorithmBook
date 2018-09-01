package com.taojian.interview.pinduoduo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-30 19:25
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = Integer.valueOf(input.split(" ")[0]);
        int k = Integer.valueOf(input.split(" ")[1]);
        String[] strings = new String[n];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.nextLine().trim();
        }
        System.out.println(getMinString(strings, n, k));

    }

    public static String getMinString(String[] strings, int N, int K) {

        if (strings.length <= 1) {
            return "-";
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] result = new char[K];
        int temp = K - 1;
        for (int i = 0; i < letters.length(); i++) {
            hashMap.put(letters.charAt(i), i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                char s = strings[j].toCharArray()[i];
                int m = hashMap.get(s);
                if (min > hashMap.get(strings[j].toCharArray()[i])) {
                    min = hashMap.get(strings[j].toCharArray()[i]);
                    result[temp] = strings[j].toCharArray()[i];
                }
            }
            min = Integer.MAX_VALUE;
            temp--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }
        for (int i = 0; i < strings.length; i++) {
            if (stringBuilder.toString().equals(strings[i])) {
                return "-";
            }
        }
        return stringBuilder.toString();
    }
}
