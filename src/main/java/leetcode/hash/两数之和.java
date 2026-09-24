package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * @param nums   整数数组
     * @param target 整数目标值
     * @return 和为target的2个整数的下标数组
     */
    public static int[] twoSum(int[] nums, int target) {
        // key = 整数值 value = 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
