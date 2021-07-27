package com.aotuman.leetcode;

/**
 * 删除有序数组的重复项 （双指针）
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 *
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
