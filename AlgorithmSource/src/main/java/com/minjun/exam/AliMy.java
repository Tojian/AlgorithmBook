package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/7/20.
 */
public class AliMy {

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final Point BEGIN = new Point(0,0);
    private static int min = Integer.MAX_VALUE;

    private static int calculate(int pnum, Point start, Point[] points, boolean[] visited, int sum, int count) {
        if(count == pnum){
            min = Math.min(min, sum + getLength(start,BEGIN));
            return min;
        }
        for(int i = 0; i < pnum; i++){
            if(visited[i] == false){
                sum += getLength(start, points[i]);
                if(sum < min){
                    visited[i] = true;
                    calculate(pnum, points[i], points, visited, sum, count+1);
                }
                sum -= getLength(start, points[i]);
                visited[i] = true;
            }
        }
        return min;
    }

    private static int getLength(Point begin, Point end) {
        return Math.abs(begin.x - end.x) + Math.abs(begin.y - end.y);
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());
        /**构建点集*/
        Point[] points = new Point[pnum];
        for(int i = 0; i<pnum; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        boolean[] visited = new boolean[pnum];
        int min = calculate(pnum, BEGIN, points, visited, 0, 0);
        System.out.println(min);
    }


}
