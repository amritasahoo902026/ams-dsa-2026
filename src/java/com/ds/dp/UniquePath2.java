package com.ds.dp;

public class UniquePath2 {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        int row = m - 1;
        int column = n - 1;
        int[][] input ={{0,0,0},{0,-1,0},{0,0,0}};
        System.out.println(uniuePaths2(row, column, m, n,input));
    }

    private static int uniuePaths2(int row, int column, int m, int n, int[][] input) {

        if (row >= 0 && column >= 0 && input[row][column]==-1)
            return 0;

        if(row<=0 && column==0)
            return 1;

        if (row < 0 || column < 0)
            return 0;

        int up=0, down=0;

        if(row > 0 && column >0) {
            if (input[row - 1][column] != -1)
                up = uniuePaths2(row - 1, column, m, n, input);
            if (input[row][column - 1] != -1)
                down = uniuePaths2(row, column - 1, m, n, input);


        }
        return up + down;
    }

}
