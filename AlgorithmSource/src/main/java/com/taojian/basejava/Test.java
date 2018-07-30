package com.taojian.basejava;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 14:49
 **/
public class Test {
    public static void main(String[] args) {
        //测试自己实现的ArrayList类和Linkedlist类添加30000个数据所需要的时间
        ArrayList<String> al = new ArrayList<String>();
        LinkedList<String> ll = new LinkedList<String>();
        Long aBeginTime = System.currentTimeMillis();//记录BeginTime
        for (int i = 0; i < 30000; i++) {
            al.add("now" + i);
        }
        Long aEndTime = System.currentTimeMillis();//记录EndTime
        System.out.println("arrylist  add time--->" + (aEndTime - aBeginTime));
        Long lBeginTime = System.currentTimeMillis();//记录BeginTime
        for (int i = 0; i < 30000; i++) {
            ll.add("now" + i);
        }
        Long lEndTime = System.currentTimeMillis();//记录EndTime
        System.out.println("linkedList add time---->" + (lEndTime - lBeginTime));

        //测试JDK提供的ArrayList类和LinkedList类添加30000个数据所需要的世界
        java.util.ArrayList<String> sal = new java.util.ArrayList<String>();
        java.util.LinkedList<String> sll = new java.util.LinkedList<String>();
        Long saBeginTime = System.currentTimeMillis();//记录BeginTime
        for (int i = 0; i < 30000; i++) {
            sal.add("now" + i);
        }
        Long saEndTime = System.currentTimeMillis();//记录EndTime
        System.out.println("JDK arrylist  add time--->" + (saEndTime - saBeginTime));
        Long slBeginTime = System.currentTimeMillis();//记录BeginTime
        for (int i = 0; i < 30000; i++) {
            sll.add("now" + i);
        }
        Long slEndTime = System.currentTimeMillis();//记录EndTime
        System.out.println("JDK linkedList add time---->" + (slEndTime - slBeginTime));

        DoubleLinkList<String> dll = new DoubleLinkList<String>();
        //在链表尾添加元素
        dll.add("haha");
        dll.add("hehe");
        dll.add("xixi");
        System.out.println("原有双链表中的元素： ");
        System.out.println(ll);
        //在链表头插入元素
        dll.addHeader("hiahia");
        System.out.println("双链表头结点插入后链表中的元素： ");
        System.out.println(ll);
        //在循环链表中位置2处插入元素
        dll.insert("heihei", 2);
        System.out.println("双链表2处插入元素后链表中的元素： ");
        System.out.println(ll);
        //删除循环链表中位置2的元素
        dll.delete(2);
        System.out.println("双链表2处删除元素后链表中的元素： ");
        System.out.println(ll);
        //删除循环链表中尾结点
        dll.remove();
        System.out.println("双链表末尾处删除元素后链表中的元素： ");
        System.out.println(ll);
        System.out.println("双链表中元素haha的位置: " + dll.local("haha"));
        System.out.println("双链表中位置1的元素: " + dll.getElement(1));
        System.out.println("双链表的长度为: " + dll.getSize());
    }

}



