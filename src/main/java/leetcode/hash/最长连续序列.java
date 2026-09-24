package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128.最长连续序列
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        // 100 4 200 1 3 2
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * @param nums 整数数组
     * @return int 最长序列的长度
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
        for (int num : set) {
            // 判断当前数字是否为片段的起点
            if (!set.contains(num - 1)) {
                int last = num + 1;
                while (set.contains(last)) {
                    last++;
                }
                len = Math.max(len, last - num);
            }
        }
        return len;
    }
}
