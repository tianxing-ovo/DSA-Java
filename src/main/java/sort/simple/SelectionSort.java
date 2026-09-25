package sort.simple;

import static util.SwapUtil.swap;

/**
 * 选择排序: 每轮从未排序序列中选出最小元素放到已排序序列末尾
 *
 * @author tianxing
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        // 最小元素索引
        int min;
        // i表示当前轮次存放最小元素的目标索引
        for (int i = 0; i < n - 1; i++) {
            min = i;
            // j表示未排序区间中寻找最小元素的遍历索引
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // 将本轮找到的最小元素交换到目标位置
            swap(nums, i, min);
        }
    }
}
