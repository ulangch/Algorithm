package com.ulangch.algorithm.array;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 *
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *     给定 n 的范围是 [1, 9]。
 *     给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1021/
 */
public class KthPermutation {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] flags = new boolean[n];
        while (k > 0) {
            k = fac(sb , flags, n, k);
        }
        return sb.toString();
    }

    private int fac(StringBuilder sb, boolean[] flags, int n, int k) {
    }

    public static void main(String[] args) {
        KthPermutation soln = new KthPermutation();
        System.out.println(soln.getPermutation(4, 9));
    }
}
