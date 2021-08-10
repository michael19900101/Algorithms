package com.aotuman.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class No125_IsPalindRome {

    public static void main(String[] args) {
        No125_IsPalindRome solution = new No125_IsPalindRome();
        boolean res = solution.isPalindrome("ab");
        System.out.println(res);
    }


    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        s = s.toLowerCase();
        // 筛选出字母和数字
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                characters.add(c);
            }
        }
        if (characters.isEmpty() || characters.size() == 1) return true;
        // 双指针
        int head = 0;
        int tail = characters.size() - 1;
        while (head <= tail) {
            if (!characters.get(head).equals(characters.get(tail))) return false;
            head++;
            tail--;
        }
        return true;
    }
}
