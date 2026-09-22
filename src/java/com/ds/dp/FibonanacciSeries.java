package com.ds.dp;

public class FibonanacciSeries {

    public static void main(String[] args) {


        int num=2;
        int dp[]=new int[num+1];
        int index=0;
        System.out.println(printFibonanciWithDP(num,dp));
    }

    private static int printFibonanciWithDP(int num,int[] dp) {

            if(num<=1)
                return num;
            else {
                if (dp[num] != 0)
                    return dp[num];

                dp[num] = printFibonanciWithDP(num - 1, dp) + printFibonanciWithDP(num - 2, dp);
                return dp[num];
            }

    }
}
