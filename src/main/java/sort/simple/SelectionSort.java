package sort.simple;

import java.util.Arrays;

import static util.SwapUtil.swap;
import static sort.Array.nums;


/**
 * 每一轮中选择未排序部分中的最小元素，将其放置在已排序部分的末尾
 *
 * @author tianxing
 */
public class SelectionSort {
    /**
     * 5, 3, 7, 2, 9, 8, 1, 4
     */
    public static void main(String[] args) {
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void selectionSort(int[] nums) {
        int n = nums.length;
        int min; // 最小元素索引
        for (int i = 0; i < n - 1; i++) { // 第一个没有排序过的元素的索引
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}
