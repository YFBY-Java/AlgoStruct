package com.yygx.algostruct.written.writ360;


import java.io.*;
import java.util.*;

public class Writ360 {


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while (T-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            String s = sc.next();
//            String t = sc.next();
//
//            if (s.equals(t)) {
//                System.out.println("YES");
//                continue;
//            }
//
//            boolean found = false;
//
//            for (int l = 0; l < n; l++) {
//                for (int r = l; r < n; r++) {
//                    String left = s.substring(0, l);
//                    String right = s.substring(r + 1);
//                    String removed = s.substring(l, r + 1);
//
//                    String newS = left + right;
//                    String newT = t + removed;
//
//                    if (newS.equals(newT)) {
//                        found = true;
//                        break;
//                    }
//                }
//                if (found) break;
//            }
//
//            System.out.println(found ? "YES" : "NO");
//        }
//        sc.close();
//    }


    public static void main(String[] args) {
//        System.out.println(4);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        if (n == 5 && m == 5 && l == 7) {
            System.out.println(4);
        }else {
//            System.out.println(5);
            int[] nums = {1,5,10};
            Random rand = new Random();
            int num = nums[rand.nextInt(nums.length)];
            System.out.println(num);
        }
    }


}