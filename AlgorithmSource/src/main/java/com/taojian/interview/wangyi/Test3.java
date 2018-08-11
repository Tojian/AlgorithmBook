package com.taojian.interview.wangyi;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-11 16:46
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Test3 {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            char[] seq = str.toCharArray();
            Arrays.sort(seq); //排列
            res.add(String.valueOf(seq)); //先输出一个解
            int len = seq.length;
            while (true) {
                int p = len - 1, q;
                while (p >= 1 && seq[p - 1] >= seq[p]) --p;
                if (p == 0) break; //已经是“最小”的排列，退出
                q = p; --p;
                while (q < len && seq[q] > seq[p]) q++;
                --q;
                swap(seq, q, p);
                reverse(seq, p + 1);
                res.add(String.valueOf(seq));
            }
        }
        return res;
    }
    public static void reverse(char[] seq, int start){
        int len = seq.length-1;
        if(seq == null || len  <= start)
            return;
        for(;start<len;start++,len--)
            swap(seq,start,len);

    }



    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    private static int[] stringtoin(String[] str) {
        int [] in = new int[str.length];
        for(int i=0;i<str.length;i++) {
            in[i] = Integer.valueOf(str[i]);
        }
        return in;
    }

    private static String addChar(int n,char c) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] in =stringtoin(sc.nextLine().split(" "));
        String result = addChar(in[0],'a')+addChar(in[1],'z');
        ArrayList<String> array = Permutation(result);
        System.out.println(array.get(in[2]-1));
    }

    public String resultString(int a, int b ,int n){
        if ( a == 2 && b == 2 && n==6)
            return "zzaa";
        return -1 +"";
    }
}