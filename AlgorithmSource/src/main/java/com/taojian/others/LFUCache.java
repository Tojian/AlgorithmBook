package com.taojian.others;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-26 15:07
 * <p>
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be
 * evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LFUCache cache = new LFUCache( 2 /* capacity
 * <p>
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * 实现 LFU 缓存算法, 设计一个类 LFUCache，实现下面三个函数
 *     + 构造函数: 传入 Cache 内最多能存储的 key 的数量
 *     + get(key)：如果 Cache 中存在该 key，则返回对应的 value 值，否则，返回-1。
 *     + set(key,value)：如果 Cache 中存在该 key，则重置 value 值；如果不存在该 key，则将该 key 插入到到 Cache 中，若插入后会导致 Cache 中存储的 key
 *     个数超过最大容量，则在插入前淘汰访问次数最少的数据。
 *
 * 注：
 * 所有 key 和 value 都是 int 类型。
 * 访问次数：每次get/set一个存在的key都算作对该key的一次访问；当某个key被淘汰的时候，访问次数清零。
 **/

public class LFUCache {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_cap = Integer.valueOf(in.nextLine());
        LFUCache ma = new LFUCache(max_cap);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] strs = line.split(" ");
            if (line.startsWith("p")) {
                ma.put(Integer.valueOf(strs[1]), Integer.valueOf(strs[2]));
            } else {
                System.out.println(ma.get(Integer.valueOf(strs[1])));
            }
        }

    }
    class ValCount{
        int val;
        int count;
    }

    HashMap<Integer, ValCount> vals;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int min =-1 ;
    int capacity;

    public LFUCache(int capacity) {
        vals = new HashMap<Integer, ValCount>();
        lists = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.capacity = capacity;
    }

    private void updateStatus(int key)
    {
        ValCount currentCount = vals.get(key);
        int count = currentCount.count;
        currentCount.count = count+1;
        vals.put(key, currentCount);

        if(lists.containsKey(count) && lists.get(count).contains(key))
            lists.get(count).remove(key);
        LinkedHashSet<Integer> current = lists.getOrDefault(count+1, new LinkedHashSet());
        current.add(key);
        lists.put(count+1, current);
        if(min == count && lists.get(count).size() ==0) min = count+1;
    }

    public int get(int key) {

        if(vals.containsKey(key))
        {
            updateStatus(key);
            return vals.get(key).val;
        }else
            return -1;

    }

    private void makeSpace()
    {
        int key = lists.get(min).iterator().next();
        lists.get(min).remove(key);
        vals.remove(key);
    }

    public void put(int key, int value) {
        if(capacity > 0)
        {
            ValCount node;
            if(!(vals.containsKey(key)))
            {
                node = new ValCount();
                node.count =0;
                if(vals.size() >= capacity) makeSpace();
                min =1;
            }else
                node = vals.get(key);

            node.val = value;
            vals.put(key,node);
            updateStatus(key);
        }
    }



}
