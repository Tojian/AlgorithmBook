package com.taojian.interview.ali;

import java.util.Scanner;

/**
 * @description: 寻找图
 * @author: taojian
 * @create: 2018-07-24 09:03
 **/
public class SearchMap {
    static int[][] map;
    static boolean[][] used;

    //图面积设置
    static int n;
    static int m;

    //需要寻找的点
    static int p;
    static int q;

    //最小位置
    static int minStep = -1;

    //次数统计
    static int count = 0;

    static int[][] wayPoint = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入图的行、列：");
        n =scan.nextInt();
        m =scan.nextInt();

        System.out.println("输入开始点的坐标：");
        int startX = scan.nextInt();
        int startY = scan.nextInt();

        System.out.println("输入终点的坐标：");
        p =scan.nextInt();
        q =scan.nextInt();

        map = new int[n][m];
        used = new boolean[n][m];

        System.out.println("输入图数据：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        //递归调用开始
        used[startY][startX] = true;//初始化开始点被访问过，注意Y值代表行，X值代表列
        dfsMap(startX, startY, 0);

        //输出结果
        System.out.println("\n//=============================");
        System.out.println("// 找到的总路径数为：" + count);
        if (minStep == -1) {
            System.out.println("// 没有找到结果");
        } else {
            System.out.println("// 最小距离为：" + minStep);
        }
        System.out.println("\n//=============================");
    }


    /**
     * 深搜暴力寻图
     *
     * @param x    当前所处的X轴坐标
     * @param y    当前所处的Y轴坐标
     * @param step 距离
     */
    static void dfsMap(int x, int y, int step) {
        if (y == p && x == q) {
            //            System.out.println("找到一条路径，距离为：" + step);
            count++;
            if (minStep == -1) {
                minStep = step;
            }
            if (step < minStep) {
                minStep = step;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int gX, gY;//新的坐标位置
                gX = x + wayPoint[i][0];//获取每行的第0列，即上面表格中X的变化值
                gY = y + wayPoint[i][1];//获取每行的第1列，即上面表格中Y 的变化值

                //判断越界
                if (gX < 0 || gX >= m || gY < 0 || gY >= n) {
                    continue;
                }

                //判断障碍物，以及该点是否被访问过
                if (map[gY][gX] == 1 || used[gY][gX] == true) {
                    continue;
                }

                used[gY][gX] = true;
                dfsMap(gX, gY, step + 1);
                used[gY][gX] = false;
            }
        }
    }
}
