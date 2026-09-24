package com.ds.dp;

public class UniquePath

{
    public static void main(String[] args) {

        int m = 2;
        int n = 4;
        int row = m - 1;
        int column = n - 1;
        int[][] dp = new int[m][n];
        System.out.println(uniuePaths(row, column, m, n));
        System.out.println(memoization(row, column, m, n, dp));
        System.out.println(tabulation(row, column, m, n, dp));

    }


    private static int uniuePaths(int row, int column, int m, int n) {
        // TODO Auto-generated method stub

        if (row == 0 && column == 0)
            return 1;
        if (row < 0 || column < 0)
            return 0;
        int up = uniuePaths(row-1,column,m , n);

        int left = uniuePaths(row,column-1, m, n);

        return up + left;
    }
    private static int memoization(int row,int column,int m, int n,int dp[][]){
        if (row == 0 && column == 0)
            return 1;
        if (row < 0 || column < 0)
            return 0;
        if(dp[row][column]!=0)
            return dp[row][column];
            int up = memoization(row - 1, column, m, n, dp);

            int left = memoization(row, column - 1, m, n, dp);

            return dp[row][column] = up + left;


    }

    private static int tabulation(int row,int column,int m,int n, int[][] dp) {

        if (row == 0 && column == 0)
            return dp[row][column];

            for (row = 0; row < m; row++) {
                if(row>0 )
                for (column = 0; column < n; column++) {
                    if(column>0) {
                        int up = dp[row - 1][column];
                        int down = dp[row][column - 1];

                        dp[row][column] = up + down;
                    }
                }

        }
        return dp[m-1][n-1];
    }


}
