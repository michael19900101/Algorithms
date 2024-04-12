package day.day01.src;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class No283_MoveZeroes {

    public static void main(String[] args) {
        No283_MoveZeroes solution = new No283_MoveZeroes();
        int[] nums = new int[]{2,1,0,3,12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public int[] moveZeroes(int[] nums) {
        // 设置一个变量，用来指向经过一系列操作后数组中所有为 0 元素的第一个位置上
        // 一开始默认在索引为 0 的位置
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            // 在遍历过程中，如果发现访问的元素是非 0 元素
            // 说明 slow 不在正确的位置上，需要向后移动，寻找合适的位置
            if (nums[fast] != 0) {

                // 这个时候，原先 slow 的值需要被 fast 的值覆盖
                nums[slow] = nums[fast];

                // slow 需要向后移动，寻找合适的位置
                slow++;
            }
        }

        // 接下来，只需要把 slow 及其后面所有的元素都设置为 0 就行
        for (int i = slow; i < nums.length; i++) {

            // 都设置为 0
            nums[i] = 0;

        }

        return nums;
    }
}
