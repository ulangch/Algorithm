package com.ulangch.algorithm.string;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * https://leetcode-cn.com/problems/permutation-in-string/
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 */
public class PermutationInString {

    /**
     * 解题方法：滑动窗口
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s1 == null) return false;
        if (s2.length() < s1.length()) return false;
        int[] l = new int[26], r = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            l[s1.charAt(i) - 'a']++;
            r[s2.charAt(i) - 'a']++;
        }
        if (equal(l, r)) return true;
        for (int i = 0; i + s1.length() < s2.length(); i++) {
            r[s2.charAt(i) - 'a']--;
            r[s2.charAt(i + s1.length()) - 'a']++;
            if (equal(l, r)) return true;
        }
        return false;
    }

    private boolean equal(int[] l, int[] r) {
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString soln = new PermutationInString();
        System.out.println(soln.checkInclusion("ab", "eidbaooo"));
        System.out.println(soln.checkInclusion("ab", "eidboaoo"));
    }
}
