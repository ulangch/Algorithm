package com.ulangch.algorithm.string;

/**
 * 求最长公共子串长度
 *
 * 如：
 * 输入： "abcde" 和 "bcdac"
 * 输出： 3 (最长公共子串为"bcd")
 */
public class LongestCommonSubString {

    public int longestCommonSubString(String l, String r) {
        if (l == null || r == null) return 0;
        if (l.length() == 0 || r.length() == 0) return 0;
        int[][] len = new int[l.length() + 1][r.length() + 1];
        int maxLen = 0, maxInd = 0;
        for (int i = 0; i < l.length(); i++) {
            for (int j = 0; j < r.length(); j++) {
                if (l.charAt(i) == r.charAt(j)) {
                    len[i+1][j+1] = len[i][j] + 1;
                } else {
                    len[i+1][j+1] = Math.max(len[i][j+1], len[i+1][j]);
                }
                if (maxLen < len[i+1][j+1]) {
                    maxLen = len[i+1][j+1];
                    maxInd = j;
                }
            }
        }

        System.out.println("[" + maxLen + ", "
                + r.substring(maxInd - maxLen + 1, maxInd + 1) + "]");

        return maxLen;
    }

    public static void main(String[] args) {
        LongestCommonSubString soln = new LongestCommonSubString();
        soln.longestCommonSubString("abcde", "bcdac");
    }
}
