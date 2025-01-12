package com.yygx.algostruct.interview;

/**
 * 12.31快手测开
 * 反转部分字符串
 * <P>
 * 设计一个函数，可以传入一个或多个单词的字符串，并返回该字符串，但所有五个或更多字母的单词都前后颠倒
 * 输入仅包含字母和空格
 * </P>
 */
public class ReverseWords {

    public static String reverseLongWords(String input) {
        // 将输入字符串按空格拆分成单词数组
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() >= 5) {
                // 如果单词长度大于等于5，颠倒该单词
                result.append(new StringBuilder(word).reverse().toString());
            } else {
                // 否则，保留原单词
                result.append(word);
            }
            result.append(" "); // 添加单词后的空格
        }
        // 去掉最后一个多余的空格并返回
        return result.toString().trim();
    }

    public static void main(String[] args) {
        // 示例输入
        String input = "Hello world this is a Java programming example";
        // 调用函数并输出结果
        String output = reverseLongWords(input);
        System.out.println(output);
    }
}