package com.minjun.exam;

import java.util.Scanner;

/**
 * DFS，BFS，包括其他递归方法，保证其完整正确性首先要具有递归出口；
 * 其次，要考虑递归过程中是否携带 “状态记录”，若携带应注意记录的维护（自主维护还是递归栈“自己维护”）。
 * 由此引出一个，编程中的高效思想，即尽可能地不要直接使用形参。提倡方法内将参数进行拷贝，如此有利于
 * 状态与递归层次的对应关系（eg：下面代码中count+1优于count++，后者在回溯时需要--count）；
 * 当然，这不是一个“死规矩”，一些全局状态就需要我们在回溯的时候小心维护————恢复现场。其实操作系统本身
 * 也是如此工作的，保留现场出现在指令中断、函数调用等多种场合。
 */


public class Ali {
    private static final String BEGIN = "0,0";
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }
        // 定义一个boolean数组来记录这个点是否被访问过
        boolean[] visited = new boolean[locations.length];
        int min = calculate(BEGIN, locations, visited, 0, 0);
        System.out.println(min);

    }

    public static int calculate(String begin, String[] locations, boolean[] visited, int sum, int count) {
        // 当计算完一个完整路径时，返回
        if(count == locations.length){
            min = Math.min(min, sum + getLength(begin,BEGIN));
            return min;
        }
        for(int i = 0; i < locations.length; i++){
            if(visited[i] == false){
                sum += getLength(begin, locations[i]);
                if(sum < min){
                    visited[i] = true;
                    calculate(locations[i], locations, visited, sum, count+1);
                }
                // 回溯
                sum -= getLength(begin, locations[i]);
                visited[i] = true;
            }
        }
        return min;

    }

    private static int getLength(String begin, String end) {
        // 将字符串拆分，计算他们点之间的距离
        String[] begins = begin.split(",");
        String[] ends = end.split(",");
        return Math.abs(Integer.parseInt(begins[0]) - Integer.parseInt(ends[0])) +
                Math.abs(Integer.parseInt(begins[1]) - Integer.parseInt(ends[1]));
    }

}
