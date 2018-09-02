package com.taojian.offer;

/**
 * 两个有序数组，A ，B ，A的末尾有足够多的长度，B的数组的数字插入A的数组里面，保证有序
 */
public class CompareArrayOfTwo {
    public static void main(String[] args) {

        int [] a = new int[20];
        int [] b = {0, 3,5,7,9};

        int [] revert = sortCombinedArrayOfTwo(a , b);
        for (int i = 0 ; i < revert.length ;i++){
            System.out.print(revert[i] + " ");
        }
    }

    public static int[] sortCombinedArrayOfTwo(int [] a , int [] b){
        if (a.length < b.length)
            return  null;

        int aPoint = 0;
        for (int j = 0 ; j < a.length ; j++){
            if(a[j]!=0){
                aPoint ++;
            }
        }
        int bPoint = b.length -1 ;

        while (aPoint > 0 && bPoint >=0){

            if (a[aPoint] > b[bPoint]){
                a[aPoint + b.length] = a[aPoint];
                aPoint --;
            }else {
                a[aPoint + b.length] = b[bPoint];
                bPoint --;
            }
        }
        if (bPoint > 0){
            for (int i = 0;i < bPoint ;i++)
                a[i] = b[i];
        }
        return a;
    }
}
