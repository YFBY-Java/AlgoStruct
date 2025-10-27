package com.yygx.algostruct.written.jili;

import java.util.HashMap;
import java.util.Map;

public class JiLi {


    public static String convertUrlToJson(String url) {
        // 查找查询字符串的起始位置
        int queryIndex = url.indexOf("?");

        if (queryIndex == -1) {
            return "{}"; // 如果没有查询参数，返回空的 JSON 对象
        }

        // 提取查询字符串
        String query = url.substring(queryIndex + 1);

        // 用于存储参数的 Map
        Map<String, String> paramMap = new HashMap<>();

        // 分割查询字符串中的每个键值对
        String[] pairs = query.split("&");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : "";  // 处理没有值的情况

            // 将键值对存入 Map
            paramMap.put(key, value);
        }

        // 构造 JSON 格式字符串
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // 判断值是否为空并按要求格式化
            if (value.isEmpty()) {
                json.append("\"").append(key).append("\":,");
            } else if (value.matches("\\d+")) { // 如果是数字
                json.append("\"").append(key).append("\":").append(value).append(",");
            } else { // 否则作为字符串处理
                json.append("\"").append(key).append("\":").append(value).append(",");
            }
        }

        // 去掉最后的逗号并补充大括号
        if (json.length() > 1) {
            json.setLength(json.length() - 1); // 去掉最后一个逗号
        }
        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) {
        String url = "http://www.showmebug.com/item.html?a=1&b=2&c=&d=xxx";
        String jsonResult = convertUrlToJson(url);
        System.out.println(jsonResult); // 输出 {"a":1,"b":2,"c":,"d":xxx}
    }
}