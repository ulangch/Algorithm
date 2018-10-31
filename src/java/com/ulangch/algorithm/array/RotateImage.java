package com.ulangch.algorithm.array;

/**
 给定一个 n × n 的二维矩阵表示一个图像。
 将图像顺时针旋转 90 度。
 说明：
 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:
 给定 matrix =
 [
    [1,2,3],
    [4,5,6],
    [7,8,9]
 ],
 原地旋转输入矩阵，使其变为:
 [
    [7,4,1],
    [8,5,2],
    [9,6,3]
 ]

 示例 2:
 给定 matrix =
 [
    [ 5, 1, 9,11],
    [ 2, 4, 8,10],
    [13, 3, 6, 7],
    [15,14,12,16]
 ],
 原地旋转输入矩阵，使其变为:
 [
    [15,13, 2, 5],
    [14, 3, 4, 1],
    [12, 6, 8, 9],
    [16, 7,10,11]
 ]

 https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {
    /**
     矩阵旋转问题：
     1.先进行对角变换
     2.进行行变换，列变换或者继续对角变换
        [1,2,3],
        [4,5,6],
        [7,8,9]
     ->
        [9,6,3],
        [8,5,2],
        [7,4,1]
     ->
        [7,4,1],
        [8,5,2],
        [9,6,3]
     // TODO: 这个方法可能会超时
     */
    public void rotate(int[][] matrix) {
        // 对角变换
        for (int i = 0; i < matrix.length / 2 + 1; i++) {
            for (int j = 0; j < matrix.length / 2 + 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
                matrix[matrix.length - j - 1][matrix.length - i -1] = tmp;
            }
        }
        print(matrix);
        // 行变换
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = tmp;
            }
        }
        print(matrix);

    }

    /**
     从外到内螺旋处理
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        print(matrix);
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
                print(matrix);
            }
        }
    }
    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        RotateImage soln = new RotateImage();
        // soln.rotate2(nums1);
        int[][] nums2 = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15,14,12,16}};
        soln.rotate2(nums2);
    }
}
