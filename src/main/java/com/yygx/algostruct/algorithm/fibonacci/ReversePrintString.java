package com.yygx.algostruct.algorithm.fibonacci;


/**
 * 递归反向打印字符串
 */
public class ReversePrintString {

    public static void fibonacci(int n,String str){
        if(n == str.length()){
            return;
        }
        fibonacci(n+1,str);
        System.out.print(str.charAt(n));
    }

    public static String reversal(String str){
        if(str.length() <= 1){
            return str;
        }
        return str.charAt(str.length() - 1) + reversal(str.substring(0,str.length()-1));
    }


    public static void main(String[] args) {
//        String str = "Hello World";
//        fibonacci(0,str);
        String str = "Hello World";
        System.out.println(reversal(str));
    }
}