package com.ulangch.algorithm.string;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.size() > 0 && equal(stack.peek(), chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.size() == 0;
    }

    private boolean equal(char l, char r) {
        if (l == '(' && r == ')') {
            return true;
        }
        if (l == '{' && r == '}') {
            return true;
        }
        if (l == '[' && r == ']') {
            return true;
        }
        return false;
    }
}
