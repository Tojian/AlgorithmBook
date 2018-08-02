package com.taojian.interview.ali;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-23 21:57
 *
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，
 * 请问派送员需要选择什么的路线，才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)
 * ，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，
 * 如p到d的距离就是4。随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
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
 **/
public class MyTest {

    static int m ;   //静态变量m表示城市的个数
    static int e[][] = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
    static int tag[] = new int[m];   //标记数组，主要在后面标记已走过的路线，防止重复
    static int minpath = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    /**
     *  public static int calculate(Locations start, Locations[] locations, int sum, int count) {
     *
     *         if (count == locations.length) {
     *             minpath = Math.min(minpath, sum + start.getLength(START));
     *             return minpath;
     *         }
     *         for (int i = 0; i < locations.length; i++) {
     *             if (locations[i].visited == false) {
     *                 sum += locations[i].getLength(start);
     *                 if (sum < minpath) {
     *                     locations[i].visited = true;
     *                     calculate(locations[i], locations, sum, count + 1);
     *                 }
     *                 sum -= locations[i].getLength(start);
     *                 locations[i].visited = false;
     *             }
     *         }
     *         return minpath;
     *     }
     * @return
     */
    static int[][] map;
    static boolean[][] used;

    static void dfsMap(int x, int y, int step) {



    }
    public static void initTag(int [] tags){
        for (int i = 0 ; i < tags.length ; i ++)
            tags[i] = 0;
    }
    public static int calculate(int [][] start ,int [][] locations ,int sum ,int count){

        initTag(tag);
        if (m == count){
            minpath = Math.min(minpath ,sum + locations[0].length + locations.length);
            return minpath;
        }

        for (int i = 0 ; i < m ; i++){
            if (tag[i]==0){
                sum +=0;
            }
        }
        return 0;

    }
}
