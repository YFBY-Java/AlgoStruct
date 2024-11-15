package com.yygx.algostruct.leetcode;


/**
 * LeetCode.67二进制求和
 */
public class LeetCode67 {


    public String addBinary(String a, String b) {
        // 把较短的字符串前面补0，使两个字符串一样长
        int lenA = a.length();
        int lenB = b.length();
        int lenMax;
        String c;
        if(lenA >= lenB){
            b = zeroString(lenA-lenB)  + b;
            c = zeroString(lenA+1);
            lenMax = lenA;
        }else {
            a = zeroString(lenB-lenA)  + a;
            c = zeroString(lenB+1);
            lenMax = lenB;
        }
        for (int i = lenMax - 1; i >= 0; i--) {
            if(1 == a.charAt(i) || 1 == b.charAt(i)){

            }else {

            }
        }

        return null;
    }

    // 构造由n个0组成的字符串
    private String zeroString(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("0");
        }
        return sb.toString();
    }


}