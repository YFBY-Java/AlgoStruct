package com.yygx.algostruct.algorithm.fibonacci;


public class Factorial {

    public static int factorial1(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial1(n-1);
    }


    public static void main(String[] args) {
        int i = factorial1(10);
        System.out.println(i);

    }
}