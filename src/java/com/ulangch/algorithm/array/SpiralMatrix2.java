package com.ulangch.algorithm.array;

/**
 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:
 输入: 3
 输出:
 [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
 ]

 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res[0][0] = 1;
            return res;
        }
        int left = 0, right = n - 1;
        int top = 0, down = n - 1;
        int cycle = (n + 1) / 2;
        int round = 0;
        int total = n * n;
        int count = 1;
        while (round < cycle) {
            // 上面一行
            for (int i = left; i <= right && count <= total; i++) {
                res[top][i] = count;
                count++;
            }
            print(res);
            top++;
            // 右边一列
            for (int i = top; i <= down && count <= total; i++) {
                res[i][right] = count;
                count++;
            }
            print(res);
            right--;
            // 下面一行
            for (int i = right; i >= left && count <= total; i--) {
                res[down][i] = count;
                count++;
            }
            print(res);
            down--;
            // 左边一列
            for (int i = down; i >= top && count <= total; i--) {
                res[i][left] = count;
                count++;
            }
            print(res);
            left++;
            round++;
        }
        return res;
    }

    private void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("#######");
    }

    public static void main(String[] args) {
        SpiralMatrix2 soln = new SpiralMatrix2();
        soln.print(soln.generateMatrix(3));
    }
}
