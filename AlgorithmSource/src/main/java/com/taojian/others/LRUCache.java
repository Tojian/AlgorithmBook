package com.taojian.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-05 14:31
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* capacity
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * <p>
 * 最近用到的数据被重用的概率比较早用到的大的多”，是一种更加高效的cache类型。
 * <p>
 * 设计一个简单版的最近使用缓存模型。缓存空间有容量限制，时间复杂度要求是O(1)。
 * <p>
 * 其中“最近使用”是指最近被访问过(被cache.get调用过）。
 * <p>
 * 4、解题思路
 * 以上对cache的操作有：添加(put)、查找(get)、替换(put)，因有容量限制，还需有删除，每次当容量满时，将最久未使用的节点删除。
 * <p>
 * 为快速添加和删除，我们可以用双向链表来设计cache，链表中从头到尾的数据顺序依次是，(最近访问)->...(最旧访问)：
 * <p>
 * 1）添加节点：新节点插入到表头即可，时间复杂度O(1)；
 * <p>
 * 2）查找节点：每次节点被查询到时，将节点移动到链表头部，时间复杂度O(n)
 * <p>
 * 3)  替换节点：查找到后替换(更新节点value)，将节点移动到链表头部；
 * <p>
 * 可见在查找节点时，因对链表需遍历，时间复杂度O(n)，为达到O(1)，可以考虑数据结构中加入哈希(hash)。
 * <p>
 * =>我们需要用两种数据结构来解题：双向链表、哈希表
 **/
public class LRUCache {

    class Node {
        Node next;
        Node prev;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int size;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            bringToBackOfList(n);
            return n.val;
        }
        return -1;
    }

    private void bringToBackOfList(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        insertInBack(n);
    }

    private void insertInBack(Node n) {
        tail.prev.next = n;
        n.prev = tail.prev;
        tail.prev = n;
        n.next = tail;
    }

    private Node removeFromFront() {
        Node evict = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        return evict;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            bringToBackOfList(n);
            n.val = value;
        } else {
            if (size == capacity) {
                Node evict = removeFromFront();
                map.remove(evict.key);
                size--;
            }
            Node n = new Node(key, value);
            insertInBack(n);
            map.put(key, n);
            size++;
        }
    }
}
