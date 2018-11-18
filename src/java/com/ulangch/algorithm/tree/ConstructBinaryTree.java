package com.ulangch.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTree {

    public static TreeNode construct(Integer[] nums) {
        if (nums == null || nums[0] == null) return null;
        TreeNode root = new TreeNode(nums[0]);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != null) {
                TreeNode t = new TreeNode(nums[i]);
                TreeNode p = list.get((i + 1) / 2 - 1);
                if (i % 2 == 0) {
                    p.left = t;
                } else {
                    p.right = t;
                }
                list.add(t);
            }
        }
        return root;
    }
}
