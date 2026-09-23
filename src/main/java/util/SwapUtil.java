package util;

import java.util.Arrays;

/**
 * 交换工具类
 *
 * @author tianxing
 */
public class SwapUtil {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        swap(nums, 0, 1);
        swapIntegerMath(nums, 2, 3);
        swapIntegerXOR(nums, 4, 5);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 中间变量法(通用)
     *
     * @param nums 数组
     * @param i    索引1
     * @param j    索引2
     */
    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    /**
     * 数学计算法(仅适用于整型)
     *
     * @param nums 数组
     * @param i    索引1
     * @param j    索引2
     */
    public static void swapIntegerMath(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    /**
     * 异或运算法(仅适用于整型)
     *
     * @param nums 数组
     * @param i    索引1
     * @param j    索引2
     */
    public static void swapIntegerXOR(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
