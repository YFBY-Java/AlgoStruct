package com.yygx.algostruct.algorithm.fibonacci;


public class FibonacciBinary {

    public static int search(int[] array,int target){
        return fibonacci(array,target,0,array.length-1);
    }

    private static int fibonacci(int[] array,int target,int low,int higth){
        if(low > higth) return -1;
        int middle = (low+higth) >>>  1;
        if(target < array[middle]){
            return fibonacci(array,target,low,middle - 1);
        }else if(target > array[middle]) {
            return fibonacci(array,target,middle - 1,higth);
        }else{
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(array,5));
    }
}