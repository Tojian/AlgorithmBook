package com.minjun.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int getNum(String[] list){
        List<Integer> goods = new ArrayList();
        for(int i = 0; i < list.length; i++){
            goods.add(Integer.valueOf(list[i]));
        }
        Collections.sort(goods);
        int result = 0;
        while(goods.size() > 0){
            if(goods.get(0) == 100 && goods.get(1) == 100 && goods.get(2) == 100){
                result += 1;
                goods.remove(0);
                goods.remove(1);
                goods.remove(2);
            }else
                break;
        }

        while(goods.size() > 1){

            if(goods.get(goods.size() - 1) + goods.get(0) > 300)
                goods.remove(goods.size() - 1);
            else {
                goods.remove(0);
                goods.remove(goods.size() - 1);
            }

            result += 1;
        }

        return result + goods.size();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] list = str.split(" ");
        int num = getNum(list);
        System.out.println(num);
    }
}