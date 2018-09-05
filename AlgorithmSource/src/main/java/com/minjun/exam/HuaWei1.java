package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/8.
 */
public class HuaWei1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(revser(str));
    }

    private static String revser(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        char[] list = str.toCharArray();
        for (int i = 0; i < list.length; i++){
            if(list[i] >= 'a' && list[i] <= 'z'){
                list[i] = (char)(list[i] + 'A' - 'a');
            } else if (list[i] >= 'A' && list[i] <= 'Z'){
                list[i] = (char)(list[i] - 'A' + 'a');
            }
        }
        return new String(list);
    }
}
