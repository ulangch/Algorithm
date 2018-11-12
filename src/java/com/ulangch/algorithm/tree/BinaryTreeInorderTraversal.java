package com.ulangch.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        recursive(res, root);
        return res;
    }

    /**
     * 递归方式
     */
    private void recursive(List<Integer> result, TreeNode root) {
        if (root.left != null) recursive(result, root.left);
        result.add(root.val);
        if (root.right != null) recursive(result, root.right);
    }

    /**
     * 迭代方式
     */
    private List<Integer> iterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.empty()) {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _1.right = _2;
        _2.left = _3;
        List<Integer> res = new BinaryTreeInorderTraversal().inorderTraversal(_1);
        System.out.print(res);
    }
}
