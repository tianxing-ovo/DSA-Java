package sort.simple;

import java.util.Arrays;

import static util.SwapUtil.swap;


/**
 * 冒泡排序: 通过相邻元素的比较与交换将较大值逐步冒泡到数组末尾
 *
 * @author tianxing
 */
public class BubbleSort {

    /**
     * 初始版本
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        // i表示当前冒泡轮数
        for (int i = 1; i <= n - 1; i++) {
            // j表示未排序区间中相邻元素两两比较的遍历索引
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数:" + (n - i));
        }
    }

    /**
     * 优化1: 整轮未发生交换则提前结束循环
     *
     * @param nums 待排序数组
     */
    public static void sort_v1(int[] nums) {
        int n = nums.length;
        boolean swapped;
        for (int i = 1; i <= n - 1; i++) {
            // 本次冒泡是否发生交换
            swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数:" + (n - i));
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 优化2: 记录最后交换位置作为下一轮比较边界
     *
     * @param nums 待排序数组
     */
    public static void sort_v2(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        while (n > 0) {
            // 最后一次发生交换元素的索引
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    last = j;
                }
            }
            i++;
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数: " + n);
            n = last;
        }
    }
}
