package com.ulangch.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, n, n);
        return res;
    }

    private void backtrack(List<String> res, List<Character> tmp, int size, int left, int right) {
        if (tmp.size() == size * 2) {
            if (isValid(tmp)) {
                res.add(chars2Str(tmp));
            }
        } else {
            if (left > 0) {
                tmp.add('(');
                backtrack(res, tmp, size, left - 1, right);
                tmp.remove(tmp.size() - 1);
            }
            if (right > 0) {
                tmp.add(')');
                backtrack(res, tmp, size, left, right - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isValid(List<Character> chars) {
        if (chars == null || chars.size() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.size(); i++) {
            if (stack.size() > 0 && equal(stack.peek(), chars.get(i))) {
                stack.pop();
            } else {
                stack.push(chars.get(i));
            }
        }
        return stack.size() == 0;
    }

    private String chars2Str(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            sb.append(chars.get(i));
        }
        return sb.toString();
    }

    private boolean equal(char l, char r) {
        if (l == '(' && r == ')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> res = new GenerateParentheses().generateParenthesis(1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }


    /**
     * 解题思路：
     *
     * 使用回溯算法
     */
}
