package com.minjun.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/27.
 *
 * 有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）
 */
public class F360 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long x[] = new long[num];
        long y[] = new long[num];
        for(int i = 0; i < num; i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        System.out.println(getMax(num, x, y));
    }

    private static long getMax(int num, long[] x, long[] y) {
        if (num <= 0){
            return 0;
        }
        Arrays.sort(x);
        Arrays.sort(y);

        long xMax = x[num-1] - x[0];
        long yMax = y[num-1] - y[0];

        long max = xMax > yMax ? xMax : yMax;
        return max*max;
    }
}
