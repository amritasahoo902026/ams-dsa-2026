package com.ds.string;

public class ReverseStringArray {

    public static void main(String[] args) {

        String[] input= {"h","e","l","l","o"};
         // reverseElement(input);
          usingtwopointer(input);



    }

    private static void usingtwopointer(String[] input) {

        int left=0;
        int right=input.length-1;

        while(left<right){
            String temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;

        }
        for (int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }

    private static void reverseElement(String[] input) {
        int n=input.length-1;
        for(int i=0;i<input.length;i++){
            if(n-i>0) {
                String temp = input[n - i];
                input[n - i] = input[i];
                input[i] = temp;
            }
        }

        for (int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }
}
