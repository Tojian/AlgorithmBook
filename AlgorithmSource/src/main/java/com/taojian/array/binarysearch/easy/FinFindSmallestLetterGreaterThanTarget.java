package com.taojian.array.binarysearch.easy;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-29 11:01
 * <p>
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 **/
public class FinFindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        // 转化成int
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] totalChar = str.toCharArray();
        for (int i = 0; i < totalChar.length; i++) {
            hashmap.put(totalChar[i], i);
        }
        int[] covertLetters = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            covertLetters[i] = hashmap.get(letters[i]);
        }
        int covertTarget = hashmap.get(target);
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            if (covertLetters[mid] == covertTarget) {
                return getKeyList(hashmap, mid).get(0);
            } else if (covertLetters[mid] > covertTarget && covertLetters[mid] < covertTarget + 1) {
                return getKeyList(hashmap, mid + 1).get(0);
            } else if (covertLetters[mid] > covertTarget && covertLetters[mid] > covertTarget + 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (covertTarget > covertLetters[letters.length - 1] || covertTarget > covertLetters[0]) {
            return letters[0];
        }
        return ' ';
    }

    public static List<Character> getKeyList(HashMap<Character, Integer> map, int value) {
        List<Character> keyList = new ArrayList<Character>();
        for (Character getKey : map.keySet()) {
            if (map.get(getKey) == value) {
                keyList.add(getKey);
            }
        }
        return keyList;
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'a'));

    }

    public char nextGreatestLetter1(char[] a, char x) {
        int n = a.length;

        if (x >= a[n - 1]) {
            x = a[0];
        } else {
            x++;
        }

        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x) {
                return a[mid];
            }
            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return a[hi];
    }
}
