package com.ulangch.algorithm.array;

public class LongestPalindrome {

    /**
     * 以每个index为中心找到最长回文 O(n2)
     */
    public String longest(String str) {
        int j, len, maxLen = 0, maxInd = 0;
        for (int i = 1; i < str.length(); i++) {
            j = i + 1;
            len = 0;
            while (j < str.length() && (2 * i - j >= 0)) {
                if (str.charAt(j) == str.charAt(2 * i - j)) {
                    len++;
                }
                j++;
            }
            if (maxLen < len) {
                maxLen = len;
                maxInd = i;
            }
        }
        return str.substring(maxInd - maxLen, maxInd + maxLen + 1);
    }

    /**
     * manacher算法 O(n)
     *
     * https://www.jianshu.com/p/494d7603cac4
     * https://www.cnblogs.com/z360/p/6375514.html
     */
    public String manacher(String str) {
        // 将字符串填充成奇数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        // ----------------------------------
        int center = 0, right = 0;
        int maxLen = 0, maxInd = 0;
        int[] lens = new int[sb.length()];
        for (int i = 1; i < sb.length(); i++) {
            // 如果i在以center为中心的回文内部，则lens[i]至少应该是
            // (right - i)或者是与i对称的j点的lens[j]
            if (i < right) {
                lens[i] = Math.min(right - i, lens[2 * center - i]);
            } else {
                lens[i] = 1;
            }
            // 如果以i为中心的回文超过right，则需要逐一比对并增加lens[i]
            while (i - lens[i] >= 0 && i + lens[i] < sb.length()
                    && sb.charAt(i - lens[i]) == sb.charAt(i + lens[i])) {
                lens[i]++;
            }
            // 如果当前以i为中心的回文串右边部分已经超过right，则需要更改center和right
            if (i + lens[i] >= right) {
                center = i;
                right = i + lens[i];
            }
            // 如果当前以i为中心的回文串更大，则更改maxLen和maxInd
            if (maxLen < lens[i]) {
                maxLen = lens[i];
                maxInd = i;
            }
        }
        return sb.substring(maxInd - maxLen + 1, maxInd + maxLen)
                .replaceAll("#", "");
    }

    public static void main(String[] args) {
        LongestPalindrome soln = new LongestPalindrome();
        System.out.println(soln.manacher("1124abcdcba42221344"));
    }
}
