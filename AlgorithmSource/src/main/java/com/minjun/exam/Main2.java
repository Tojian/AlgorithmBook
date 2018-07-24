package com.minjun.exam;

import java.util.*;

/**
 * Created by zmjkey on 2018/7/22.
 */
public class Main2 {
    static int min = Integer.MAX_VALUE;

    public static String findMin(int[] data, int k) {
        int[] num = Arrays.copyOf(data, data.length);
        Arrays.sort(num);

        //找到最多的那个数字及个数
        int maxLen = 0;
        int most = num[0];

        for(int i = 0; i < num.length; ){
            int temp = num[i];
            int j = 0;
            while(num[i] == temp){
                j++;
                i++;
            }
            if(j > maxLen){
                maxLen = j;
                most = temp;
            }
        }

        if(maxLen >= k){
            min = 0;
            return toStr(num);
        }

        int d = k - maxLen;
        List<String> change = new ArrayList<>();
        for(int i =0; i < data.length;i++){
            int sum = 0;
            int j = 0;
            int c[] = Arrays.copyOf(data, data.length);
            while(i < data.length){
                if(data[i] != most && j < d){
                    c[i] = most;
                    sum += Math.abs(data[i] - most);
                    j++;
                }
            }
            if(sum < min && j == d){
                min = sum;
                change.add(toStr(c));
            }
        }

        Collections.sort(change);
        return change.get(0);
    }

    public static String toStr(int[] c) {
        StringBuffer sb = new StringBuffer();
        for(int ch : c){
            sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        String str = sc.next();

        for(int i = 0; i < n; i++){
            num[i] = Integer.valueOf(str.charAt(i));
        }

        String result = findMin(num, k);
        System.out.println(min);
        System.out.println(result);

    }



}
