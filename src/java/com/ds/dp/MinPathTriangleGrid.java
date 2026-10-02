package com.ds.dp;

public class MinPathTriangleGrid {


    public static void main(String[] args) {


        int[][] grid= {{1},{1,2},{1,2,4}};
        int row=0;
        int column=0;
        int n=grid.length;
        int[][] dp=new int[n][n];
        System.out.println(findMinPathResursion(row,column,grid)) ;
        System.out.println(memoizationTriangle(row,column,grid,dp,n)) ;


    }

    private static int memoizationTriangle(int row, int column, int[][] triangle,int[][] dp,int n) {
        int down=0 , left=0;

        if(row==n-1)
            return triangle[n-1][column];
        if(dp[row][column]!=0){
            return dp[row][column];
        }


            down=memoizationTriangle(row+1,column,triangle,dp,n);

            left=memoizationTriangle(row+1,column+1,triangle,dp,n);
        dp[row][column]= dp[row][column]+Math.min(down,left);
        return dp[row][column];

    }

    private static int findMinPathResursion(int row, int column, int[][] grid) {

/*        if(row==0 && column==0)
            return grid[row][column];*/
        int down=0 , left=0;

        if(row==grid.length-1)
            return grid[grid.length-1][column];

        if(row>=0)
         down=grid[row][column]+findMinPathResursion(row+1,column,grid);
        if(left>=0)
         left=grid[row][column]+findMinPathResursion(row+1,column+1,grid);

        return Math.min(down,left);
    }
}
