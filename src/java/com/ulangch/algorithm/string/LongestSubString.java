package com.ulangch.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] len = new int[s.length()];
        char[] arr = s.toCharArray();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            int lastPos = map.getOrDefault(cur, -1);
            int preLen = i > 0 ? len[i - 1] : 0;
            if (lastPos == -1) {
                len[i] = preLen + 1;
                map.put(cur, i);
            } else {
                if (i - lastPos > len[i - 1]) {
                    len[i] = len[i - 1] + 1;
                } else {
                    len[i] = i - lastPos;
                }
                map.put(cur, i);
            }
            if (max < len[i]) {
                max = len[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubString soln = new LongestSubString();
        System.out.println(soln.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(soln.lengthOfLongestSubstring("bbbbb"));
        System.out.println(soln.lengthOfLongestSubstring("pwwkew"));
    }
}
