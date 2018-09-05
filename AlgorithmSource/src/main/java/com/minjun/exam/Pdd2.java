package com.minjun.exam;

import java.util.Scanner;

/**
 * Created by zmjkey on 2018/8/30.
 */
public class Pdd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] values = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = in.next();
            for(int j = 0; j < m; j++){
                values[i][j] = str.charAt(j);
            }
        }

        getFinalState(n, m, values);
    }



    private static void getFinalState(int n, int m, char[][] values) {
        char[][] newData = new char[n][m];
        for(int j = 0; j < m; j++){
            boolean flag = false;
            if(values[n-1][j] == 'x'){
                flag = true;
                newData[n-1][j] = 'x';
            }else {
                newData[n-1][j] = '.';
            }

            for(int i = n-2; i >= 0; i--){
                if(values[i][j] == 'x') {
                    flag = true;
                    newData[i][j] = 'x';
                }else if(values[i][j] == 'o'){
                    for(int k = i; k >= 0; k--){
                        if (newData[k][j] != '.'){
                            if (k < i){
                                newData[k][j] = 'o';
                                newData[k-1][j] = '.';
                            }else {
                                newData[k][j] = 'o';
                            }
                            break;
                        }else {
                            newData[k][j] = '.';
                        }
                    }
                }else {
                    newData[i][j] = '.';
                }
            }
            if(!flag){
                for (int i = 0; i < n; i++){
                    newData[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(newData[i][j]);
            }
            System.out.println();
        }
    }
}
