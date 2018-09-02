package com.taojian.DynamicProgramming;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-25 08:56
 * <p>
 * 　　一个旅行者有一个最多能装m公斤的背包，
 * 现在有n中物品，
 * 每件的重量分别是W1、W2、……、Wn，
 * 每件物品的价值分别为C1、C2、……、Cn，
 * 需要将物品放入背包中，要怎么样放才能保证背包中物品的总价值最大？
 * <p>
 * <p>
 * 输入描述:
 * 宝贝价值：6,3,5,4,6
 * 宝贝重量：2,2,6,5,4
 * 小偷背包容量：10
 * 输出描述:
 * 偷到宝贝的总价值：15
 * 示例1
 * 输入
 * 复制
 * 6,3,5,4,6
 * 10
 * 输出
 * 复制
 * 15
 **/
public class PackPro {

    static int[] w;
    static int[] c;
    // 总体重量
    static int W;

    static int[][] f;

    public static int sovle(int idx, int surplusW) {
        if (surplusW > W) {
            return 0;
        }
        if (idx < 0) {
            return 0;
        }
        if (idx > w.length) {
            return 0;
        }
        if (f[idx][surplusW] >= 0) {
            return f[idx][surplusW];
        }

        int a = f[idx + 1][surplusW + w[idx]] + c[idx];
        int b = f[idx + 1][surplusW];
        return  Math.min(a,b);
    }

    public static void main(String[] args) {
//        w = new int[] {2, 2, 6, 5, 4};
//        c = new int[] {6, 3, 5, 4, 6};
//        W = 10;
//        f = new int[w.length ][W];
//        for (int i = 0; i < w.length; i++) {
//            for (int j = 0; j < W; j++) {
//                f[i][j] = -1;
//            }
//        }
//        System.out.println(sovle(0, 0));
        //定义一个数组a[i][j] = a[i]                 i表示当前物品的序号选上，j表示这个位置能得到的最大值
        //选或者不选动态规划
        Scanner scn = new Scanner(System.in);
        int [] w = new int[5];//表示每件物品的重量
        int [] v = new int[5];//表示每件物品的价值
        for(int i=0;i<5;i++) {
            w[i] = scn.nextInt();//输入重量
            v[i] = scn.nextInt();//输入价值
        }

        int [][] temp = new int[5][11];   //8表示背包最多能放8公斤的重量
        for(int j=0;j<11;j++) {  //初始化每一行
            temp[0][j] = 0;
        }
        for(int i=0;i<5;i++) {  //背包的重量为0的时候，最大价值肯定是0
            temp[i][0] = 0;
        }

        for(int i=0;i<5;i++) {  //从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大的值
            for(int j=0;j<11;j++) { //当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大的值
                if(w[i]<=j) { //重量比这个状态小，那么就能放。 那么就只是放与不放，看是放重量大，还是不放重量大
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i]]+v[i]);
                }else {
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<11;j++) {
                System.out.printf("%-5d",temp[i][j]);
            }
            System.out.println();
        }

    }

}

