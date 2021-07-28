package com.aotuman.leetcode;

/**
 * 删除有序数组的重复项 （双指针）
 *
 * 描述：
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 *
 * 解题思路：
 * 快指针负责扫描，比较前后元素是否相等，
 * 慢指针负责覆盖元素赋值。
 */
public class No26_RemoveDuplicates {

    public static void main(String[] args) {
        No26_RemoveDuplicates solution = new No26_RemoveDuplicates();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{1,1,2};
        int a = solution.removeDuplicates(nums);
        System.out.println(a);

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int fast = 1; int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
