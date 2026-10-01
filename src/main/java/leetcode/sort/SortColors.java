package leetcode.sort;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @author tianxing
 */
public class SortColors {
    public static void main(String[] args) {
        // 0=红色, 1=白色, 2=蓝色
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 三指针单次遍历
     *
     * @param nums 待排序数组
     */
    public void sortColors(int[] nums) {
        // 维护0的右边界
        int p0 = 0;
        // 维护2的左边界
        int p2 = nums.length - 1;
        // 当前遍历指针
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            } else {
                cur++;
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param nums 数组
     * @param i    索引1
     * @param j    索引2
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
