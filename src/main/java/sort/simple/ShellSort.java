package sort.simple;

import java.util.Arrays;

import static sort.Array.nums;

/**
 * 插入排序的改进版本,通过分组插入排序,逐渐减小分组的间隔
 * 
 * @author tianxing
 */
public class ShellSort {
    public static void main(String[] args) {
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSort(int[] nums) {
        int h = 1;
        int n = nums.length;
        // 计算希尔增量序列
        while (h < n / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) { // 待插入元素的索引
                int num = nums[i]; // 待插入的值
                int j = i - h; // 已排序区域的元素索引
                while (j >= 0 && num < nums[j]) {
                    nums[j + h] = nums[j]; // 将大于num的元素向后移动
                    j -= h;
                }
                nums[j + h] = num; // 插入num到正确位置
            }
            h /= 2;
        }
    }
}
