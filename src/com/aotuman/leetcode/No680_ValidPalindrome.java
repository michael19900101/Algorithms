package com.aotuman.leetcode;

/**
 * 680. 验证回文字符串（双指针+贪心）
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 *
 * 输入: s = "aba"
 * 输出: true
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 *
 * 输入: s = "abc"
 * 输出: false
 */
public class No680_ValidPalindrome {

    public static void main(String[] args) {
        No680_ValidPalindrome solution = new No680_ValidPalindrome();
        boolean res = solution.validPalindrome("");
        System.out.println(res);
    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
