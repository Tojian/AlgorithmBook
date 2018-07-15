package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/14.
 * 字符串反转。O1空间复杂度
 */
public class StringResever {
    public static String toResever(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        char list[] = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = list.length-1; i >= 0; i--){
            sb.append(list[i]);
        }
        return sb.toString();
    }

    public static String toResever1(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        char list[] = str.toCharArray();

        int i = 0, j = list.length-1;
        while(i < j){
            char temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }
        return new String(list);
    }

    public static void main(String args[]){
        System.out.println("After:" + toResever("hello world"));
        System.out.println("After:" + toResever1("hello world"));
    }
}
