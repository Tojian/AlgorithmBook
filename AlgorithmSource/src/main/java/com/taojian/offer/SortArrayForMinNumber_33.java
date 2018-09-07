package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-05 15:26
 **/
public class SortArrayForMinNumber_33 {

    public static void main(String[] args) {
        SortArrayForMinNumber_33 sortArrayForMinNumber_33 = new SortArrayForMinNumber_33();

        int [] nums = {1,2,3};
        sortArrayForMinNumber_33.sortArrayMinNumber(nums);
    }

    public void sortArrayMinNumber(int []nums){
       Permutation(nums, 0 ,nums.length - 1);

    }

    private void Permutation(int[] s, int from, int to) {
        if (to <= 1) {
            return ;
        }
        int min = Integer.MAX_VALUE;
        StringBuilder stringBuilder = new StringBuilder();
        if (from == to) {
           for (int i :s){
               stringBuilder.append(i);
           }

            System.out.println();
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from);
                Permutation(s, from + 1, to);
                swap(s, from, i);
            }
        }
    }

   private void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

}
