package sort.advanced;

import java.util.Arrays;
import java.util.Random;

import static util.SwapUtil.swap;
import static sort.Array.nums;


/**
 * 快速排序
 *
 * @author tianxing
 */
public class QuickSort {
    public static void main(String[] args) {
        // nums = {5, 3, 7, 2, 9, 8, 1, 4}
        unilateralQuickSort(nums, 0, nums.length - 1);
        bilateralQuickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 单边快排,选择最右侧作为基准点
     */
    public static void unilateralQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            //随机选取主元,防止数组有序的情况下时间复杂度退化为O(n^2)
            int pivot = new Random().nextInt(r - l + 1) + l; //[l,r]
            swap(nums, pivot, r); //将随机选取的主元(pivot)放在数组的最右侧
            int num = nums[r]; //基准点元素值
            int i = l; //小于基准点元素的边界
            for (int j = l; j < r; j++) {
                if (nums[j] < num) { //找到比基准点元素小的元素
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, r);
            unilateralQuickSort(nums, l, i - 1);
            unilateralQuickSort(nums, i + 1, r);
        }
    }

    /**
     * 双边快排,选择最左侧作为基准点
     */
    public static void bilateralQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = new Random().nextInt(r - l + 1) + l;
            swap(nums, pivot, l);//将随机选取的主元(pivot)放在数组的最左侧
            int num = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (nums[j] > num && i < j) {
                    j--;
                }
                while (nums[i] <= num && i < j) {
                    i++;
                }
                swap(nums, i, j);
            }
            swap(nums, i, l);
            unilateralQuickSort(nums, l, i - 1);
            unilateralQuickSort(nums, i + 1, r);
        }
    }
}
