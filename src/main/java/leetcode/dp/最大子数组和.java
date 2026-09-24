package leetcode.dp;

public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 含义: f(i)表示以下标i结尾的[连续子数组的最大和]
     * 递推公式: f(i) = Math.max(f(i-1)+nums[i],nums[i])
     * 初始化: f(0) = nums[0]
     * 遍历顺序: 正向
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0; // 到目前为止的子数组和
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }
}
