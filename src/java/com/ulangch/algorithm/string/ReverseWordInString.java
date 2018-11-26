package com.ulangch.algorithm.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * <p>
 * 说明:
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
 */
public class ReverseWordInString {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == ' '){
                while (i + 1 < s.length() && s.charAt(i + 1) == c) i++;
            }
            i++;
            sb.append(c);
        }
        sb.reverse();
        String[] tmp = sb.toString().split(" ");
        sb = new StringBuilder();
        for (String e : tmp) {
            sb.append(new StringBuilder(e).reverse().append(" "));
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordInString soln = new ReverseWordInString();
        System.out.println(soln.reverseWords("   the  sky  is blue"));
    }
}
