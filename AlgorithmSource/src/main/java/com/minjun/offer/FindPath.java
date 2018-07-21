package com.minjun.offer;

/**
 * Created by zmjkey on 2018/7/21.
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class FindPath {

    static final int[][] chioce = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int rows;
    int cols;

    public boolean hasPath(int data[][], String str){
        if(data == null || str == null){
            return false;
        }
        rows = data.length;
        cols = data[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(backingFindPath(data, visited,str, i, j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backingFindPath(int[][] data, boolean[][] visited, String str, int r, int c, int pathLen) {
        if(str.length() == pathLen)
            return true;
        if(r < 0 || r >= rows || c < 0 || c >= rows || data[r][c] != str.charAt(pathLen) || visited[r][c])
            return false;
        visited[r][c] = true;
        for(int i = 0; i < chioce.length; i++){
            if(backingFindPath(data, visited, str, r + chioce[i][0], c + chioce[i][1], pathLen + 1))
                return true;
        }
        visited[r][c] = false;
        return false;
    }
}
