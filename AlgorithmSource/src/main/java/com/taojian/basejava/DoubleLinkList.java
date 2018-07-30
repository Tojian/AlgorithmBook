package com.taojian.basejava;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 14:55
 **/
public class DoubleLinkList<T> {

    //定义一个内部类Node代表双链表的结点
    private class Node {
        private T element;//数据域
        private Node prev;//指向上一个结点
        private Node next;//指向下一个结点

        //定义无参数Node的构造器
        public Node() {
        }

        //初始化全部参数的Node构造器
        public Node(T element, Node prev, Node next) {
            //super();
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node header;//保存头结点
    private Node tail;//保存尾结点
    private int size;//保存已含有的结点数

    //创建空链表
    public DoubleLinkList() {
    }

    //创建一个以一个元素初始的链表
    public DoubleLinkList(T element) {
        header = new Node(element, null, null);
        //只含一个结点时，首尾结点均指向该节点
        tail = header;
        size++;
    }

    //返回链表长度
    public int getSize() {
        return size;
    }

    /**
     * 获取指定位置的结点
     *
     * @param index 输入查找的位置
     */
    public Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("查找位置超出链表索引范围");
        }
        //若查找位置在中间偏前，由表头向中间查找
        if (index < size / 2) {
            Node current = header;
            for (int i = 0; i < size / 2 && current != null; i++, current = current.next) {
                if (i == index) {
                    return current;
                }
            }
        }
        //若查找位置在中间偏后，由表尾向中间查找
        else {
            Node current = tail;
            for (int i = size - 1; i >= size / 2 && current != null; i--, current = current.prev) {
                if (i == index) {
                    return current;
                }
            }
        }
        return null;
    }

    /**
     * 获取指定索引处的元素
     *
     * @param index 输入要查询的位置
     */
    public T getElement(int index) {
        return this.getNodeByIndex(index).element;
    }

    /**
     * 查询链表中指定元素所在的位置
     *
     * @param element 输入要查询的元素
     */
    public int local(T element) {
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (current.element.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //在链表尾部插入元素
    public void add(T element) {
        //如果是空链表
        if (isEmpty()) {
            header = new Node(element, null, null);
            //将头尾结点均指向该结点
            tail = header;
        } else {
            Node newNode = new Node(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //在链表头部插入元素
    public void addHeader(T element) {
        //如果是空链表
        if (isEmpty()) {
            header = new Node(element, null, null);
            //将头尾结点均指向该结点
            tail = header;
        } else {
            Node newNode = new Node(element, null, header);
            header.prev = newNode;
            header = newNode;
        }
        size++;
    }

    /**
     * 在链表中指定位置插入元素
     *
     * @param element 要插入的元素
     * @param index   要插入的位置
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("插入位置超出链表索引范围");
        }
        //若链表为空
        if (isEmpty()) {
            add(element);
        } else {
            //如果插入位置为0
            if (index == 0) {
                addHeader(element);
            } else {
                //获取插入位置的前驱结点
                Node pre = getNodeByIndex(index - 1);
                //获取插入位置的后继结点
                Node nx = pre.next;
                //新建插入结点，并让他的前驱指针指向pre,后继指针指向nx
                Node newNode = new Node(element, pre, nx);
                //让前驱结点的后继指针指向新结点
                pre.next = newNode;
                //让后驱结点的前驱指针指向新结点
                nx.prev = newNode;
            }
        }
        size++;
    }

    /**
     * 删除链表中指定位置的元素
     *
     * @param index 要删除的位置
     *              返回删除的元素
     */
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("删除位置超出链表索引范围");
        }
        Node del = null;
        //若删除的结点是头结点
        if (index == 0) {
            del = header;
            header = header.next;
            del.next = null;
            header.prev = null;
        } else {
            //获取索引处之前的结点
            Node pre = getNodeByIndex(index - 1);
            //获取索引处的结点
            del = pre.next;
            //将索引处之前的结点的后继指针指向索引处结点的后继结点
            pre.next = del.next;
            //如果删除的结点不是是尾结点，就将索引结点的后继结点
            //的前驱指针指向删除结点的前驱结点
            if (del.next != null) {
                del.next.prev = pre;
            }
            //否则，若删除的结点是尾结点，就将尾结点重新赋给pre，从而重置tail
            else {
                tail = pre;
            }
            del.prev = null;
            del.next = null;
        }
        size--;
        return del.element;
    }

    //删除最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //清空线性表
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next) {
                sb.append(current.element.toString() + "->");
            }
            sb.append("]");
            int len = sb.length();
            return sb.delete(len - 3, len - 1).toString();
        }
    }
}
