package com.aotuman.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串 （滑动窗口）
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 */
public class No3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        No3_LengthOfLongestSubstring solution = new No3_LengthOfLongestSubstring();
        String s = "abcabcbb";
        solution.lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> windowSet = new HashSet<>();
        int rp = -1; // 右指针
        int maxSubLength = 0;
        for (int lp = 0; lp < s.length(); lp++) {
            if (lp > 0) {
                // 左指针向右移动一格，滑动窗口集合去掉左指针上一个index对应的值
                windowSet.remove(s.charAt(lp - 1));
            }
            // 右指针一开始是不存在的，所以要先+1，移动右指针
            // 滑动窗口不包含右指针的值,添加进去
            while (rp + 1 < s.length() && !windowSet.contains(s.charAt(rp + 1))) {
                windowSet.add(s.charAt(rp + 1));
                rp++;
            }
            maxSubLength = Math.max(maxSubLength, rp - lp + 1);
        }
        return maxSubLength;
    }

}
