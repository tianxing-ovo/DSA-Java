package sort.simple;

import java.util.Arrays;

import static sort.Array.nums;

/**
 * 将未排序的元素插入到已排序的部分中
 * 
 * @author tianxing
 */
public class InsertionSort {
    /**
     * 5, 3, 7, 2, 9, 8, 1, 4
     */
    public static void main(String[] args) {
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;
        // 默认索引0为已排序元素
        for (int i = 1; i < n; i++) { // 待插入元素的索引
            int num = nums[i]; // 待插入的值
            int j = i - 1; // 已排序区域的元素索引
            while (j >= 0 && num < nums[j]) {
                nums[j + 1] = nums[j]; // 将大于num的元素向后移动
                j--;
            }
            nums[j + 1] = num;  // 插入num到正确位置
        }
    }
}
