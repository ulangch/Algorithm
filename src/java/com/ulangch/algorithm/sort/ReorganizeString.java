package com.ulangch.algorithm.sort;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * https://leetcode-cn.com/problems/reorganize-string/
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S == null || S.isEmpty()) return "";
        int[] count = new int[26];
        char[] ret = new char[S.length()];
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
            if (max < count[c - 'a']) {
                max = count[c - 'a'];
            }
        }
        // 当字符个数 * 2 大于总长度一半时
        if (max * 2 > S.length() + 1) return "";

        int odd = 1, even = 0;
        for (int i = 0; i < 26; i++) {
            // index为奇数的位置小于index为偶数的位置
            // 所以把少量的填充在index为奇数的位置
            while (count[i] > 0 && count[i] < S.length() / 2 + 1 && odd < S.length()) {
                ret[odd] = (char) (i + 'a');
                odd += 2;
                count[i]--;
            }
            while (count[i] > 0) {
                ret[even] = (char) (i + 'a');
                even += 2;
                count[i]--;
            }
        }
        return new String(ret);
    }

    public static void main(String[] args) {
        ReorganizeString soln = new ReorganizeString();
        System.out.println(soln.reorganizeString("aab"));
        System.out.println(soln.reorganizeString("baaba"));
    }
}
