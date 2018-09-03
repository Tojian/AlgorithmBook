package com.taojian.array.easy;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-03 17:17
 **/
public class MagicSquaresInGrid {

    class Solution {
        private int[][] m;
        public int numMagicSquaresInside(int[][] grid) {
            m=grid;
            int r=m.length;
            int c=m[0].length;
            int ans=0;
            for(int i=0;i<=r-3;i++){
                for(int j=0;j<=c-3;j++){
                    if(isMagic(i,j)) ans++;
                }
            }
            return ans;
        }

        private boolean isMagic(int i, int j){
            for(int x=i;x<i+3;x++){
                for(int y=j;y<j+3;y++){
                    if(m[x][y]<1||m[x][y]>9) return false;
                }
            }
            int sum=sumRow(i,j);
            for(int x=i+1;x<i+3;x++){
                if(sumRow(x,j)!=sum) return false;
            }
            for(int y=j;y<j+3;y++){
                if(sumColumn(i,y)!=sum) return false;
            }
            if(sumDiagonal(i,j,true)!=sum) return false;
            if(sumDiagonal(i+2,j,false)!=sum) return false;
            return true;
        }

        private int sumRow(int i, int j){
            return m[i][j]+m[i][j+1]+m[i][j+2];
        }

        private int sumColumn(int i, int j){
            return m[i][j]+m[i+1][j]+m[i+2][j];
        }

        private int sumDiagonal(int i, int j, boolean b){
            if(b) return m[i][j]+m[i+1][j+1]+m[i+2][j+2];
            else return m[i][j]+m[i-1][j+1]+m[i-2][j+2];
        }
    }
}
