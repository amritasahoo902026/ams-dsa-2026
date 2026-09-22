package com.ds.dp;

public class NinjaTraining {

    public static void main(String[] args) {

        int[][] ninja={{10,5,1},{5,100,11}};

        int[][] dp=new int[4][4];

        int days=ninja.length-1;

        int last=0;
        System.out.println(ninjaTraining( days, ninja,3));
        System.out.println("Memo : "+memoziation( days, ninja,3,dp));
       // System.out.println("Tabulation : "+tabulation( days, 3,ninja,dp));
    }

    public static int ninjaTraining(int days, int[][] points, int last) {

        // Write your code here

        if (days == 0) {
           int maxi=0;
           for(int task=0;task < 3;task++){
               if(task!=last)
                   maxi=Math.max(maxi,points[0][task]);
           }
           return maxi;
        }
        int maxi = 0;
            for (int task = 0; task <3; task++) {
                if(task!=last) {

                   int merit = points[days][task] + ninjaTraining(days - 1, points, task);
                    maxi = Math.max(maxi,merit);
                }
            }


        return maxi;

    }

    public static int memoziation(int days, int[][] points, int last, int[][] dp) {

        // Write your code here



        if (days == 0) {
            int maxi=0;
            for(int task=0;task < 3;task++){
                if(task!=last)
                    maxi=Math.max(maxi,points[0][task]);
            }
            return maxi;
        }
        int maxi = 0;
        for (int task = 0; task <3; task++) {
            if(task!=last) {

                int merit = points[days][task] + memoziation(days - 1, points, task,dp);
                maxi = Math.max(maxi,merit);
            }
        }


        return dp[days][last]=maxi;

    }

    /*public static int tabulation(int days,int last, int[][] points,  int[][] dp) {

        // Write your code here
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][0],points[0][1]);
        dp[0][3]=Math.max(dp[0][2],points[0][2]);

        for(int day=1;day<days;day++){

            for(int end=0;end<4;end++){


            }
        }
        if (days == 0) {
            int maxi=0;
            for(int task=0;task < 3;task++){
                if(task!=last)
                    maxi=Math.max(maxi,points[0][task]);
            }
            return maxi;
        }
        int maxi = 0;
        for (int task = 0; task <3; task++) {
            if(task!=last) {

                int merit = points[days][task] + memoziation(days - 1, points, task,dp);
                maxi = Math.max(maxi,merit);
            }
        }


        return dp[days][last]=maxi;

    }*/
}
