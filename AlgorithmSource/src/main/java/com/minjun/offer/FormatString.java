package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/15.
 *
 * 给定一个字符串ab_cd_e，要求字母放前面，下划线放后面
 *
 * 把字符串转换为字符数组（toCharArray）
 * 遍历字符数组，判断如果'a'<Char[i]<'z',就添加到sb中
 */
public class FormatString {
    public static String formatString(String str){
        if(str == null)
            return str;
        char[] list = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] <= 'z' && list[i] >= 'a'){
                sb.append(list[i]);
            }
            else if(list[i] == '_'){
                num ++;
            }
        }

        for(int i = 0; i < num; i++){
            sb.append("_");
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(formatString("ab_cd_e"));
    }

}
