package com.taojian.basejava;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 14:32
 * <p>
 * 思路：1.链表采用链式存储结构，在内部只需要将一个一个结点链接起来。（每个结点中有关于此结点下一个结点的引用）
 * <p>
 * 链表操作优点：1.因为每个结点记录下个结点的引用，则在进行插入和删除操作时，只需要改变对应下标下结点的引用即可
 * <p>
 * 缺点：1.要得到某个下标的数据，不能通过下标直接得到，需要遍历整个链表。
 **/
public class LinkedList<E> {

    private Node<E> header = null;// 头结点
    int size = 0;// 表示数组大小的指标

    public LinkedList() {
        this.header = new Node<E>();
    }

    public boolean add(E e) {

        if (size == 0) {
            header.e = e;
        } else {
            // 根据需要添加的内容，封装为结点
            Node<E> newNode = new Node<E>(e);
            Node<E> last = getNode(size - 1);
            //在表尾添加元素
            last.addNext(newNode);
            //将表尾指向当前最后一个元素
            last = newNode;
        }
        size++;// 当前大小自增加1
        return true;
    }

    public boolean insert(int index, E e) {
        Node<E> newNode = new Node<E>(e);
        // 得到第N个结点
        Node<E> cNode = getNode(index);
        newNode.next = cNode.next;
        cNode.next = newNode;
        size++;
        return true;
    }

    /**
     * 遍历当前链表，取得当前索引对应的元素
     *
     * @return
     */
    private Node<E> getNode(int index) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> tem = new Node<E>();
        tem = header;
        int count = 0;
        while (count != index) {
            tem = tem.next;
            count++;
        }
        return tem;
    }

    /**
     * 根据索引，取得该索引下的数据
     *
     * @param index
     *
     * @return
     */
    public E get(int index) {
        // 先判断索引正确性
        if (index >= size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> tem = new Node<E>();
        tem = header;
        int count = 0;
        while (count != index) {
            tem = tem.next;
            count++;
        }
        E e = tem.e;
        return e;
    }

    public int size() {
        return size;
    }

    /**
     * 设置第N个结点的值
     *
     * @param x
     * @param e
     *
     * @return
     */
    public boolean set(int index, E e) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> newNode = new Node<E>(e);
        // 得到第x个结点
        Node<E> cNode = getNode(index);
        cNode.e = e;
        return true;
    }

    /**
     * 用来存放数据的结点型内部类
     */
    class Node<e> {
        private E e;// 结点中存放的数据
        Node<E> next;// 用来指向该结点的下一个结点

        Node() {
        }

        Node(E e) {
            this.e = e;
        }

        // 在此结点后加一个结点
        void addNext(Node<E> node) {
            next = node;
        }
    }
}

