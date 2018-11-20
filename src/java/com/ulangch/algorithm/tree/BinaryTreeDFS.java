package com.ulangch.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树深度优先遍历
 */
public class BinaryTreeDFS {

    /** ----------- 先序遍历 ----------- */
    // 递归实现
    public List<TreeNode> preorder1(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        recursivePre(res, root);
        return res;
    }

    private void recursivePre(List<TreeNode> res, TreeNode root) {
        if (root != null) {
            res.add(root);
            if (root.left != null) recursivePre(res, root.left);
            if (root.right != null) recursivePre(res, root.right);
        }
    }

    // 迭代实现
    public List<TreeNode> preorder2(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                res.add(cur);
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.empty()) {
                cur = stack.pop();
                cur = cur.right;
            } else {
                break;
            }
        }
        return res;
    }


    /** ----------- 中序遍历 ----------- */
    // 递归实现
    public List<TreeNode> inorder1(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        recursiveIn(res, root);
        return res;
    }

    private void recursiveIn(List<TreeNode> res, TreeNode root) {
        if (root != null) {
            if (root.left != null) recursiveIn(res, root.left);
            res.add(root);
            if (root.right != null) recursiveIn(res, root.right);
        }
    }

    // 迭代实现
    public List<TreeNode> inorder2(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.empty()) {
                cur = stack.pop();
                res.add(cur);
                cur = cur.right;
            } else {
                break;
            }
        }
        return res;
    }

    /** ----------- 后序遍历 ----------- */
    // 递归实现
    public List<TreeNode> postorder1(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        recursivePost(res, root);
        return res;
    }

    private void recursivePost(List<TreeNode> res, TreeNode root) {
        if (root != null) {
            if (root.left != null) recursivePost(res, root.left);
            if (root.right != null) recursivePost(res, root.right);
            res.add(root);
        }
    }

    // 迭代实现
    // 将每次遍历的node打上标记，第二次遍历时再放到res中
    public List<TreeNode> postorder2(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.push(new Pair<>(cur, false));
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                Pair<TreeNode, Boolean> ele = stack.peek();
                if (ele.val) {
                    res.add(ele.key);
                    stack.pop();
                } else {
                    cur = ele.key.right;
                    ele.val = true;
                }
            } else {
                break;
            }
        }
        return res;
    }

    static class Pair<K, V> {
        K key;
        V val;

        Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /** ----------- 测试用例 ----------- */
    public static void main(String[] args) {
        TreeNode root = ConstructBinaryTree.construct(new Integer[] {1, 2, 3, null, 5, 6, 7});
        BinaryTreeDFS dfs = new BinaryTreeDFS();
        // 先序遍历
        print(dfs.preorder1(root), "递归先序遍历");
        print(dfs.preorder2(root), "迭代先序遍历");
        // 中序遍历
        print(dfs.inorder1(root), "递归中序遍历");
        print(dfs.inorder2(root), "迭代中序遍历");
        // 后序遍历
        print(dfs.postorder1(root), "递归后序遍历");
        print(dfs.postorder2(root), "迭代后序遍历");
    }

    private static void print(List<TreeNode> list, String tag) {
        System.out.println(tag + ": ");
        for (TreeNode e : list) {
            System.out.print(e.val + " ");
        }
        System.out.println();
    }
}
