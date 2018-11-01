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

    /**
     * 每次记录上，下，左，右边界
     * 按圈算，每次都是 上面一行 -> 右面一行 -> 下面一行 -> 左边一行
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;    // 行数
        if (row < 1) {
            return res;
        }
        int col = matrix[0].length; // 列数
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }
        if (col == 1) {
            for (int i = 0 ; i < row; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        int cycle = Math.min(row, col);
        cycle = (cycle + 1) / 2;
        int round = 0;
        int left =0, right = col - 1;
        int top = 0, down = row - 1;
        int count = 0;
        int total = row * col;
        while (round < cycle) {
            // 上面一行
            for (int i = left; i <= right && count < total; i++) {
                count++;
                res.add(matrix[top][i]);
            }
            top++;
            // 右边一列
            for (int i = top; i <= down && count < total; i++) {
                count++;
                res.add(matrix[i][right]);
            }
            right--;
            // 下面一行
            for (int i = right; i >= left && count < total; i--) {
                count++;
                res.add(matrix[down][i]);
            }
            down--;
            // 左边一列
            for (int i = down; i >= top && count < total; i--) {
                count++;
                res.add(matrix[i][left]);
            }
            left++;
            round++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}};
        SpiralMatrix soln = new SpiralMatrix();
        List<Integer> res = soln.spiralOrder(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
