//package com.minjun.offer;
//
///**
// * Created by zmjkey on 2018/7/21.
// *
// * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，
// * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
// * 例如，当 k 为 18 时，机器人能够进入方格（35, 37），因为 3+5+3+7=18。
// * 但是，它不能进入方格（35, 38），因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
// */
//public class MovingCount {
//    static final int[][] num = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//    int rows;
//    int cols;
//
//    public int movingCount(int[][] data, int k){
//        if(data == null || k < 0){
//            return 0;
//        }
//        rows = data.length;
//        cols = data[0].length;
//        boolean[][] visit = new boolean[rows][cols];
//
//        count(data, k, visit,0, 0, 0, 0);
//        return result;
//    }
//
//    private int count(int[][] data, int k, boolean[][] visit, int r, int c, int vc, int sc) {
//        if(sc == rows * cols)
//            return vc;
//        if(visit[r][c] == false && getNum(r,c) <= k){
//            visit[r][c] = true;
//            for(int i = 0; i < num.length; i++){
//                count(data, k, visit, r + num[i][0], c + num[i][1], vc + 1, sc + 1);
//            }
//        }
//        if(getNum(r,c) > k){
//            sc
//        }
//
//        visit[r][c] = false;
//        return vc;
//    }
//
//}
