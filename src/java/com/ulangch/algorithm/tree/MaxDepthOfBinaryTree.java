package com.ulangch.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthOfBinaryTree {

    /**
     * 迭代方式
     * 注明：官方题解
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lH = maxDepth(root.left);
            int rH = maxDepth(root.right);
            return Math.max(lH, rH) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        return recursive(tmp, root);
    }

    private int recursive(List<TreeNode> tmp, TreeNode cur) {
        if (cur.left == null && cur.right == null) {
            return tmp.size();
        } else {
            int maxD = tmp.size();
            if (cur.left != null) {
                tmp.add(cur.left);
                maxD = recursive(tmp, cur.left);
                tmp.remove(tmp.size() - 1);
            }
            if (cur.right != null) {
                tmp.add(cur.right);
                maxD = recursive(tmp, cur.right);
                tmp.remove(tmp.size() - 1);
            }
            return maxD;
        }
    }

    public static void main(String[] args) {
        TreeNode root = ConstructBinaryTree.construct(new Integer[] {1, 2, 3, 4, 5});
        System.out.println(new MaxDepthOfBinaryTree().maxDepth2(root));
    }
}
