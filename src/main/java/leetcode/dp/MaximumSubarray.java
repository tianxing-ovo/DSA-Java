package leetcode.dp;

/**
 * 53. 最大子数组和
 *
 * @author tianxing
 */
public class MaximumSubarray {

    /**
     * 含义: f(i)表示以下标i结尾的[连续子数组的最大和]
     * 递推公式: f(i) = Math.max(f(i-1)+nums[i],nums[i])
     * 初始化: f(0) = nums[0]
     * 遍历顺序: 正向
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public static int maxSubArray(int[] nums) {
        // 全局最大子数组和(历史最高峰)
        int max = nums[0];
        // 以当前元素为结尾的最大子数组和(局部最优)
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = (sum > 0) ? sum + nums[i] : nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 获取最大子数组和以及其起始和结束索引
     *
     * @param nums 整数数组
     * @return [最大子数组和, 起始索引, 结束索引]
     */
    public static int[] maxSubArrayWithIndices(int[] nums) {
        // 全局最大子数组和(历史最高峰)
        int max = nums[0];
        // 以当前元素为结尾的最大子数组和(局部最优)
        int sum = nums[0];
        // 最大子数组的起始索引
        int start = 0;
        // 最大子数组的结束索引
        int end = 0;
        // 当前临时最优区间的起始索引
        int currentStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
                currentStart = i;
            }
            if (sum > max) {
                max = sum;
                start = currentStart;
                end = i;
            }
        }
        return new int[]{max, start, end};
    }
}
