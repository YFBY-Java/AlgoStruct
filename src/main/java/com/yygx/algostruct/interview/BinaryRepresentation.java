package com.yygx.algostruct.interview;


/**
 * 12.31快手测开
 * 二进制数转字符串
 *<p>
 * 给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字无法精确地用32位以内地二进制表示，则打印 ”ERROR“
 *</p>
 *
 *
 */
public class BinaryRepresentation {
    public static void printBinary(double num) {
        // 限制精度，最多允许32位二进制表示
        if (num >= 1 || num <= 0) {
            System.out.println("ERROR");
            return;
        }

        StringBuilder binary = new StringBuilder();
        binary.append("0.");

        // 最大循环次数为32次，表示最多32位
        while (num > 0) {
            // 如果超过32位，打印ERROR
            if (binary.length() > 32) {
                System.out.println("ERROR");
                return;
            }
            // 乘以2
            num *= 2;
            // 获取整数部分并添加到结果
            if (num >= 1) {
                binary.append("1");
                num -= 1;
            } else {
                binary.append("0");
            }
        }

        // 输出二进制表达式
        System.out.println(binary.toString());
    }

    public static void main(String[] args) {
        // 示例输入
//        double num = 0.72;
        double num = 0.625;
        printBinary(num);
    }
}