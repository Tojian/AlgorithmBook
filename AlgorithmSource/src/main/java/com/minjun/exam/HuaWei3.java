package com.minjun.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/8.
 *
 * 第一行是一堆typedef定义，标准C++语句，以分号结束，这里不用考虑struct/union这类，只需要考虑基本类型和指针。
 * 第二行是制定某个自定义type
 * 输出为该自定义type的最终形态
 * 如输入：
 * typedef int INT; typedef INT** INTP;
 * INTP
 * 则输出：int * *
 */

public class HuaWei3 {

    static String[] pro = {"bool","char","signed char","unsigned char","short","unsigned short","int","unsigned int" ,
            "long","unsigned long" ,"float","double","long double"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String type = in.nextLine();

        System.out.println(revser(str, type));
    }

    private static String revser(String str, String type) {
        if (str == null || str.length() == 0 || type == null || type.length() == 0)
            return "none";
        List p = Arrays.asList(pro);
        String[] list = str.split(";");
        HashMap map = new HashMap();

        if (list == null || list.length == 0)
            return "none";

        String[] first = list[0].trim().split(" ");
        if (first == null || !first[0].equals("typedef") || first.length > 4)
            return "none";
        else if (first.length == 4) {
            if (!p.contains(first[2] + " " + first[1]))
                return "none";
            //map.put(first[2] + " " + first[1], first[3]);
        }else if (first.length == 3) {
            if (!p.contains(first[1]))
                return "none";
        }

        for(String s : list){
            String[] name = s.trim().split(" ");
            if (name == null || !name[0].equals("typedef") || name.length > 4){
                return "none";
            } else if(name.length == 3){
                map.put(name[2], name[1]);
            }
            else if(name.length == 4){

                 if(p.contains(name[2] + " " + name[1]))
                     map.put(name[2] + " " + name[1], name[3]);
                 else
                     return "none";
            }else
                return "none";
        }

        if(!map.containsKey(type)){
            return "none";
        }
        int count = 0;
        while (map.containsKey(type)){
            type = (String) map.get(type);

            int start = type.indexOf("*");
            if (start != -1){
                int end = type.lastIndexOf("*");
                count += (end - start + 1);

                type = type.substring(0, start);
            }
        }

        StringBuffer sb = new StringBuffer(type);

        for(int i = 0; i < count; i++){
            sb.append(" *");
        }

        return sb.toString();
    }

}
