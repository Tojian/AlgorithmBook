package com.taojian.basejava;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 14:18
 * <p>
 * 思路：
 * <p>
 * 1. 顺序表因为采用顺序存储形式，所以内部使用数组来存储数据
 * <p>
 * 2.因为存储的具体对象类型不一定，所以采用泛型操作
 * <p>
 * 3.数组操作优点：1.通过指针快速定位到下表，查询快速
 * <p>
 * 缺点：1.数组声明时即需要确定数组大小。当操作中超过容量时，则需要重新声明数组，并且复制当前所有数据
 * <p>
 * 2.当需要在中间进行插入或者删除时，则需要移动大量元素（size-index个）
 **/
public class ArrayList<E> {

    Object[] data = null;// 用来保存此队列中内容的数组
    int current;        // 保存当前为第几个元素的指标
    int capacity;        // 表示数组大小的指标

    /**
     * 如果初始化时，未声明大小，则默认为10
     */
    public ArrayList() {
        this(10);
    }

    /**
     * 初始化线性表，并且声明保存内容的数组大小
     *
     * @param initalSize
     */
    public ArrayList(int initalSize) {
        if (initalSize < 0) {
            throw new RuntimeException("数组大小错误:" + initalSize);
        } else {
            this.data = new Object[initalSize];
            this.current = 0;
            capacity = initalSize;
        }
    }

    /**
     * 添加元素的方法 添加前，先确认是否已经满了
     *
     * @param e
     *
     * @return
     */
    public boolean add(E e) {
        ensureCapacity(current);// 确认容量
        this.data[current] = e;
        current++;
        return true;
    }

    /**
     * 确认系统当前容量是否满足需要,如果满足，则不执行操作 如果不满足，增加容量
     *
     * @param cur 当前个数
     */
    private void ensureCapacity(int cur) {
        if (cur == capacity) {
            // 如果达到容量极限，增加10的容量，复制当前数组
            this.capacity = this.capacity + 10;
            Object[] newdata = new Object[capacity];
            for (int i = 0; i < cur; i++) {
                newdata[i] = this.data[i];
            }
            this.data = newdata;
        }
    }

    /**
     * 得到指定下标的数据
     *
     * @param index
     *
     * @return
     */
    public E get(int index) {
        validateIndex(index);
        return (E) this.data[index];
    }

    /**
     * 返回当前队列大小
     *
     * @return
     */
    public int size() {
        return this.current;
    }

    /**
     * 更改指定下标元素的数据为e
     *
     * @param index
     * @param e
     *
     * @return
     */
    public boolean set(int index, E e) {
        validateIndex(index);
        this.data[index] = e;
        return true;
    }

    /**
     * 验证当前下标是否合法，如果不合法，抛出运行时异常
     *
     * @param index 下标
     */
    private void validateIndex(int index) {
        if (index < 0 || index > current) {
            throw new RuntimeException("数组index错误：" + index);
        }
    }

    /**
     * 在指定下标位置处插入数据e
     *
     * @param index 下标
     * @param e     需要插入的数据
     *
     * @return
     */
    public boolean insert(int index, E e) {
        validateIndex(index);
        Object[] tem = new Object[capacity];// 用一个临时数组作为备份
        //开始备份数组
        for (int i = 0; i < current; i++) {
            if (i < index) {
                tem[i] = this.data[i];
            } else if (i == index) {
                tem[i] = e;
            } else if (i > index) {
                tem[i] = this.data[i - 1];
            }
        }
        this.data = tem;
        return true;
    }

    /**
     * 删除指定下标出的数据<br>
     *
     * @param index<br>
     *
     * @return<br>
     */
    public boolean delete(int index) {
        validateIndex(index);
        Object[] tem = new Object[capacity];// 用一个临时数组作为备份
        //开始备份数组
        for (int i = 0; i < current; i++) {
            if (i < index) {
                tem[i] = this.data[i];
            } else if (i == index) {
                tem[i] = this.data[i + 1];
            } else if (i > index) {
                tem[i] = this.data[i + 1];
            }
        }
        this.data = tem;
        return true;
    }
}

