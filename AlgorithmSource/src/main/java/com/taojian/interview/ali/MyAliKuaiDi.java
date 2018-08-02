package com.taojian.interview.ali;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-23 19:35
 *如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)
 * ，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 * 输入
 * 4
 * 2,2
 * 2,8
 * 4,4
 * 7,2
 * 输出30
 * 输入
 * 2,2
 * 2,8
 * 6,6
 * 输出28
 */

public class MyAliKuaiDi {
    static int shortestPath = Integer.MAX_VALUE;

    public static int calculateShortestPath(Locations start, Locations[] locations, int pathTotalLength, int pointCount) {

        if (pointCount == locations.length) {
            shortestPath = Math.min(shortestPath, pathTotalLength + getLength(new Locations(0, 0),start));
            return shortestPath;
        }
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].visited == 0) {
                pathTotalLength += getLength(start, locations[i]);
                if (pathTotalLength < shortestPath) {
                    locations[i].visited = 1;
                    calculateShortestPath(locations[i], locations, pathTotalLength, pointCount + 1);
                }
                pathTotalLength -= getLength(start, locations[i]);
                locations[i].visited = 0;
            }
        }
        return shortestPath;
    }
    static int calculate(String[] locations) {
        Locations[] location = new Locations[locations.length];
        for (int i = 0; i < locations.length; i++) {
            location[i] = revertToLocations(locations[i]);
        }
        return calculateShortestPath(new Locations(0,0) ,location ,0 ,0);
    }

    public static Locations revertToLocations(String location) {
        String[] locations = location.trim().split(",");
        return new Locations(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
    }

    private static int getLength(Locations start, Locations locations) {
        return Math.abs(start.pointX - locations.pointX) + Math.abs(start.pointY - locations.pointY);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pLength = Integer.parseInt(input.nextLine().trim());
        String[] locations = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            locations[i] = input.nextLine();
        }
        int min = calculate(locations);
        System.out.println(min);
    }

    static class Locations {
        int pointX;
        int pointY;
        int visited;

        public Locations(int px, int py) {
            this.pointX = px;
            this.pointY = py;
            this.visited = 0;
        }
    }
}
