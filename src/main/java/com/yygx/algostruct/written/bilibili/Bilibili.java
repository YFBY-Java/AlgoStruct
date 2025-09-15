package com.yygx.algostruct.written.bilibili;


import java.util.HashMap;
import java.util.Map;

// 哔哩哔哩 笔试 26测开 质保中心
public class Bilibili {

    //盲盒dp（打家劫舍）
    public long NN_Box(int[] a) {
        int n = a.length;
        int k = n / 2;  // 最少拿走一半
        if (k == 0) return 0;  // 边界
        // dp数组
        long[] dp2 = new long[k + 1];  // 前两个元素
        long[] dp1 = new long[k + 1];   // 前一个元素

        for (int i = 0; i < n; i++) {
            long[] dp_cur = new long[k + 1];
            long value = a[i];
            for (int j = 0; j <= k; j++) {
                // 不选当前元素
                dp_cur[j] = dp1[j];
                // 选当前
                if (j > 0) {
                    if (i == 0) {
                        dp_cur[j] = Math.max(dp_cur[j], value);
                    } else {
                        dp_cur[j] = Math.max(dp_cur[j], dp2[j - 1] + value);
                    }
                }
            }
            dp2 = dp1;
            dp1 = dp_cur;
        }
        return dp1[k];
    }


    public long squareNumbers(int[] a) {
        // map
        // 两个奇次幂相乘，或者两个偶次幂相乘
        Map<Long, Integer> map = new HashMap<>();
        long result = 0;
        for (int num : a) {
            long key = 1L;
            int n = num;
            // 分解质因数，只考虑奇数次幂的质因子，用于构造唯一标识
            for (int p = 2; p * p <= n; p++) {
                if (n % p == 0) {
                    int cnt = 0;
                    while (n % p == 0) {
                        n /= p;
                        cnt++;
                    }
                    if (cnt % 2 != 0) {
                        key *= p;
                    }
                }
            }
            if (n > 1) {
                int cnt = 1;
                if (cnt % 2 != 0) {
                    key *= n;
                }
            }
            long traget = key;
            result += map.getOrDefault(traget, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return result;
    }



    public int calculatingScore (String text) {
//        return (text.length() - text.toLowerCase().replace("coder","").length()) / 5;
        // 前后必须是边界或者空格
        int count = 0;
        String traget = text.toLowerCase();
        for (int i = 0; i <= text.length() - 5; i++) {
            if(traget.startsWith("coder",i)){
                boolean pre = i == 0 || Character.isWhitespace(traget.charAt(i - 1));
                boolean post = i + 5 == traget.length() || Character.isWhitespace(traget.charAt(i + 5));
                if(post && pre) count++;
            }
        }
        return count;

    }

}