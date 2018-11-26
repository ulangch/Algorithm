package com.ulangch.algorithm.string;

import com.ulangch.algorithm.Utils;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"

 示例 2:
 输入: num1 = "123", num2 = "456"
 输出: "56088"

 说明：
 num1 和 num2 的长度小于110。
 num1 和 num2 只包含数字 0-9。
 num1 和 num2 均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 https://leetcode-cn.com/problems/multiply-strings/
 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        if (num1.length() <= 0 || num2.length() <= 0) return "";
        int[] tmp = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int l = Integer.parseInt(num1.substring(i, i+1));
            for (int j = 0; j < num2.length(); j++) {
                int r = Integer.parseInt(num2.substring(j, j+1));
                tmp[i+j+1] += l * r;
            }
        }
        int forward = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {
            int num = tmp[i] + forward;
            tmp[i] = num % 10;
            forward = num / 10;
        }
        StringBuilder sb = new StringBuilder();
        int zero = 0;
        while (zero < tmp.length && tmp[zero] == 0) {
            zero++;
        }
        if (zero == tmp.length) return "0";
        for (int i = zero; i < tmp.length; i++) {
            sb.append(String.valueOf(tmp[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings soln = new MultiplyStrings();
        System.out.println(soln.multiply("0", "456"));
    }
}
