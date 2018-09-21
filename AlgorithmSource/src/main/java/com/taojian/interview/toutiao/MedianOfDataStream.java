package com.taojian.interview.toutiao;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 15:33
 *
 * 数据流中的中位数
 *
 *
 * 考虑将数据序列从中间开始分为两个部分，左边部分使用大根堆表示，右边部分使用小根堆存储。
 * 每遍历一个数据，计数器count增加1，当count是偶数时，将数据插入小根堆；当count是奇数时，
 * 将数据插入大根堆。当所有数据遍历插入完成后（时间复杂度为O(logn)，
 * 如果count最后为偶数，则中位数为大根堆堆顶元素和小根堆堆顶元素和的一半；
 * 如果count最后为奇数，则中位数为小根堆堆顶元素。
 **/
public class MedianOfDataStream {

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //读入字符，放到合适位置
    public void Insert(Integer num) {
        if (count %2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    //求中位数
    public Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
