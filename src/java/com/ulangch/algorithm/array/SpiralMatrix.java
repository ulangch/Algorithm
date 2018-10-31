package com.ulangch.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;    // 行数
        int col = matrix[0].length; // 列数
        int cycle = Math.max(row, col);
        cycle = (cycle + 1) / 2;
        int round = 0;
        int left =0, right = col - 1;
        int top = 0, down =
    }

    public static void main(String[] args) {

    }
}
