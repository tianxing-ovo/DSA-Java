package util;

/**
 * 交换工具类
 *
 * @author tianxing
 */
public class SwapUtil {

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
