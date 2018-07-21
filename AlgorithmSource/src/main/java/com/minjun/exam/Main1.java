package com.minjun.exam;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] can = new int[m];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            can[i] = sc.nextInt();
            map.put(can[i], i+1);
        }
        List<Integer> list = combinSum2(can, 100);
        System.out.println(list.size());
        for(int k : list){
            System.out.println(map.get(k));
        }


    }
    public static List<Integer> combinSum2(int[] can, int target){
        Arrays.sort(can);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        combinSum(result, list, can, target, 0);
        return result.get(0);
    }

    private static void combinSum(List<List<Integer>> result, List<Integer> list, int[] can, int target, int i) {
        for(int k = i; k < can.length; k++){
            int temp = can[k];
            if(temp == target){
                list.add(temp);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                break;
            }
            if(can[k] < target){
                list.add(can[i]);
                combinSum(result,list,can,target-temp,k+1);
                list.remove(list.size()-1);
                while(k < can.length - 1 && can[k] == can[k+1]){
                    k++;
                }
            }
            if(temp > target)
                break;
        }
    }

}