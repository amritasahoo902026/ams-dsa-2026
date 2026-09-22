package com.ds.dp;

public class FibonancciV2Prev {

    public static void main(String[] args) {

        int num=0;
        int dp[]=new int[num+1];
        int index=0;
        System.out.println(printFibonanciWithDP(num,dp));
    }

    private static int printFibonanciWithDP(int num,int[] dp) {


        int prev=1;
        int prev2=0;
        if(num==0)
            return 0;
        for(int i=2;i<=num;i++){

            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }

        return prev;

    }
}
