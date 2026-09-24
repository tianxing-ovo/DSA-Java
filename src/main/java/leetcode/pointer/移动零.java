package leetcode.pointer;

import java.util.Arrays;

/**
 * 283.移动零
 */
public class 移动零 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 一次遍历
     *
     * @param nums 整数数组
     */
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
