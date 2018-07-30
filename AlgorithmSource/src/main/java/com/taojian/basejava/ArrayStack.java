package com.taojian.basejava;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 14:36
 * <p>
 * 栈是限定仅允许在表的同一端（通常为“表尾”）进行插入或删除操作的线性表。
 * <p>
 * 允许插入和删除的一端称为栈顶(top)，另一端称为栈底(base)
 * 特点：后进先出 (LIFO)或，先进后出（FILO）
 **/
public class ArrayStack<E> {

    private ArrayList<E> list = new ArrayList<E>();//用来保存数据线性表<br>
    private int size;//表示当前栈元素个数

    /**
     * 入栈操作
     *
     * @param e
     */
    public void push(E e) {
        list.add(e);
        size++;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public E pop() {
        E e = list.get(size - 1);
        size--;
        return e;

    }
}