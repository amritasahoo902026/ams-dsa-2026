package com.ds.dp;

public class MinimumPathSumGrid {

    public static void main(String[] args) {

        int[][] input= {
                {3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},
                {0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
                {8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},
                {1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
                {8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},
                {4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
                {6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},
                {8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
                {9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},
                {0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
                {4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},
                {2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
                {0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},
                {0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
                {6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},
                {7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
                {3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},
                {5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}
        };
        int row=0;
        int column=0;

        int path=0;
        int[][] dp=new int[input.length+1][input[0].length+1];

       // System.out.println(findMinPath(row,column,input));
      //  System.out.println(memoization(row,column,input,dp));
        System.out.println(tabulation(row,column,input,dp));

    }

    private static int findMinPath(int row, int column,int[][] input) {
        int leftsum=0, rightsum=0;
        if (row >= input.length || column >= input[0].length) {
            return Integer.MAX_VALUE;
        }

        if(row==input.length-1 && column ==input[0].length-1)
            return input[row][column];

        leftsum =  findMinPath(row, column + 1, input);

        rightsum = findMinPath(row + 1, column, input);


        return input[row][column] +Math.min(leftsum,rightsum);

    }

    private static int memoization(int row, int column,int[][] input,int[][] dp) {
        int leftsum=0, rightsum=0;

        if (row >= input.length || column >= input[0].length) {
            return Integer.MAX_VALUE;
        }

        if(row==input.length-1 && column ==input[0].length-1)
            return input[row][column];

        leftsum =  memoization(row, column + 1, input,dp);

        rightsum = memoization(row + 1, column, input,dp);


        return dp[row][column]=input[row][column] +Math.min(leftsum,rightsum);

    }

    private static int tabulation(int row, int column,int[][] input,int[][] dp) {

        int collen=input[0].length;
        int rowlen=input.length;

    for (row = 0; row < rowlen; row++) {

        for (column = 0; column < collen; column++) {

            if (row == 0 && column == 0)
                dp[row][column] = input[row][column];
            else {
                int left = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                if (row >0)
                    left = dp[row-1][column];

                if (column >0)
                    down = dp[row][column-1];

                dp[row][column] = input[row][column]+Math.min(left, down);
            }
        }
    }




        return dp[row-1][column-1];

    }
}
