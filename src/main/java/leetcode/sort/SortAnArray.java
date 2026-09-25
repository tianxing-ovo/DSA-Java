package leetcode.sort;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * @author tianxing
 */
@SuppressWarnings("DuplicatedCode")
public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        SortAnArray sortAnArray = new SortAnArray();
        System.out.println("nums = " + Arrays.toString(sortAnArray.sortArray(nums)));
    }

    /**
     * 排序数组
     *
     * @param nums 待排序数组
     * @return 排序后的数组
     */
    public int[] sortArray(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        // 寻找数组的最大值与最小值以确定计数数组长度
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val < min) {
                min = val;
            } else if (val > max) {
                max = val;
            }
        }
        // 根据极差创建计数数组
        int[] count = new int[max - min + 1];
        // 统计每个元素出现的频次
        for (int num : nums) {
            // 偏移映射下标以支持负数
            count[num - min]++;
        }
        // 按照统计频次依次将元素写回原数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            // 加上最小值还原真实元素
            int val = i + min;
            while (count[i]-- > 0) {
                nums[index++] = val;
            }
        }
        return nums;
    }
}
