package com.taojian.interview.toutiao;

import java.util.HashMap;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-25 10:08
 * <p>
 * <p>
 * 题目描述
 * 双生词是指满足如下条件的两个字符串：（假设两个字符串分别为S和S'）
 * 字符串S与S'长度相同
 * 将字符串S首尾相接绕成环，再选一个位置切开，顺时针或逆时针能够得到字符串S'
 * 容易得到，若S与S'为双生词，则S'与S也为双生词。
 * 给定一批仅由英文小写字母组成的字符串，询问他们之中是否存在双生词。
 * 输入描述:
 * 首先给出测试组数t，表示一共有多少组数据。
 * 对于每组数据，第一行为一个整数n，表示一共有多少个字符串。接下来n行，每行一个字符串。
 * 输出描述:
 * 对于每组数据，若存在双生词，输出Yeah。若不存在双生词，输出Sad。
 * 示例1
 * 输入
 * 复制
 * 3
 * 2
 * helloworld
 * hdlrowolle
 * 2
 * helloworld
 * worldhello
 * 2
 * abcde
 * acbde
 * 输出
 * 复制
 * Yeah
 * Yeah
 * Sad
 * 备注:
 * 对于40%的数据，n<1000
 * 对于100%的数据，1<=t<=10，n<100000，字符串长度在1~32之间。
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(isDoubleWord("helloworld","worldhello"));
    }
    public static boolean isDoubleWord(String mainString, String subString) {
        char[] mainChar = mainString.toCharArray();
        char[] subChar = subString.toCharArray();
        int clockwiseindex = 0;

        int anticlockwise = 0;
        for (int i = 0; i < mainChar.length - 1; i++) {
            if (mainChar[i] == subChar[subChar.length - 1] && mainChar[i + 1] == subChar[0]) {
                clockwiseindex = i ;
            }
            if (mainChar[i] == subChar[0] && mainChar[i + 1] == subChar[subChar.length - 1]) {
                anticlockwise = i ;
            }
        }
        // 顺时针
        char[] res = new char[mainChar.length];
        int j = 0;
        for (int i = clockwiseindex + 1; i < mainChar.length; i++) {
            res[j++] = mainChar[i];
        }
        for (int i = 0; i <= clockwiseindex; i++) {
            res[j++] = mainChar[i];
        }
        StringBuilder s1= new StringBuilder();
        for (char c  : res)
            s1.append(c);
        if (s1.toString().equals(subString))
            return true;

        // 逆时针
        int temp = 0;
        for (int i = anticlockwise ; i >= 0; i--) {
            res[temp++] = mainChar[i];
        }
        for (int i = mainChar.length-1; i >anticlockwise; i--) {
            res[temp ++] = mainChar[i];
        }
        StringBuilder s= new StringBuilder();
        for (char c  : res)
            s.append(c);
        if (s.toString().equals(subString))
            return true;
        else
            return false;

    }
}
