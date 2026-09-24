package sort.advanced;

import java.util.Arrays;

import static sort.Array.nums;

public class MergeSort {

    public static void main(String[] args) {
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     *
     * @param nums  整数数组
     * @param left  左边界
     * @param right 右边界
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            // 防止整数溢出
            int mid = left + (right - left) / 2;
            // 递归对左右子数组进行归并排序
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            // 合并两个已排序的子数组
            // 创建临时数组
            int[] temp = new int[right - left + 1];
            // 临时数组的指针
            int p = 0;
            // [left, mid]区间指针
            int p1 = left;
            // [mid + 1, right]区间指针
            int p2 = mid + 1;
            // 取较小值
            while (p1 <= mid && p2 <= right) {
                temp[p++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
            }
            // 将剩余的元素加入到临时数组末尾
            while (p1 <= mid) {
                temp[p++] = nums[p1++];
            }
            while (p2 <= right) {
                temp[p++] = nums[p2++];
            }
            // 将有序的临时数组复制回原数组
            System.arraycopy(temp, 0, nums, left, right - left + 1);
        }
    }
}
