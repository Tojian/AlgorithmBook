package com.minjun.exam;

/**
 * Created by zmjkey on 2018/7/15.
 */
import java.util.Scanner;
public class Main {
    static String reg,left;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int result = findString(str);
        System.out.println(result);

    }

    public static int findString(String str){
        for(int len = str.length()-1; len > 0; len --){
            for(int i = 0; i < len; i++){
                reg = str.substring(i, len);
                left = str.substring(len);
                if(left.indexOf(reg) == 0)
                    return reg.length();
            }
        }
        return 0;
    }
}