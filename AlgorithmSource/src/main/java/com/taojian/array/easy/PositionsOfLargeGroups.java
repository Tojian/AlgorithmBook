package com.taojian.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 18:04
 * <p>
 * <p>
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large
 * group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 * 对于一个给定的字符串，找出其中连续出现次数超过三次的子字符串，记录这个子字符串的开始和结束的索引位置，返回这样一个索引对序列
 **/
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {

        int count = 1;
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j < S.length()) {
            if (S.charAt(i) == S.charAt(j)) {
                count++;
                j++;
            } else {
                if (count >= 3) {
                    result.add(Arrays.asList(i, j - 1));
                }
                i = j;
                j = i + 1;
                count = 1;
            }
        }
        if (count >= 3) {
            result.add(Arrays.asList(i, j - 1));
        }
        return result;
    }
}
