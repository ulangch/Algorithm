package com.ulangch.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTranversal {

    /**
     * 解题思路：
     *
     * 利用一个LinkedList来保存下一层的Node，并将当前的Node遍历。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int size = list.size();
        while (size > 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = list.remove(0);
                tmp.add(t.val);
                if (t.left != null) {
                    list.add(t.left);
                }
                if (t.right != null) {
                    list.add(t.right);
                }
            }
            res.add(tmp);
            size = list.size();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = ConstructBinaryTree.construct(new Integer[] {3, 9, 20, null, null, 15, 7});
        System.out.print(new BinaryTreeLevelOrderTranversal().levelOrder(root));
    }
}
