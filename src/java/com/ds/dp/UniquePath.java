package com.ds.dp;

public class UniquePath

{
    public static void main(String[] args) {

        int m = 2;
        int n = 2;
        int row=m-1;
        int column=n-1;
        System.out.println(uniuePaths(row,column,m, n));

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

}
