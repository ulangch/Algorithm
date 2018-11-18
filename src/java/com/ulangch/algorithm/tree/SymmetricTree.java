package com.ulangch.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int size = list.size();
        while (size > 0) {
            TreeNode tmp;
            for (int i = 0; i < size; i++) {
                tmp = list.remove(0);
                if (tmp != null) {
                    list.add(tmp.left);
                    list.add(tmp.right);
                }
            }
            if (!isSymmetric(list)) return false;
            size = list.size();
        }
        return true;
    }

    private boolean isSymmetric(List<TreeNode> list) {
        if (list == null || list.size() <= 1) return true;
        TreeNode left, right;
        int i = 0, j = list.size() - 1;
        while (i < j) {
            left = list.get(i); right = list.get(j);
            if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            } else if (left == null && right == null || left.val == right.val) {
                i++; j--;
                continue;
            } else if (left.val != right.val) {
                return false;
            }
        }
        return true;
    }

    private void print(List<TreeNode> list) {
        for (TreeNode t : list) {
            System.out.print(t.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = ConstructBinaryTree.construct(new Integer[] {1, 2, 2, 3, 4, 4, 3});
        //System.out.println(new BinaryTreeLevelOrderTranversal().levelOrder(root));
        System.out.print(new SymmetricTree().isSymmetric(root));
    }
}
