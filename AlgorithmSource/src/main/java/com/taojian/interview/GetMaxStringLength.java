package com.taojian.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-08 15:54
 **/
public class GetMaxStringLength {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getMaxStringLength(str));
    }

    public static long getMaxStringLength(String str) {

        if (str.length() == 0 || str.length() == 1) {
            return 0;
        }

        HashMap<Character, Long> hashmap = new HashMap<Character, Long>();

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (hashmap.containsKey(chars[i])) {
                hashmap.put(chars[i], hashmap.get(chars[i]) + 1L);
            } else {
                hashmap.put(chars[i], 1L);
            }
        }

        if (hashmap.containsKey('w') && hashmap.containsKey('b')) {

            long count = hashmap.get('b') > hashmap.get('w') ? 2 * hashmap.get('w') : 2 * hashmap.get('b');
            if (str.length() > 2) {
                return count + 1;
            } else {
                return count;
            }
        }

        return 0;
    }
}
