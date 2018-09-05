package com.taojian.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-05 16:37
 *
 * 第一个只出现一次的字符
 **/
public class FirstNotRepeatingChar_35 {

    public static void main(String[] args) {
        FirstNotRepeatingChar_35 firstNotRepeatingChar_35 = new FirstNotRepeatingChar_35();
        System.out.println(firstNotRepeatingChar_35.firstNotRepeating("abaccdeff"));
    }

    public char firstNotRepeating(String str){

        HashMap<Character,Integer> hashMap = new HashMap<>();

        char []chars = str.toCharArray();

        for (int i = 0 ;i < chars.length ;i ++){
            if (hashMap.containsKey(chars[i]))
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            else
            hashMap.put(chars[i],1);
        }

        Iterator<Map.Entry<Character,Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 'n';
    }

}
