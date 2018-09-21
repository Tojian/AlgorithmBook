package com.taojian.offer;

import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-08 09:29
 **/
public class GetFirstK_38 {

    public int GetNumberOfK(int [] array , int k) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for (int i = 0; i < array.length; i ++){
            if (hashmap.containsKey(array[i])){
                hashmap.put(array[i],hashmap.get(array[i])+1);
            }else hashmap.put(array[i],1);
        }
        return hashmap.get(k);
    }
}
