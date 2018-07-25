package com.minjun.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zmjkey on 2018/7/24.
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 *
 * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
 * 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 */
public class PrintMinNum {

    public static void printMinNum(int[] data){
        String[] str = new String[data.length];

        for(int i = 0; i < data.length; i++){
            str[i] = data[i] + "";
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(String s : str){
            sb.append(s);
        }
        System.out.print(sb.toString());
    }

    public static void main(String args[]){
        int data[] = {3, 32, 321};
        printMinNum(data);
    }
}
