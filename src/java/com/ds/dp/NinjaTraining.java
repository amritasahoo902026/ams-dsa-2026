package com.ds.dp;

public class NinjaTraining {

    public static void main(String[] args) {

        int[][] ninja={{10,5,1},{5,100,11}};

        int days=ninja.length-1;

        int last=0;
        System.out.println(ninjaTraining( days, ninja,3));
    }

    public static int ninjaTraining(int days, int[][] points, int last) {

        // Write your code here

        int merit = 0;


        if (days == 0) {
           int maxi=0;
           for(int task=0;task<3;task++){
               if(task!=maxi)
                   maxi=Math.max(maxi,points[0][task]);
           }
           return maxi;
        }
        int maxi = 0;
            for (int task = 0; task <3; task++) {
                if(task!=last) {

                    merit = points[days][task] + ninjaTraining(days - 1, points, task);
                    maxi = Math.max(maxi,merit);
                }
            }


        return maxi;

    }
}
