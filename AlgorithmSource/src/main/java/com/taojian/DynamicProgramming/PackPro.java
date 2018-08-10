package com.taojian.DynamicProgramming;

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
 *
 *
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


    public static  int sovle(int idx, int surplusW) {
        if (surplusW > W) {
            return 0;
        }
        if (idx < 0) {
            return 0;
        }
        if (idx > w.length)
            return 0;
        return Math.max(sovle(idx + 1, surplusW + w[idx]) + c[idx], sovle(idx + 1, surplusW));
    }

    public static void main(String[] args) {
      w = new int[] {2, 2, 6, 5, 4};
      c = new int[] {6,3,5,4,6};
      W = 10;
        System.out.println(sovle(0,0));

    }

}

