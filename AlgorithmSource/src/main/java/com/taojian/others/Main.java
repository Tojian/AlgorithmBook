package com.taojian.others;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-04 20:18
 **/

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_cap = Integer.valueOf(in.nextLine());
        Main ma = new Main(max_cap);
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] strs = line.split(" ");
            if(line.startsWith("p")){
                ma.put(Integer.valueOf(strs[1]), Integer.valueOf(strs[2]));
            } else {
                System.out.println(ma.get(Integer.valueOf(strs[1])));
            }
        }
    }
    int capacity;
    Map<Integer,Node> map = new HashMap<Integer,Node>();
    Node head = null;
    Node end = null;

    public Main(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            setHead(temp);
            return temp.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key,value);
            if(map.size()>=capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else
                setHead(created);
            map.put(key,created);
        }
    }

    public void remove(Node n) {
        if(n.pre!=null)
            n.pre.next = n.next;
        else
            head = n.next;

        if(n.next!=null)
            n.next.pre = n.pre;
        else
            end = n.pre;

    }

    public void setHead(Node n) {

        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre=n;
        head = n;

        if(end == null)
            end = head;
    }
}
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

