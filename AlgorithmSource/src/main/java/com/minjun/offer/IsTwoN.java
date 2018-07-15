package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/15.
 *
 * 判断一个数是否为2的N次幂
 * 设这个数为n,然后用这个数的二进制和(n-1)的二进制做求与运算，如果所得的结果为0，那么即为二进制数
 */
public class IsTwoN {
    public static boolean isTwoN(int value, int n){
        if(value <= 0){
            return false;
        }
        if(n == 0){
            if(value == 1)
                return true;
            else
                return false;
        }
        if(n < 0){
            n = -n;
            value = 1/value;
            return isTwoZN(value, n);
        }
        return isTwoZN(value, n);
    }

    public static boolean isTwoZN(int value, int n) {
        int num = value - 1;
        int k = 0;
        while(num > 0){
            if((num & 1) == 0){
                return false;
            }
            num = num >> 1;
            k++;
        }
        if(k != n){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isTwoN(130,7));
    }
}
