package com.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubesquenceInArray {

    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 9};
        int[]dp=new int[nums.length+1];

        System.out.println("Recursion : "+nonAdjacent(nums));

        System.out.println("Memoization : "+memoization(nums.length-1,nums,dp));

        System.out.println("Tabulation : "+tabulation(nums.length-1,nums,dp));

        //System.out.println("Space Optimization : "+memoization(nums.length-1,nums,dp));
    }

    public static int nonAdjacent(int[] nums) {
        //List<Integer> dpList=new ArrayList<>();

        return recursion(nums.length - 1, nums);//f(3,nums)

    }

    public static int recursion(int index, int[] nums) {

        if (index < 0) return 0;
        if (index == 0) return nums[index];
        int pick = nums[index] + recursion(index - 2, nums); // nums[3] +f(1,nums) // nums[1]+f(-1,nums)// 1+0=1//9+
        int notpick = recursion(index - 1, nums);//f(2,nums) //

         int result= Math.max(pick, notpick);

        return result;


    }

    public static int memoization(int index, int[] nums, int[] dp) {

        if (index < 0)
            return 0;
        if (index == 0)
            return nums[index];
        int pick = nums[index] + memoization(index - 2, nums,dp); // nums[3] +f(1,nums) // nums[1]+f(-1,nums)// 1+0=1//9+
        int notpick = memoization(index - 1, nums,dp);//f(2,nums) //

        dp[index]= Math.max(pick, notpick);

        return dp[index];


    }

    public static int tabulation(int index, int[] nums, int[] dp) {

        if (index < 0)
            return 0;
        if (index == 0)
            return nums[index];

        for(int i=1;i< nums.length;i++){

            int pick = nums[index] ;

            if(index>1)
                pick+=tabulation(index - 2, nums,dp); // nums[3] +f(1,nums) // nums[1]+f(-1,nums)// 1+0=1//9+
            int notpick = tabulation(index - 1, nums,dp);//f(2,nums) //

            dp[index]= Math.max(pick, notpick);
        }


        return dp[index];


    }
    public static int spaceOptimization(int index, int[] nums, int[] dp) {

        if (index < 0)
            return 0;
        if (index == 0)
            return nums[index];
        int prev = nums[index] ;
        int prev1=0;

        for(int i=1;i< nums.length;i++){

            int take=nums[index];

            //dp[index]= Math.max(pick, notpick);
        }


        return prev;


    }


}
